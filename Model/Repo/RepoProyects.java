package Model.Repo;

import Interface.Repo_Interface.IRepoProyects;
import Model.Entity.Proyect;

import Model.Entity.Task;
import Model.Entity.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class RepoProyects extends AbstractRepository<Proyect> implements IRepoProyects {
    public RepoProyects() {
        super(new HashSet<>());
    }

    public Set<Proyect> getProyects() {
        return elements;
    }

    /**
     * Obtiene un proyecto del repositorio mediante su identificador
     *
     * @param id   El identificador del proyecto a buscar
     * @param user El usuario que se va a comprobar si es el creador
     * @return El proyecto encontrado, o null si no se encontró ningún proyecto con ese identificador
     */
    @Override
    public Proyect getByID(String id, User user) {
        Proyect result = null;
        for (Proyect proyect : elements) {
            if (proyect.getId().equals(id) &&
                    user.equals(proyect.getProjectCreator())) {
                result = proyect;
                break;
            }
        }
        return result;
    }

    /**
     * Actualiza un proyecto en el repositorio
     *
     * @param data El proyecto con los datos actualizados
     * @return El verdadero, si se ha actualizado si se encontró y actualizó correctamente,
     * o false si no se encontró
     */
    @Override
    public Proyect update(Proyect data) {
        Proyect result;
        result = getByID(data.getId());
        if (result != null) {
            elements.remove(result);
            elements.add(data);
            result = data;
        }
        return result;
    }

    /**
     * Función encargada de actualizar los datos de un usuario a los proyectos que el ha creado.
     *
     * @param newUser que se trata de los nuevos datos de usuario.
     */
    @Override
    public void update(User newUser) {
        for (Proyect proyect : elements) {
            if (proyect.getProjectCreator().equals(newUser)) {
                proyect.setProjectCreator(newUser);
            }
        }
        updateTasks(newUser);
    }

    /**
     * Función encargada de actualizar las todas las tareas de los proyectos, en las cuales el usuario que recibe la
     * función es el colaborador
     *
     * @param newUser los datos del nuevo usuario que se van a actualizar
     */
    private void updateTasks(User newUser) {
        for (Proyect proyect : elements) {
            for (Task task : proyect.getElements()) {
                for (int i = 0; i < task.getColaboratorToCharge().length; i++) {
                    if (task.getColaboratorToCharge()[i].equals(newUser)) {
                        task.getColaboratorToCharge()[i] = newUser;
                    }
                }
            }
        }
    }


    /**
     * Elimina un proyecto del repo de proyectos utilizando su identificador
     * Esta función borra, independientemente del usuario que haya logueado. CUIDADO
     *
     * NOTA: Esta función se desarrollo con la idea de hace pruebas, y de que en un futuro creasemos superadministradores
     * Todavía NO se pone en uso
     *
     * @param id El identificador del proyecto a eliminar
     * @return Devuelve el proyecto que se a eliminado
     */
    @Override
    public Proyect delete(String id) {
        Proyect proyect = null;
        Iterator<Proyect> iterator = getProyects().iterator();
        while (iterator.hasNext()) {
            Proyect tmpProyect = iterator.next();
            if (tmpProyect.getId().equals(id)) {
                proyect = tmpProyect;
                iterator.remove();
            }
        }
        return proyect;
    }

    /**
     * Segun el usuario que se le pasa comprueba en que proyectos tiene al menos asignado una tarea
     * y devuelve aquellos proyectos en los que se encuentra
     *
     * @param user El usuario que va a buscar los proyectos en los que esta
     * @return devuelve un arraylist de todos los proyectos en los que esta el usuario
     */
    @Override
    public ArrayList<Proyect> retrieveUserColaboratorProyects(User user) {
        ArrayList<Proyect> proyectsColaborator = new ArrayList<>();

        for (Proyect proyect : elements) {
            for (Task task : proyect.getElements()) {
                for (User tmpuser : task.getColaboratorToCharge()) { //CORTAR ESTO PARA QUE NO AÑADA 2 VECES EL MISMO PROYECTO
                    if (tmpuser.equals(user)) {
                        proyectsColaborator.add(proyect);
                    }
                }
            }
        }
        return proyectsColaborator;
    }


    /**
     * Se le pasa un usuario y una id de proyecto y con esta información busca si hay algun proyecto con esas caracteristicas
     *
     * @param user que va a ser el colaborador de la tarea
     * @param idProyecto es el identificador de proyecto y es por donde se va a buscar este
     * @return el proyecto con el colaborador user y la id entregada
     */
    @Override
    public Proyect retrieveProyectIfColaborator(User user, String idProyecto) {
        Proyect proyect = null;
        for (Proyect proyects : elements) {
            for (Task tmpUser : proyects.getElements()) {
                for (int i = 0; i < tmpUser.getColaboratorToCharge().length; i++) {
                    if (proyects.getId().equals(idProyecto) && tmpUser.getColaboratorToCharge()[i].equals(user)) {
                        proyect = proyects;
                    }
                }
            }
        }
        return proyect;
    }

    /**
     * Recupera una tarea asociada con un usuario específico y un ID de tarea.
     *
     * @param userToCharge El usuario a cargar para la tarea.
     * @param idTask       El ID de la tarea a recuperar.
     * @return La tarea recuperada, o null si no se encuentra.
     */
    @Override
    public Task retrieveTask(User userToCharge, String idTask) {
        Task task = null;
        for (Proyect proyect : elements) {
            for (Task tmpTask : proyect.getElements()) {
                for (int i = 0; i < tmpTask.getColaboratorToCharge().length; i++) {
                    if (tmpTask.getId().equals(idTask)
                            && tmpTask.getColaboratorToCharge()[i].equals(userToCharge)) {
                        task = tmpTask;
                    }
                }
            }
        }
        return task;
    }

    /**
     * Función encargada de recuperar una tarea, de un proyecto en especifico
     * @param idTarea que será la clave de la tarea con la que se comparara para recuperarla
     * @param proyect el proyecto sobre el que se va a recuperar la tarea
     * @return un objeto que del tipo tarea, que si no se encuentra, sera null
     */
    @Override
    public Task retrieveTaskFromProject(String idTarea, Proyect proyect) {
        Task taskToReturn = null;

        for (Task task : proyect.getElements()) {
            if (task.getId().equals(idTarea)) {
                taskToReturn = task;
            }
        }

        return taskToReturn;
    }

    /**
     * Actualiza una tarea dentro de un proyecto.
     * @param task La tarea a actualizar
     * @param proyect El proyecto en el que se actualizará la tarea
     * @return true si la tarea se actualizó correctamente,
     * false si no se encontró la tarea o el proyecto
     */
    @Override //ESTO VOY A TENER QUE MIRARLO CON DETALLE PORQUE ME HAS METIDO 2 BREAKS Y NOS LA PODEMOS CARGAR
    public boolean updateTask(Task task, Proyect proyect) {
        boolean updated = false;
        for (Proyect tmpProyect : elements){
            if (tmpProyect.equals(proyect)){
                for (Task tmpTask : proyect.getElements()){ //AQUI HABRÍA QUE CORTARLO DE OTRA MANERA, ESTO NO ES UN SET
                    if (tmpTask.equals(task)){
                        tmpProyect.getElements().remove(tmpTask);
                        tmpProyect.addElement(task);
                        updated = true;
                        break;
                    }
                }
                if (updated){
                    break;
                }
            }
        }
        return updated;
    }
}
