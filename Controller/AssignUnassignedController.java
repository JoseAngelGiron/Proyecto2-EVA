package Controller;

import Interface.Controller_Interface.IAssignUnassignedController;
import Model.Entity.Task;
import Model.Entity.User;
import Model.Manage;
import View.IO;
import View.TaskView;
import View.Utils.Utils;

public class AssignUnassignedController implements IAssignUnassignedController {

    /**
     * Función encargada de gestionar lo relativo a añadir/eliminar colaboradores a una tarea.
     * @param task la tarea sobre la que se va a añadir/borrar colaboradores
     */
    @Override
    public void selectOperation(Task task) {
        Manage manage = Manage.get_Instance();
        TaskView taskView = new TaskView();
        User temporaryCollaborator;
        int option = taskView.selectAssignOrUnassigned();



        switch (option){
            case 1:
                temporaryCollaborator = manage.getUsers().getByID(IO.readString("Introduzca el nombre del colaborador o su e-mail " +
                        "para añadirlo a la tarea como colaborador: "));
                if (temporaryCollaborator != null) {
                    temporaryCollaborator = task.setColaboratorToCharge(temporaryCollaborator);
                    manage.saveData();
                }
                taskView.showColaboratorAdd(temporaryCollaborator);
                break;
            case 2:
                temporaryCollaborator = manage.getUsers().getByID(IO.readString("Introduzca el nombre del colaborador o su e-mail " +
                        "que desea eliminar de la tarea: "));
                if (temporaryCollaborator != null) {
                    temporaryCollaborator = task.unassignColaborator(temporaryCollaborator);
                    manage.saveData();
                }
                taskView.showCollaboratorUnassigned(temporaryCollaborator);
                break;
            case 3:
                Utils.printMessage("Operación cancelada, volviendo al menu anterior...");
                break;
        }


    }
}
