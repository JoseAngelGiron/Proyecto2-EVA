package View;

import Interface.View_Interface.IUserSettingsView;

public class UserSettingsView implements IUserSettingsView {

    /**
     * Menú  que muestra una serie de opciones al usuario para cambiar sus credenciales.
     * @return Un número, entre 1 y 4, que se corresponden con las distintas opciones
     */
    @Override
    public int changeProfile() {
        System.out.println("1.- Cambiar de Nombre-");
        System.out.println("2.- Cambiar de Nickname-");
        System.out.println("3.- Cambiar de Email");
        System.out.println("4.- Cambiar de contraseña");
        System.out.println("5.- Salir de las opciones con el cambio de credenciales: ");
        return IO.readNumber("Inserte la opcion que desee",1,5);
    }



}
