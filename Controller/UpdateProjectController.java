package Controller;

import Interface.Controller_Interface.IUpdateProjectController;
import Model.*;
import View.IO;
import View.ProjectView;

public class UpdateProjectController implements IUpdateProjectController {

    /**
     * Esta función se encarga de Controlar las distintas opciones de actualización en relación a los proyectos.
     */
    @Override
    public void updateProjectController() {
        Manage manage = Manage.get_Instance();
        ProjectView projectView = new ProjectView();
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
                        UpdateTaskController taskController = new UpdateTaskController();
                        taskController.controllerTask(proyect);
                        break;
                    case 4:
                        User user =manage.getUsers().getByID(IO.readString(projectView.changeCreator()));

                        if(user != null){
                            proyect.setProjectCreator(user);
                            manage.getRepoProyects().update(proyect);
                            manage.saveData();
                            projectView.genericMessage("Los permisos fueron cambiados con éxito, saliendo...");
                        }else{
                            projectView.genericMessage("No se encontro el usuario, o quiso cancelar la operación.");

                        }
                        break;
                    case 5:
                        projectView.genericMessage("Saliendo del menu...");
                        break;
                }
            } while (optionSubMenu != 5 || !manage.getUserLoggedIn().equals(proyect.getProjectCreator()));

        } else {
            projectView.genericMessage("Saliendo del menu...");
        }
    }
}
