package Controller;

import Interface.Controller_Interface.IUpdateTaskController;
import Model.Manage;
import Model.Proyect;
import Model.Task;
import Model.User;
import View.IO;
import View.TaskView;
import View.ViewCrud;

import java.util.ArrayList;

public class UpdateTaskController implements IUpdateTaskController {

    /**
     * Función encargada de gestionar lo relacionado con las opciones de actualización de las tareas.
     */
    @Override
    public void controllerTask(Proyect proyect) {
        Manage manage = Manage.get_Instance();
        RetrieveDataController retrieveDataController = new RetrieveDataController();

        //Dejar una sola vista
        ViewCrud view = new ViewCrud();
        TaskView taskView = new TaskView();

        boolean repeat;
        do{
            repeat = false;
            view.showProject(proyect);
            Task task = retrieveDataController.retrieveTask(proyect);

            if(task != null) {
                int optionSubMenu;
                do {
                    manage.getRepoProyects().updateTask(task, proyect);
                    manage.saveData();
                    //Estas 2 lineas podrían ir en los cases, las dejo aqui que no dan problema en principio, si no
                    //van para abajo

                    optionSubMenu = taskView.taskView();
                    switch (optionSubMenu) {
                        case 1:
                            task.setName(IO.readString("Inserte el nuevo nombre de la tarea"));
                            break;
                        case 2:
                            task.setDescription(IO.readString("Inserte la nueva descripción"));
                            break;
                        case 3:
                            //Actualizar fecha de inicio y de fin
                            break;
                        case 4:
                            task.changeStatus(taskView.changeStatusMenu());
                            task.addComentary(IO.readString("¿Que comentario quiere añadir a la tarea?"));
                            break;
                        case 5:
                            User colaboratorAdded = null;
                            User userToAddAsColaborator = manage.getUsers().getByID(IO.readString("Introduzca el nombre del colaborador o su e-mail para añadirlo a la tarea"));
                            if (userToAddAsColaborator != null) {
                                colaboratorAdded = task.setColaboratorToCharge(userToAddAsColaborator);
                            }
                            taskView.showColaborator(colaboratorAdded);

                        case 6:
                            //Mensaje de despedida de este sub menu.
                            break;
                    }

                } while (optionSubMenu != 6);
                repeat = IO.readString("Si desea editar otra tarea del proyecto, inserte 'S', de lo contrario, " +
                        "pulse cualquier tecla").equalsIgnoreCase("S");;
            }
        }while(repeat);
    }
}
