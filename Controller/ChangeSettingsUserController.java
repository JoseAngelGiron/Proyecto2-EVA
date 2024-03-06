package Controller;

import Interface.IChangeUserController;
import Model.Manage;
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
            optionToChange = settingsView.changeProfile();
            switch (optionToChange) {
                //Tengo que actualizar los proyectos con el nuevo user, para que no de error. Tiene una función de update
                //hecha para esto.
                case 1:
                    if (Manage.get_Instance().getUserLoggedIn().setName(IO.readString("Inserte su nuevo nombre"))) {
                        Manage.get_Instance().getUsers().update(manage.getUserLoggedIn());
                        //Aqui actualizar todos los proyectos con el nuevo usuario
                    }

                    break;
                case 2:
                    if (Manage.get_Instance().getUserLoggedIn().setNickName(IO.readString("Inserte el apodo por el que quiere ser identificado"))) {
                        Manage.get_Instance().getUsers().update(manage.getUserLoggedIn());
                    }
                    break;
                case 3:
                    if (Manage.get_Instance().getUserLoggedIn().setEmail(IO.readString("Inserte su nuevo correo electronico"))) {
                        Manage.get_Instance().getUsers().update(manage.getUserLoggedIn());
                    }
                    break;
                case 4:
                    if (Manage.get_Instance().getUserLoggedIn().setPassword(IO.readString("Inserte su nueva contraseña"))) {
                        //Manage.get_Instance().getUsers().update(manage.getUserLoggedIn());
                    }

                    break;
                case 5:
                    //Mensaje de despedida de este sub menu.
                    break;
            }

        } while (optionToChange != 5);

    }
}
