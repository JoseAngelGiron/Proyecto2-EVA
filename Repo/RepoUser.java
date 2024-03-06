package Repo;

import Interface.IRepoUsers;
import Model.User;
import Utils.Serializator;

import java.util.HashSet;

public class RepoUser extends AbstractRepository<User> implements IRepoUsers {

    public RepoUser() {
        super(new HashSet<>());
    }


    /**
     * Obtiene un usuario del repositorio mediante su identificador
     *
     * @param id El identificador del usuario a buscar
     * @return El usuario encontrado, o null si no se encontró ningún usuario con ese identificador
     */
    @Override
    public User getByID(String id) {
        User result = null;
        for (User user : elements) {
            if (user.getNickName().equals(id)) {
                result = user;
                break;
            }
        }
        return result;
    }

    /**
     * Actualiza un usuario en el repositorio
     * @param id El usuario con los datos actualizados
     * @return El verdadero, si se ha actualizado si se encontró y actualizó correctamente, o false si no se encontró
     */
    @Override
    public User update(User id) {
        User result;
        result = getByID(id.getNickName());
        if (result != null) {
            elements.remove(result);
            elements.add(id);
            result = id;
        }
        return result;
    }

    /**
     * Elimina a un usuario de la lista de usuarios utilizando su identificador
     *
     * @param id El identificador del usuario a eliminar
     * @return true si el usuario se eliminó exitosamente, false si no se encontró
     */
    @Override   //Esta lo mismo Alberto, haz que devuelva que el usuario que se ha eliminado. En principio no la vamos a usar
                //Pero si lo hacemos, me gusta mas que la otra, y así mostramos datos y mas importante no pita.
    public boolean delete(String id) {
        return elements.remove(getByID(id));
    }






}
