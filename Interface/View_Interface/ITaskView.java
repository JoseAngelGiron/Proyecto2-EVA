package Interface.View_Interface;

import Model.Entity.Proyect;
import Model.Entity.Task;
import Model.Entity.User;

import java.util.ArrayList;

public interface ITaskView {
    //Menu del controlador de actualizar una tarea.
    int taskView();
    String selectTask(Proyect proyect);
    int changeStatusMenu();
    void showColaboratorAdd(User user);
    void showCollaboratorUnassigned(User user);
    String showProyects(ArrayList<Proyect> proyects);
    String showTasks(Proyect proyect);
    void showTask(Task task);
    int selectAssignOrUnassigned();




}
