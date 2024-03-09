package Interface.View_Interface;

import Model.Proyect;
import Model.Task;
import Model.User;

public interface ITaskView {
    //Menu del controlador de actualizar una tarea.
    int taskView();
    String selectTask(Proyect proyect);
    int changeStatusMenu();

    void showColaborator(User user);


}
