package Repo;

import Model.User;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class RepoUser extends AbstractRepository {
    private final static String FILENAME = "users.bin";
    private static RepoUser _instance;
    private Set<User> users;       // <--  Si quieres que sea RepoUsers tiene que
    // cambiar el nombre de este Set<User> "La s del users"

    /**
     * Constructor privado de users
     */
    private RepoUser() {
        users = new HashSet<>();
    }

    /**
     * Hace que solo se pueda instanciar 1 vez la clase
     *
     * @return La instancia del repositorio de usuarios
     */
    public static RepoUser getInstance() {
        if (_instance == null) {
            _instance = (RepoUser) load(FILENAME);
            if (_instance == null) {
                _instance = new RepoUser();
            }
        }
        return _instance;
    }

    /**
     * Agrega un usuario al repositorio si no existe previamente
     *
     * @param user El usuario a agregar
     * @return El usuario agregado si la operación fue exitosa, o null si el usuario ya existe
     */
    public User add(User user) {
        User result = null;
        if (users.add(user)) {
            result = user;
        }
        return result;
    }

    /**
     * Obtiene un usuario del repositorio mediante su identificador
     *
     * @param id El identificador del usuario a buscar
     * @return El usuario encontrado, o null si no se encontró ningún usuario con ese identificador
     */
    public User getByID(String id) {
        User result = null;
        for (User user : users) {
            if (user.getNickName().equals(id)) {
                result = user;
                break;
            }
        }
        return result;
    }

    /**
     * Obtiene todos los usuarios del repositorio
     *
     * @return Una colección de todos los usuarios almacenados en el repositorio
     */
    public Collection<User> getAll() {
        return users;
    }

    /**
     * Actualiza un usuario en el repositorio
     *
     * @param id El usuario con los datos actualizados
     * @return El usuario actualizado si se encontró y actualizó correctamente, o null si no se encontró
     */
    public User update(User id) {
        User result = null;
        result = getByID(id.getNickName());
        if (result != null) {
            users.remove(result);
            users.add(id);
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
    public boolean delete(String id) {
        return users.remove(getByID(id));
    }

    /**
     * Guarda la lista de usuarios en un archivo
     *
     * @return true si la operación de guardado fue exitosa
     */
    public boolean save() {
        return save(FILENAME);
    }
}
