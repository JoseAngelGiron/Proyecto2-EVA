package Controller;

import Interface.Controller_Interface.IMainController;
import Model.*;
import View.Utils.Utils;
import View.MainView;
import View.ViewCrud;

public class MainController implements IMainController {

    MainView mainView = new MainView();
    Manage manage = Manage.get_Instance();

    /**
     * Función encargada de iniciar el programa y llamar al menu principal para solicitar una opción.
     * Hace uso de la función mainView mostrar el menú y pedir la opción requerida
     */
    @Override
    public void startApp() {
        int opcion;
        do {
            opcion = mainView.mainView();
            mainController(opcion);
        }while (opcion!=3);
    }

    /**
     * Se le pasa una opcion y segun esta se eligue que hace el programa
     * @param option Se le pasa un numero entre el 1 y el 3 y segun estos se puede
     * loguearse, registrarse y salir del programa.
     */
    @Override
    public void mainController(int option) {
        SessionController loginController = new SessionController();
        switch (option) {
            case 1:
                if(loginController.loginUser()){
                    mainMenuController();
                }else{
                    Utils.printMessage("Inicio de sesión fallido. Pruebe de nuevo o registrese");
                }
                break;
            case 2:
                loginController.registerUser();
                break;
            case 3:
                Utils.printMessage("¡Gracias por usar nuestra aplicación!");
                break;
        }
    }

    /**
     * Función encargada de controlar el flujo del usuario por la navegación del programa y sus distintas opciones
     */
    @Override
    public void mainMenuController() {
        ViewCrud secundaryView = new ViewCrud();
        int option;

        do {

            option = secundaryView.welcomeUser(manage.getUserLoggedIn());

            switch (option) {
                case 1:
                    CRUDProjectCreatorController crudControl = new CRUDProjectCreatorController();
                    crudControl.CRUDController();
                    break;
                case 2:
                    ProjectCollaboratorController collaboratorController = new ProjectCollaboratorController();
                    collaboratorController.projectsCollaboratorController();
                    break;
                case 3:
                    ChangeSettingsUserController settingsControl = new ChangeSettingsUserController();
                    settingsControl.changeUserController();
                    break;
                case 4:
                    Utils.printMessage("Ha cerrado su sesión. ¡Vuelva pronto!");
                    manage.setUserLoggedIn(null);
                    manage.saveData();
                    break;
            }


        }while(option!=4);
    }
}
