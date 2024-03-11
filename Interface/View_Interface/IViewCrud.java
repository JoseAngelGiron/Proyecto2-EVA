package Interface.View_Interface;

import Model.Entity.Proyect;
import Model.Entity.Task;
import Model.Entity.User;

import java.util.ArrayList;

public interface IViewCrud {

    int welcomeUser(User user);

    void showProyects(ArrayList<Proyect> proyects);


    String deleteProyect();
    void showIfProjectDeleted(Proyect ProyectDeleted);

    String showTasks(ArrayList<Task> tasks);

    void showIfProyectIsAdded(boolean add);

    void showProject(Proyect proyect);



}
