package Interface;

import Model.Proyect;
import Model.Task;
import Model.User;

import java.util.ArrayList;

public interface IViewCrud {

    public int welcomeUser(User user);

    public void showProyects(ArrayList<Proyect> proyects);

    public String changeProyect();


    //modifica esta función para que antes de seguir, pida confirmación de borrar.
    public String deleteProyect();

    //Esta bien hecha, pero necesito que lo haga con iterator, no con un for normal
    public String showTasks(ArrayList<Task> tasks);

    //Me muestras un mensaje si es verdadero, de que el proyecto fue añadido y viceversa
    public void showIfProyectIsAdded(boolean add);


    //  muestra proyecto y las tareas de ese proyecto
    public void showProject(Proyect proyect);



}
