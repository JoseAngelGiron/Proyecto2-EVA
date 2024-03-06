package Repo;

import Interface.IRepoProyects;
import Model.Proyect;

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
     * @param id El identificador del proyecto a buscar
     * @param user El usuario que se va a comprobar si es el creador
     * @return El proyecto encontrado, o null si no se encontró ningún proyecto con ese identificador
     */
    @Override
    public Proyect getByID(String id, User user) {
        Proyect result = null;
        for (Proyect proyect : elements) {
            if (proyect.getId().equals(id) &&
                    user.equals(proyect.getProjectCreator)) {
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
     * Elimina un proyecto de la lista de usuarios utilizando su identificador
     *
     * @param id El identificador del proyecto a eliminar
     * @return Devuelve el proyecto que se a eliminado
     */
    @Override //Alberto, cambiame este método, necesito que devuelva el objeto que se elimina. Usa iterator, please
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
     * Segun el usuario que se le pasa comprueba en que proyectos esta y devuelve en los que se encuentra
     * @param user El usuario que va a buscar los proyectos en los que esta
     * @return devuelve un arraylist de todos los proyectos en los que esta el usuario
     */
    @Override
    public ArrayList<Proyect> retrieveUserColaboratorProyects(User user) {
        ArrayList<Proyect> tmpList = new ArrayList<>();

        for (Proyect proyect : elements) {         //comprueba todas las partes de los proyectos
            for (Task task : proyect.getElements()) {           // mira todas las tareas
                for (User tmpuser : task.getColaboratorToCharge()) {    // Pasa por todos los usuarios
                    if (tmpuser.equals(user)) {
                        tmpList.add(proyect);
                    }
                }
            }
        }


    }
}
