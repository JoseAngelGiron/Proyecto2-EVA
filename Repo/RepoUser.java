package Repo;

import Interface.Repo_Interface.IRepoUsers;
import Model.User;

import java.util.HashSet;
import java.util.Iterator;

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
            if (user.getNickName().equals(id) || user.getEmail().equals(id)) {
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
    @Override  
    public User delete(String id) {
        Iterator<User> iterator = elements.iterator();
        User userToDelete = null;
        while (iterator.hasNext()){
            User currentUser = iterator.next();
            if(iterator.next().getName().equals(id)){
                userToDelete = currentUser;
                iterator.remove();
            }
        }
        return userToDelete;
    }






}
