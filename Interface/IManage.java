package Interface;

import Model.Proyect;
import Model.Task;
import Model.User;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface IManage {

    // PREGUNTA SI TIENES ALGUNA DUDA, NO HAGAS LO QUE TE SALGA DE LOS HUEVOS

    public boolean checkIfUserExists(User userToCheck);

    //La descripción es algo ambigua. Necesito que compares el usuario que recibe con los de repo de usuarios
    //Si encaja, que asigne el user, PERO EL USER DEL REPO, al atributo UserLoggeIn de Manage. Esto es porque para
    //Desde fuera le pasaras un email o nickname y una contraseña. Y no tendrá porque estar completo. Si tienes dudas, PREGUNTA.
    public void loginUser(User userToLogin);

    //Me comparas el atributo del usuario logueado con el atributo user que tienen cada uno de los proyectos.
    //Los que sean iguales, me los añades en un array list (aunque el tipo de dato podriamos discutirlo) y me lo devuelves.
    public ArrayList<Proyect> retrieveProyects();

    //Recorres, cada proyecto y sus listas, y las tareas que coincidan con el usuario que esta logueado, las devuelves en un array list que hayas declarado
    //De nuevo, si quieres, podemos discutir el tipo de dato
    public ArrayList<Task> showAsignedTasks();




}
