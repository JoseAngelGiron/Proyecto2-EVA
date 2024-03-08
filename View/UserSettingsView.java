package View;

import Interface.IUserSettingsView;

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
        return IO.readNumber("Inserte la opcion que desee",1,4);
    }

    @Override
    public void goodByeMessage() {
        System.out.println("¡ Gracias por usar nuestra aplicación ! ");
        System.out.println("Ahora volverá al menu principal :) \n");
    }

    @Override
    public void errorOption() {
        System.out.println("Ha introducido una opción incorrecta. Pruebe de nuevo \n");
    }


}
