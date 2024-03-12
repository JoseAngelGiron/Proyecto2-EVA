package Controller;

import Interface.Controller_Interface.IUpdateTaskController;
import Model.Manage;
import Model.Entity.Proyect;
import Model.Entity.Task;
import View.SelectItemView;
import View.Utils.Utils;
import View.IO;
import View.TaskView;
import View.ViewCrud;

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
        SelectItemView itemView = new SelectItemView();

        boolean repeat;
        do {
            repeat = false;
            view.showProject(proyect);
            Task task = retrieveDataController.retrieveTask(proyect);

            if (task != null) {
                int optionSubMenu;
                do {
                    manage.getRepoProyects().updateTask(task, proyect);
                    manage.saveData();

                    optionSubMenu = taskView.taskView();
                    switch (optionSubMenu) {
                        case 1:
                            taskView.showTask(task);
                            break;
                        case 2:
                            task.setName(IO.readString("Inserte el nuevo nombre de la tarea"));
                            break;
                        case 3:
                            task.setDescription(IO.readString("Inserte la nueva descripción"));
                            break;
                        case 4:
                            task.setStartDate(itemView.solicitateDate("Inserte la nueva fecha de comienzo: "));
                            task.setEndDate(itemView.solicitateDate("Inserte la nueva fecha de limite: "));
                            break;
                        case 5:
                            task.changeStatus(taskView.changeStatusMenu());
                            task.addComentary(IO.readString("¿Que comentario quiere añadir sobre el cambio de estado a la tarea?: "));
                            taskView.showTask(task);
                            break;
                        case 6:
                            AssignUnassignedCollaboratorController assignUnassignedController = new AssignUnassignedCollaboratorController();
                            assignUnassignedController.selectOperation(task);

                            break;
                        case 7:
                            Utils.printMessage("Estas saliendo del menu de actualización de tareas...");
                            break;
                    }

                } while (optionSubMenu != 7);
                repeat = IO.readString("Si desea editar otra tarea del proyecto, inserte 'S', de lo contrario, " +
                        "pulse cualquier tecla").equalsIgnoreCase("S");
                ;
            }
        } while (repeat);
    }
}
