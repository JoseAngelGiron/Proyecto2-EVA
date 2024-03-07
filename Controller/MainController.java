package Controller;

import Model.*;
import View.IO;
import View.MainView;
import View.ProjectView;
import View.ViewCrud;

import java.util.ArrayList;

public class MainController implements Interface.IController {

    MainView mainView = new MainView();
    Manage manage = Manage.get_Instance();

    /**
     * COMENTA ESTO BIEN JOER
     * Inicia el programa y se repite hasta que el usuario salga pulsando 3
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
        LoginController loginController = new LoginController();
        switch (option) {
            case 1:
                if(loginController.loginUser()){
                    mainMenuController();
                }else{
                    //Mensaje redirigiendo al menu principal
                }
                break;
            case 2:
                loginController.registerUser();
                break;
            case 3:
                //Mensaje de despedida
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

        option = secundaryView.welcomeUser(manage.getUserLoggedIn());
        switch (option) {

            //Cambiar esto, menos cases,
            case 1:
                CRUDProjectCreatorController crudControl = new CRUDProjectCreatorController();
                crudControl.CRUDController();
                break;
            case 2:
                TaskController taskController = new TaskController();
                taskController.controllerTask();
                break;
            case 3:
                ChangeSettingsUserController settingsControl = new ChangeSettingsUserController();
                settingsControl.changeUserController();
                break;
            case 4:
                //Mensaje de despedida
                manage.setUserLoggedIn(null);
                manage.saveData();
                break;
            default:
                //Mensaje generico que nos diga que nos equivocamos, como siempre lo hicimos y siempre lo haremos !

            }

        }
    }
