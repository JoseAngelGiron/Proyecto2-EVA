package Interface.View_Interface;

import Model.Proyect;
import Model.Task;
import Model.User;

import java.util.ArrayList;

public interface IViewCrud {

    int welcomeUser(User user);

    void showProyects(ArrayList<Proyect> proyects);

    String changeProyect();

    String deleteProyect();
    void showIfProjectDeleted(Proyect ProyectDeleted);

    String showTasks(ArrayList<Task> tasks);

    void showIfProyectIsAdded(boolean add);

    void showProject(Proyect proyect);



}
