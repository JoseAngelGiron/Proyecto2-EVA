package View;

import Interface.ITaskView;
import Model.Proyect;
import Model.Task;

public class TaskView implements ITaskView {
    @Override
    public int taskView() {
        System.out.println("\n ****** - Menu principal - ******");
        System.out.println("1-Login.");
        System.out.println("2-Registrarse.");
        System.out.println("3-Salir");



        System.out.println("****** - -------------- - ****** \n");
        return IO.readNumber("Inserte la opción deseada",1,6);
    }

    @Override
    public String selectTask(Proyect proyect) {
        for(Task task: proyect.getElements()){
            System.out.println(task.toString());
        }
        return IO.readString("Inserte el ID de la tarea que desea seleccionar");
    }


}
