package Controller;

import Interface.Controller_Interface.ISessionController;
import Model.*;
import Model.Entity.User;
import View.IO;
import View.MainView;
import View.Utils.Utils;

public class SessionController implements ISessionController {


    /**
     * Función del controlador, encargada de controlar el login del usuario, realizando los pasos necesarios para
     * iniciar sesión en la aplicación
     * @return true, si se inicia sesión, false, si no fue así.
     */
    @Override
    public boolean loginUser() {
        Manage manage = Manage.get_Instance();
        MainView mainView = new MainView();

        boolean login =false;
        boolean userExists;

        String returnToMainMenu;
        User userToLogin;
        do{
            returnToMainMenu = " ";
            userToLogin = mainView.loginUser();
            userExists = manage.checkLogin(userToLogin);
            if(!userExists){
                returnToMainMenu = IO.readString("Error en los credenciales. ¿Desea volver al menu principal" +
                        "o desea volver a loguearse? 'S' para volver a intentar loguearse, cualquier otra tecla para volver");
            }
        }while (returnToMainMenu.equalsIgnoreCase("S"));

        if(manage.checkLogin(userToLogin)){
            manage.setUserLoggedIn(userToLogin);
            login = true;
        }
        return login;
    }

    /**
     * Función encargada de registrar a un usuario, haciendo uso de funciones de la vista, y realizando los pasos necesarios
     * para añadir sus datos al sistema.
     * @return true, si se registro con éxito, false si no se pudo registrar porque sus datos ya existian o no quiso registrarse.
     */
    @Override
    public boolean registerUser() {
        Manage manage = Manage.get_Instance();
        MainView mainView = new MainView();

        boolean registered;
        String confirmation = " ";
        User user;

        do {
            user = mainView.solicitateUser();
            registered = manage.checkRegister(user);

            mainView.registerMessage(registered);

            if(registered) {
                confirmation = IO.readString("¿Desea registrase con esos datos? " +
                        "Inserte 'S' para confirmar, o cualquier otra tecla para volver al registro. ");
            }
        } while (!registered || !confirmation.equalsIgnoreCase("S"));

        if(confirmation.equalsIgnoreCase("S")){
            manage.getUsers().add(user);
            Utils.printMessage("Se ha generado un fichero con sus credenciales, exceptuando su contraseña. Es" +
                    "recomendable que la tenga a buen recaudo, puesto que todavía no tenemos sistema de recuperación");
            Utils.fileRead(user);
        }


        manage.saveData();
        return registered;
    }


}
