package Interface.View_Interface;

import Model.Proyect;
import Model.Task;
import Model.User;

import java.util.ArrayList;

public interface ITaskView {
    //Menu del controlador de actualizar una tarea.
    int taskView();
    String selectTask(Proyect proyect);
    int changeStatusMenu();

    void showColaborator(User user);

    String showProyects(ArrayList<Proyect> proyects);
    String showTasks(Proyect proyect);
    void showTask(Task task);

}
