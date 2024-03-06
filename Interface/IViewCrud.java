package Interface;

import Model.Proyect;
import Model.Task;
import Model.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public interface IViewCrud {


    public int welcomeUser(User user);




    public void showProyects(ArrayList<Proyect> proyects);


    public String changeProyect();


    public int changeProfile();

    //modifica esta función para que antes de seguir, pida confirmación de borrar.
    public String deleteProyect();

    //Esta bien hecha, pero necesito que lo haga con iterator, no con un for normal
    public int showTasks(ArrayList<Task> tasks);

    //Me muestras un mensaje si es verdadero, de que el proyecto fue añadido y viceversa
    public void showIfProyectIsAdded(boolean add);

    //Es autodescriptivo esto
    public void showProject(Proyect proyect);

    //Necesito un submenu con cada una de las opciones que se le pueden cambiar a un proyecto, que devuelva un int
    //nombre, descripcion, tareas, usuario creador
    public int chooseWhatToChange();

}
