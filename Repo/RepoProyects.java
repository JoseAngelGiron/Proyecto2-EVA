package Repo;

import Interface.IRepoProyects;
import Model.Proyect;

import java.util.HashSet;
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
     * @return El proyecto encontrado, o null si no se encontró ningún proyecto con ese identificador
     */ //Alberto, modifica este metodo para que devuelva el Proyecto usando como coincidencia ademas, un objeto de User.
        //Ponselo tu en la llamada de la función, en clase te explico.
    @Override
    public Proyect getByID(String id) {
        Proyect result = null;
        for (Proyect user : elements) {
            if (user.getId().equals(id)) {
                result = user;
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
     * @return true si el proyecto se eliminó exitosamente,
     * false si no se encontró
     */
    @Override //Alberto, cambiame este método, necesito que devuelva el objeto que se elimina. Usa iterator, please
    public Proyect delete(String id) {
        return elements.remove(getByID(id));
    }


}
