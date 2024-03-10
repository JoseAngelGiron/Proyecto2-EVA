package Controller;

import Interface.Controller_Interface.IUpdateTaskController;
import Model.Manage;
import Model.Proyect;
import Model.Task;
import Model.User;
import Utils.Utils;
import View.IO;
import View.MainView;
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

                    optionSubMenu = taskView.taskView();
                    switch (optionSubMenu) {
                        case 1:
                            Utils.printMessage(task.toString());
                            break;
                        case 2:
                            task.setName(IO.readString("Inserte el nuevo nombre de la tarea"));
                            break;
                        case 3:
                            task.setDescription(IO.readString("Inserte la nueva descripción"));
                            break;
                        case 4:
                            //Actualizar fecha de inicio y de fin
                            break;
                        case 5:
                            task.changeStatus(taskView.changeStatusMenu());
                            task.addComentary(IO.readString("¿Que comentario quiere añadir sobre el cambio de estado a la tarea?"));
                            break;
                        case 6:
                            User colaboratorAdded = null;
                            User userToAddAsColaborator = manage.getUsers().getByID(IO.readString("Introduzca el nombre del colaborador o su e-mail para añadirlo a la tarea"));
                            if (userToAddAsColaborator != null) {
                                colaboratorAdded = task.setColaboratorToCharge(userToAddAsColaborator);
                            }
                            taskView.showColaborator(colaboratorAdded);
                            break;
                        case 7:
                            Utils.printMessage("Estas saliendo del menu de actualización de tareas...");
                            break;
                    }

                } while (optionSubMenu != 7);
                repeat = IO.readString("Si desea editar otra tarea del proyecto, inserte 'S', de lo contrario, " +
                        "pulse cualquier tecla").equalsIgnoreCase("S");;
            }
        }while(repeat);
    }
}
