package Model;

import Interface.IManage;
import Repo.AbstractRepository;
import Repo.RepoProyects;
import Repo.RepoUser;
import Utils.Serializator;

import java.io.Serializable;
import java.util.ArrayList;

public class Manage implements Serializable, IManage {
    private static Manage _instance;
    private final static String FILENAME1 = "manage.bin";
    private RepoUser users;
    private RepoProyects proyects; //Preguntar a Carlos o Rafa por esto. (static)
    private User userLoggedIn; //¿Esto podría darme problemas? a la hora de guardar y loguearse podría darlos?


    public  RepoUser getUsers() {
        return users;
    }

    public void setUsers(RepoUser users) {
        this.users = users;
    }

    public  RepoProyects getProyects() {
        return proyects;
    }

    public void setProyects(RepoProyects proyects) {
        this.proyects = proyects;
    }

    public  User getUserLoggedIn() {
        return userLoggedIn;
    }

    public void setUserLoggedIn(User userLoggedIn) {
        this.userLoggedIn = userLoggedIn;
    }

    private Manage() {
        users = new RepoUser();
        proyects = new RepoProyects();
        userLoggedIn = new User();
    }

    /**
     * Hace que solo se pueda instanciar 1 vez la clase
     *
     * @return La instancia del repositorio de Manage
     */
    public static Manage get_Instance() {
        if (_instance == null) {
            _instance = loadData(FILENAME1);
            if (_instance == null) {
                _instance = new Manage();
            }
        }
        return _instance;
    }

    /**
     * Metodo para comprobar si un usuario existe en el repositorio de usuarios
     * @param userToCheck el usuario que se va a comprobar
     * @return true, si se encuentra el usuario, false si el usuario no se encuentra
     */
    @Override
    public boolean checkIfUserExists(User userToCheck) {
        return users.getElements().contains(userToCheck);
    }

    @Override
    public void loginUser(User userToLogin) {

    }

    @Override
    public ArrayList<Proyect> retrieveProyects() {
        return null;
    }

    @Override
    public ArrayList<Task> showAsignedTasks() {
        return null;
    }

    /**
     * Carga la información de un objeto Manage.
     * @param filename el nombre del archivo que se va a cargar
     * @return un objeto de tipo Manage, con los datos cargados.
     */
    public static Manage loadData(String filename){
        return Serializator.desearize(filename);
    }

    /**
     * Guarda la información del objeto Manage.
     * @param filename el nombre del archivo que se va a guardar
     * @return true si se guardo, false si no fue así
     */
    public boolean saveData(String filename){
        return Serializator.serialize(this, filename);
    }


}
