package View;

import Interface.View_Interface.IUserSettingsView;

public class UserSettingsView implements IUserSettingsView {

    /**
     * Menú  que muestra una serie de opciones al usuario para cambiar sus credenciales.
     * @return Un número, entre 1 y 4, que se corresponden con las distintas opciones
     */
    @Override
    public int changeProfile() {
        System.out.println(" ************************************************************* ");
        System.out.println("| ************* - Menú para cambiar de perfil - ************* |");
        System.out.println("|-------------------------------------------------------------|");
        System.out.println("| 1.- Cambiar de Nombre                                       |");
        System.out.println("| 2.- Cambiar de Nickname                                     |");
        System.out.println("| 3.- Cambiar de Email                                        |");
        System.out.println("| 4.- Cambiar de Contraseña                                   |");
        System.out.println("| 5.- Salir de las opciones con el cambio de credenciales:    |");
        System.out.println("|-------------------------------------------------------------|");
        System.out.println(" ***************** - --------------------- - ***************** ");
        return IO.readNumber("Inserte la opcion que desee",1,5);
    }

    /**
     * Función encargada de mostrar información relativa al cambio de nickname
     * @param change que será el dato que determinara que información se muestra
     */
    @Override
    public void showIfNickWasChange(boolean change) {
        if(change){
            System.out.println("Su nick fue cambiado correctamente");
        }else{
            System.out.println("El nombre no pudo cambiarse, no se encuentra disponible o no cumple con los requisitos");
            System.out.println("El nombre no puede tener espacios");
            System.out.println("El nombre tiene que tener entre 4 y 12 caracteres");
        }
    }

    /**
     * Función encargada de mostrar la información relativa al cambio de e-mail
     * @param change que será el dato que determinara que información se muestra
     */
    @Override
    public void showIfEmailWasChange(boolean change) {
        if(change){
            System.out.println("Su E-mail fue cambiado correctamente");
        }else{
            System.out.println("El E-mail no pudo cambiarse, no se encuentra disponible o no cumple con los requisitos");
            System.out.println("El email debe seguir un formato similar al de: texto@texto y acabado en '.es' o '.com' ");
        }

    }


}
