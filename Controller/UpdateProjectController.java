package Controller;

import Interface.Controller_Interface.IUpdateProjectController;
import Model.*;
import Model.Entity.Proyect;
import Model.Entity.User;
import View.TaskView;
import View.Utils.Utils;
import View.IO;
import View.UpdateProjectView;

public class UpdateProjectController implements IUpdateProjectController {

    /**
     * Esta función se encarga de Controlar las distintas opciones de actualización en relación a los proyectos.
     */
    @Override
    public void updateProjectController() {
        Manage manage = Manage.get_Instance();
        UpdateProjectView projectView = new UpdateProjectView();

        RetrieveDataController retrieveDataController = new RetrieveDataController();
        Proyect proyect = retrieveDataController.retrieveProyect();

        if (proyect != null ) {
            int optionSubMenu;
            do {
                manage.getRepoProyects().update(proyect);
                manage.saveData();
                optionSubMenu = projectView.chooseWhatToChange();

                switch (optionSubMenu) {
                    case 1:
                        proyect.setName(IO.readString("Inserte el nuevo nombre del proyecto: "));
                        break;
                    case 2:
                        proyect.setDescription(IO.readString("Inserte la nueva descripción del proyecto: "));
                        break;
                    case 3:
                        SelectItemController selectItemController = new SelectItemController();
                        projectView.showTaskAdded(proyect.addElement(selectItemController.selectTypeTask()));
                        break;
                    case 4:
                        projectView.showTaskRemoved(proyect.deleteTask(IO.readString("Inserte el nombre de la tarea que se desea eliminar: ")));
                        break;
                    case 5:
                        UpdateTaskController taskController = new UpdateTaskController();
                        taskController.controllerTask(proyect);
                        break;
                    case 6:
                        User user =manage.getUsers().getByID(projectView.changeCreator());

                        if(user != null){
                            proyect.setProjectCreator(user);
                            manage.getRepoProyects().update(proyect);
                            manage.saveData();
                            Utils.printMessage("Los permisos fueron cambiados con éxito, saliendo...");
                        }else{
                            Utils.printMessage("No se encontro el usuario, o quiso cancelar la operación.");
                        }
                        break;
                    case 7:
                        String confirmation=IO.readString("¿Desea guardar los datos del proyecto actualizados en un archivo de texto?" +
                                " S/Para guardar, cualquier otra tecla para cancelar");
                        if(confirmation.equalsIgnoreCase("S")){
                            Utils.fileRead(proyect);
                        }
                        Utils.printMessage("Saliendo del menu...");
                        break;
                }
            } while (optionSubMenu != 7 || !manage.getUserLoggedIn().equals(proyect.getProjectCreator()));

        } else {
            Utils.printMessage("Saliendo del menu...");
        }
    }
}
