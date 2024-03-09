package Controller;

import Interface.Controller_Interface.ICRUDProjectCreatorController;
import Model.ElementstTrello;
import Model.Manage;
import Model.Proyect;
import Model.TipoElementTrello;
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

            switch (option) {
                case 1:
                    viewCrud.showIfProyectIsAdded(Manage.get_Instance().getRepoProyects().getProyects().add((Proyect) TipoElementTrello.build(
                            ElementstTrello.PROYECT, IO.readString("Inserte un código para el proyecto"), Manage.get_Instance().getUserLoggedIn())));
                    manage.saveData();
                    break;
                case 2:
                    viewCrud.showProyects(Manage.get_Instance().retrieveProyects());
                    break;
                case 3:
                    viewCrud.showProject(Manage.get_Instance().getRepoProyects().getByID(IO.readString("Inserte el código de el proyecto que desea visualizar sus datos." +
                            " No es necesario el identificado de clase '(P -)'"), manage.getUserLoggedIn()));
                    break;
                case 4:
                    UpdateProjectController updateControl = new UpdateProjectController();
                    updateControl.updateProjectController();
                    break;
                case 5:
                    viewCrud.showIfProjectDeleted(Manage.get_Instance().getRepoProyects().delete(viewCrud.deleteProyect()));
                    Manage.get_Instance().saveData();
                case 6:
                    //Mensaje de despedida
                    break;

            }


        }while(option!=6);

    }
}
