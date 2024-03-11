package Controller;

import Interface.Controller_Interface.IChangeUserController;
import Model.Manage;
import View.Utils.Utils;
import View.IO;
import View.UserSettingsView;

public class ChangeSettingsUserController implements IChangeUserController {
    /**
     * Esta función se encarga de controlar las distintas opciones que se le ofrecen al usuario a la hora,
     * de cambiar sus credenciales.
     */
    @Override
    public void changeUserController() {
        Manage manage = Manage.get_Instance();
        UserSettingsView settingsView = new UserSettingsView();

        int optionToChange;
        do {
            manage.getRepoProyects().update(manage.getUserLoggedIn()); //Funciones para actualizar, TESTEAR MUY FUERTE Y CRUZADO CON EL RESTO DE FUNCIONES
            manage.getUsers().update(manage.getUserLoggedIn());
            manage.saveData();

            optionToChange = settingsView.changeProfile();
            switch (optionToChange) {

                case 1:
                    Manage.get_Instance().getUserLoggedIn().setName(IO.readString("Inserte su nuevo nombre"));
                    break;
                case 2:
                    settingsView.showIfNickWasChange(Manage.get_Instance().getUserLoggedIn().setNickName(manage.checkNickname(IO.readString("Inserte el apodo por el que quiere ser identificado: "))));
                    break;
                case 3:
                    settingsView.showIfEmailWasChange(Manage.get_Instance().getUserLoggedIn().setEmail(manage.checkEmail(IO.readString("Inserte su nuevo correo electronico: "))));
                    break;
                case 4:
                    Manage.get_Instance().getUserLoggedIn().setPassword(IO.readString("Inserte su nueva contraseña"));
                    break; //MOSTRAR CREDENCIALES PROPIAS, UN NUEVO CASE
                case 5:
                    Utils.printMessage("Volviendo al menú principal...");
                    break;
            }

        } while (optionToChange != 5);

    }
}
