package Controller;

import Interface.Controller_Interface.ICRUDProjectCreatorController;
import Model.Manage;
import View.Utils.Utils;
import View.IO;
import View.OwnProjectsView;
import View.ViewCrud;

public class CRUDProjectCreatorController implements ICRUDProjectCreatorController {

    /**
     * Función encarga de gestionar lo relacionado con la creación de proyectos, así como las opciones de borrado, actualización
     * y su muestra por pantalla
     */
    @Override
    public void CRUDController() {
        ViewCrud viewCrud = new ViewCrud();
        OwnProjectsView projectsView = new OwnProjectsView();
        Manage manage = Manage.get_Instance();
        int option;
        do {
            //TENGO QUE REESTRUCTURAR VISTA, PARA PODER TENER ORGANIZADO CORRECTAMENTE LAS VISTAS
            option = projectsView.showMenuProjects();
            manage.saveData();
            switch (option) {
                case 1:
                    SelectItemController selectItemController = new SelectItemController();
                    viewCrud.showIfProyectIsAdded(Manage.get_Instance().getRepoProyects().add(selectItemController.selectTypeProyect()));
                    break;
                case 2:
                    viewCrud.showProyects(manage.retrieveProyects());
                    break;
                case 3:
                    viewCrud.showProject(Manage.get_Instance().getRepoProyects().getByID(IO.readString("Inserte el código de el proyecto que desea visualizar sus datos."), manage.getUserLoggedIn()));
                    break;
                case 4:
                    UpdateProjectController updateControl = new UpdateProjectController();
                    updateControl.updateProjectController();
                    break;
                case 5:
                    viewCrud.showIfProjectDeleted(manage.deleteProyectFromCreator(viewCrud.deleteProyect(), manage.getUserLoggedIn()));
                    break;
                case 6:
                    Utils.printMessage("Saliendo hacía el menu de navegación.... ");
                    break;

            }
        }while(option!=6);

    }
}
