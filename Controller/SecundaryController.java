package Controller;

import Interface.ISecundaryController;
import Model.ElementstTrello;
import Model.Manage;
import Model.Proyect;
import Model.TipoElementTrello;
import View.IO;
import View.ProjectView;
import View.ViewCrud;

public class SecundaryController implements ISecundaryController {




    @Override
    public void userController() {
        Manage manage = Manage.get_Instance();
        ViewCrud secundaryView = new ViewCrud();

         int option = secundaryView.welcomeUser(manage.getUserLoggedIn());
            switch (option){
                case 1:
                    //Necesito una función que me imprima con un boolean si se ha añadido el proyecto correctamente.
                    Manage.get_Instance().getProyects().getProyects().add(
                            (Proyect) TipoElementTrello.build(ElementstTrello.PROYECT, IO.readString("Inserte un código para el proyecto"),
                                    Manage.get_Instance().getUserLoggedIn()));
                    Manage.get_Instance().saveData("manage.bin");
                    break;
                case 2:
                    secundaryView.showProyects(Manage.get_Instance().retrieveProyects());
                    break;
                case 3:
                    //funcion de la vista que me muestre un proyecto, please
                    Manage.get_Instance().getProyects().getByID(IO.readString("Inserte el código de el proyecto que desea visualizar sus datos"));
                    break;
                case 4:
                    //Esto se pasa a otro sub controlador, por mantener un orden:
                    ProjectView projectView = new ProjectView();
                    Proyect proyect = Manage.get_Instance().getProyects().getByID(IO.readString("Inserte el código de el proyecto que desea actualizar"));

                    if(proyect!=null){

                        int optionSubMenu;
                        do{
                            optionSubMenu =projectView.chooseWhatToChange();
                            switch (optionSubMenu){
                                case 1:
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    break;
                                case 4:
                                    break;
                                case 5:
                                    //Mensaje de despedida de este sub menu.
                                    break;
                            }

                        }while (optionSubMenu!=5);

                    }else{
                        //Mensaje de error
                    }

                     //Lo actualizo
                    //con la lógica de Update y listo. Esto lo HAGO YO.
                    break;
                case 5:
                    Manage.get_Instance().getProyects().delete(secundaryView.deleteProyect());
                    //De nuevo, necesito una función de la vista

                    break;
                case 6:

                    break;
                case 7:
                    break;
                case 8:

                    break;

            }


    }
}
