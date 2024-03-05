package Controller;

import Interface.ISecundaryController;
import Model.Manage;
import View.ViewCrud;

public class SecundaryController implements ISecundaryController {

    Manage manage = Manage.get_Instance();
    ViewCrud secundaryView = new ViewCrud();

    @Override
    public void userController() {
         int option = secundaryView.welcomeUser(manage.getUserLoggedIn());
            switch (option){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;

            }


    }
}
