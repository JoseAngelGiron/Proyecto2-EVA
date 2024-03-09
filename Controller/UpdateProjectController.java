package Controller;

import Interface.Controller_Interface.IUpdateProjectController;
import Model.*;
import View.IO;
import View.MainView;
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
                optionSubMenu = -1;
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
                        proyect.getElements().add(selectItemController.selectTypeTask());
                        break;
                    case 4:
                        UpdateTaskController taskController = new UpdateTaskController();
                        taskController.controllerTask(proyect);
                        break;
                    case 5:
                        User user =manage.getUsers().getByID(IO.readString(projectView.changeCreator()));

                        if(user != null){
                            proyect.setProjectCreator(user);
                            manage.getRepoProyects().update(proyect);
                            manage.saveData();
                            MainView.printMessage("Los permisos fueron cambiados con éxito, saliendo...");
                        }else{
                            MainView.printMessage("No se encontro el usuario, o quiso cancelar la operación.");

                        }
                        break;
                    case 6:
                        MainView.printMessage("Saliendo del menu...");
                        break;
                }
            } while (optionSubMenu != 6 || !manage.getUserLoggedIn().equals(proyect.getProjectCreator()));

        } else {
            MainView.printMessage("Saliendo del menu...");
        }
    }
}
