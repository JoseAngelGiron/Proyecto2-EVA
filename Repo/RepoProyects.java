package Repo;

import Interface.IRepoProyects;
import Model.Proyect;

import Model.Task;
import Model.User;

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
        Proyect result = null;
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
     * Elimina un proyecto de la lista de usuarios utilizando su identificador
     *
     * @param id El identificador del proyecto a eliminar
     * @return Devuelve el proyecto que se a eliminado
     */
    @Override
    public Proyect delete(String id) {
        Proyect proyect = null;
        Iterator<Proyect> iterator = elements.iterator();
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
                for (User tmpuser : task.getColaboratorToCharge()) {
                    if (tmpuser.equals(user)) {
                        proyectsColaborator.add(proyect);
                    }
                }
            }
        }
        return proyectsColaborator;
    }


    //Alberto, HAZ ESTAS 3

    //La 1º, me tiene que devolver UN proyecto, comparando el user y el idProyecto
    //recorre todos los proyectos, comparando el id del proyecto, y si encaja, recorre el array de proyectos
    @Override
    public Proyect retrieveProyectIfColaborator(User user, String idProyecto) {
        Proyect proyect = null;
        for (Proyect proyects : elements) {
            for (Task tmpuser : proyects.getElements()) {
                for (int i = 0; i > tmpuser.getColaboratorToCharge().length; i++) {
                    if (proyects.getId().equals(idProyecto) && tmpuser.getColaboratorToCharge()[i].equals(user)) {
                        proyect = proyects;
                    }
                }
            }
        }
        return proyect;
    }

    @Override
    public Task retrieveTask(User userToCharge, String idTask) {
        Task task = null;
        // que significa recuperar tarea
        for (Proyect proyect : elements) {
            for (Task tmptask : proyect.getElements()) {
                for (int i = 0; i > tmptask.getColaboratorToCharge().length; i++) {
                    if (tmptask.getId().equals(idTask)
                            && tmptask.getColaboratorToCharge()[i].equals(userToCharge)) {
                        task = tmptask;
                    }
                }
            }
        }


        return task;
    }

    @Override
    public boolean updateTask(Task task, Proyect proyect) {
        boolean updated = false;
        // que parametro es el que se actualiza de una tarea
        // o es toda la tarea


        return updated;
    }
}
