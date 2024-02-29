package View;

import Interface.IMainView;

public class MainView implements IMainView {
    /**
     *  Esta implementado el método viewLogin de la interfaz IMainView.
     * Este método muestra un menú con tres opciones:
     * “Login”, “Registrarse” y “Salir”.
     * Luego, lee la opción ingresada por el usuario y la devuelve.
     * @return
     */
    @Override
    public int viewLogin() {
        System.out.println("1-Login.");
        System.out.println("2-Registrarse.");
        System.out.println("3-Salir");
        return IO.readNumber("Inserte la opcion que desea",1,3);
    }
    @Override
    public int loginError(){
            System.out.println("Error");
            return IO.readNumber("Vuelva a intentarlo e inserte una de estas opciones: ", 1, 3);

    }
}
