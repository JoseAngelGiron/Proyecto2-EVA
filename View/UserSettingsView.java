package View;

import Interface.IUserSettingsView;

public class UserSettingsView implements IUserSettingsView {

    /**
     * Menú generico que muestra las opciones al usuario de cambiar sus credenciales.
     * @return Un número, entre 1 y 4, que se corresponden con las distintas opciones
     */
    @Override
    public int changeProfile() {
        System.out.println("1.- Cambiar de Nombre-");
        System.out.println("2.- Cambiar de Nickname-");
        System.out.println("3.- Cambiar de Email");
        System.out.println("4.- Cambiar de contraseña");
        return IO.readNumber("Inserte la opcion que desee",1,4);
    }

}
