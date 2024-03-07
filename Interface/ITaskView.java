package Interface;

import Model.Proyect;
import Model.Task;

public interface ITaskView {
    //Menu del controlador de actualizar una tarea.
    int taskView();

    String selectTask(Proyect proyect);
}
