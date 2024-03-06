package Controller;

import Model.User;
import Model.Manage;
import View.IO;
import View.MainView;

public class MainController implements Interface.IController {

    MainView mainView = new MainView();
    Manage manage = Manage.get_Instance();

    /**
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
     *      loguearse, registrarse y salir del programa.
     */
    @Override
    public void mainController(int option) {
        SecundaryController secundaryController = new SecundaryController();

        switch (option) {
            case 1:
                boolean userExists;
                String returnToMainMenu =" ";
                User userToLogin;
                do{
                    userToLogin = mainView.solicitateUser();
                    userExists = manage.checkIfUserExists(userToLogin);
                    if(!userExists){
                        returnToMainMenu = IO.readString("Error en los credenciales. ¿Desea volver al menu principal" +
                                "o desea volver a loguearse? 'S' para volver, cualquier otra tecla para volver");
                    }

                }while (!userExists || returnToMainMenu.equalsIgnoreCase("S"));

                //System.out.println(userExists);
                if(manage.checkIfUserExists(userToLogin)){
                    manage.setUserLoggedIn(userToLogin);
                    secundaryController.userController();
                }

                break;
            case 2:
                boolean registered;
                String confirmation = " ";
                User user;

                do {
                    user = mainView.solicitateUser();
                    registered = manage.checkIfUserExists(user);

                    mainView.registerMessage(registered);

                    if(!registered) {
                        confirmation = IO.readString("¿Desea registrase con esos datos? " +
                                "Inserte 'S' para confirmar, o cualquier otra tecla para volver a registrarse. ");
                    }
                } while (registered || !confirmation.equalsIgnoreCase("S"));

                if(confirmation.equalsIgnoreCase("s")){
                    manage.getUsers().add(user);
                }
                manage.saveData("manage.bin");

                break;
            case 3:

                //Mensaje de despedida
                break;

        }
    }


}
