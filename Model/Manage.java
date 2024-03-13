package Model;

import Interface.Model_Interface.IManage;
import Model.Entity.Proyect;
import Model.Entity.User;
import Model.Repo.RepoProyects;
import Model.Repo.RepoUser;
import Model.DataAccess.Serializator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Manage implements Serializable, IManage {
    private static Manage _instance;
    private final static String FILENAME = "manage.bin";
    private RepoUser users;
    private RepoProyects repoProyects;
    private User userLoggedIn;


    public RepoUser getUsers() {
        return users;
    }
    public RepoProyects getRepoProyects() {
        return repoProyects;
    }

    public void setUsers(RepoUser users) {
        this.users = users;
    }

    public void setProyects(RepoProyects proyects) {
        this.repoProyects = proyects;
    }

    public User getUserLoggedIn() {
        return userLoggedIn;
    }
    private Manage() {
        users = new RepoUser();
        repoProyects = new RepoProyects();
        userLoggedIn = new User();
    }

    /**
     * Hace que solo se pueda instanciar 1 vez la clase
     *
     * @return La instancia del repositorio de Manage
     */
    public static Manage get_Instance() {
        if (_instance == null) {
            _instance = loadData(FILENAME);
            if (_instance == null) {
                _instance = new Manage();
            }
        }
        return _instance;
    }

    /**
     * Metodo para comprobar si un usuario existe en el repositorio de usuarios, comprobando credenciales
     * @param userToCheck el usuario que se va a comprobar
     * @return true, si se encuentra el usuario y sus credenciales encajan, false si el usuario no se encuentra
     */
    @Override
    public boolean checkLogin(User userToCheck) {
        boolean login = false;
        for(User user: users.getElements()) {
            if(user.getPassword().equals(userToCheck.getPassword()) && (user.getNickName().equals(userToCheck.getNickName()) ||
                            user.getEmail().equals(userToCheck.getEmail()))) {
                login = true;
                break;
            }
        }
        return login;
    }

    /**
     * Función que compara los atributos primarios de un usuario y compara si ya existen, con el fin de no permitir
     * el registro con credenciales ya existentes
     * @param userToCheck el usuario sobre el que se comprobarán credenciales
     * @return true si no se encuentran los credenciales. False, si se encuentran y por tanto no permitira el registro.
     */
    @Override
    public boolean checkRegister(User userToCheck) {
        boolean register = true;
        for(User user: users.getElements()) {
            if(user.getNickName().equalsIgnoreCase(userToCheck.getNickName()) ||
                    user.getEmail().equalsIgnoreCase(userToCheck.getEmail())) {
                register = false;
                break;
            }
        }
        return register;
    }

    /**
     * Metodo para comparar el usuario que recibe con los del repositorio usuario y asignarlo
     * @param userLoggedIn el usuario que se va a comparar
     */
    public void setUserLoggedIn(User userLoggedIn) {
        for(User user: users.getElements()){
            if(user.equals(userLoggedIn)){
                this.userLoggedIn = user;
            }
        }

    }

    /**
     * Metodo para comparar el usuario logueado con el atributo user que tienen los proyectos, si son iguales se añaden al arraylist
     * @return proyects que es el array de proyectos que tiene el usuario ahora mismo.
     */
    @Override
    public ArrayList<Proyect> retrieveProyects() {
        ArrayList<Proyect> proyects = new ArrayList<>();
        for (Proyect proyect : getRepoProyects().getProyects()) {
            if (proyect.getProjectCreator().equals(userLoggedIn)) {
                proyects.add(proyect);
            }
        }
        return proyects;
    }


    /**
     * Elimina un proyecto del repositorio de proyectos utilizando su identificador y el usuario que se le pasa
     *
     * @param id El identificador del proyecto a eliminar
     * @return Devuelve el proyecto que se a eliminado
     */
    @Override
    public Proyect deleteProyectFromCreator(String id, User userLogged) {
        Proyect proyect = null;
        boolean removed = false;
        Iterator<Proyect> iterator = repoProyects.getElements().iterator();

        while (iterator.hasNext() && !removed) {
            Proyect tmpProyect = iterator.next();
            if (tmpProyect.getId().equals(id) && tmpProyect.getProjectCreator().equals(userLoggedIn)) {
                proyect = tmpProyect;
                iterator.remove();
                removed = true;
            }
        }
            return proyect;
    }


    /**
     * Función para comprobar si el email de un usuario ya esta siendo usado por otro usuario
     * @param email el email que se va a comprobar
     * @return el nuevo email, que va a ser el que recibe si no se encuentran coincidencias, y si no, será una cadena vacía
     */
    @Override
    public String checkEmail(String email) {
        String newEmail = email;
        for (User user: users.getElements()){
            if (user.getEmail().equalsIgnoreCase(email.toLowerCase())) {
                newEmail = " "; //PODRIA PONER UN BREAK? ¿ES ABUSAR?
                break;
            }
        }

        return newEmail;
    }

    /**
     * Función para comprobar si un nickname de usuario ya esta siendo usado por otro usuario
     * @param nickName el nickname que se va a comprobar
     * @return el nuevo nickname, que va a ser el que recibe si no se encuentran coincidencias, y si no, será una cadena vacía
     */
    @Override
    public String checkNickname(String nickName) {
        String newNickName = nickName;
        for (User user: users.getElements()){
            if (user.getName().equalsIgnoreCase(nickName.toLowerCase())) {
                newNickName = " "; //PODRIA PONER UN BREAK? ¿ES ABUSAR?
                break;
            }
        }

        return newNickName;
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
     *
     * @return true si se guardo, false si no fue así
     */
    public boolean saveData(){
        return Serializator.serialize(this, FILENAME);
    }




}
