package Controller;

import Interface.ICRUDProjectCreatorController;
import Model.ElementstTrello;
import Model.Manage;
import Model.Proyect;
import Model.TipoElementTrello;
import View.IO;
import View.ViewCrud;

public class CRUDProjectCreatorController implements ICRUDProjectCreatorController {
    @Override
    public void CRUDController() {
        ViewCrud secundaryView = new ViewCrud();
        Manage manage = Manage.get_Instance();
        int option;
        do {

            option = IO.readNumber("Inserte la opción deseada", 1, 6);
            //Restructurar vista
            switch (option) {
                case 1:
                    secundaryView.showIfProyectIsAdded(Manage.get_Instance().getRepoProyects().getProyects().add((Proyect) TipoElementTrello.build(
                            ElementstTrello.PROYECT, IO.readString("Inserte un código para el proyecto"), Manage.get_Instance().getUserLoggedIn())));
                    Manage.get_Instance().saveData();
                    break;
                case 2:
                    secundaryView.showProyects(Manage.get_Instance().retrieveProyects());
                    break;
                case 3:
                    secundaryView.showProject(Manage.get_Instance().getRepoProyects().getByID(IO.readString("Inserte el código de el proyecto que desea visualizar sus datos")));
                    break;
                case 4:
                    UpdateProjectController updateControl = new UpdateProjectController();
                    updateControl.updateProjectController();
                    break;
                case 5:
                    Manage.get_Instance().getRepoProyects().delete(secundaryView.deleteProyect());
                    Manage.get_Instance().saveData();
                    //De nuevo, necesito una función de la vista que sea especifica para proyectos eliminados el
                case 6:
                    //Mensaje de despedida
                    break;
                default:

            }


        }while(option!=6);

    }
}
