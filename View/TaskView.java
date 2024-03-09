package View;

import Interface.View_Interface.ITaskView;
import Model.Proyect;
import Model.Task;
import Model.User;

public class TaskView implements ITaskView {
    @Override //MODIFICAR
    public int taskView() {
        System.out.println("\n ****** - Editor de tareas - ******");
        System.out.println("1- Visualizar el estado de la tarea");
        System.out.println("1- Cambiar el nombre de la tarea");
        System.out.println("2- Cambiar la descripción de la tarea.");
        System.out.println("3- Cambiar las fechas de la tarea.");
        System.out.println("4- Cambiar el estado de la tarea.");
        System.out.println("5- Asignar un colaborador a la tarea.");
        System.out.println("6- Salir.");
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

    @Override
    public int changeStatusMenu() {
        System.out.println("\n ****** - ¿A que estado desea cambiar la tarea? - ******");
        System.out.println("1- Cambiar el estado a 'No empezada' ");
        System.out.println("2- Cambiar el estado a 'En progreso'");
        System.out.println("3- Cambiar el estado a 'Completada \n'");

        return IO.readNumber("Seleccione la opción que desea",1,3);
    }


    @Override
    public void showColaborator(User user) {
        if(user!=null){
            System.out.println("El usuario "+user.getName()+"fue añadido a la tarea");
        }else{
            System.out.println("No se encontro el colaborador.");
        }
    }


}
