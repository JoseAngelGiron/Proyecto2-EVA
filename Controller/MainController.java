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

                break;
            case 6:
                TaskController taskController = new TaskController();
                taskController.controllerTask(Manage.get_Instance().getRepoProyects().retrieveUserColaboratorProyects(Manage.get_Instance().getUserLoggedIn()));
                break;
            case 7:
                ChangeSettingsUserController settingsControl = new ChangeSettingsUserController();
                settingsControl.changeUserController();
                //Opciones de usuario


                break;
            case 8:

                break;


            }

        }
    }
