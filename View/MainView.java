package View;

import Interface.IMainView;
import Model.User;

public class MainView implements IMainView {
    /**
     * Este método muestra un menú con tres opciones:
     * “Login”, “Registrarse” y “Salir”.
     * Luego, lee la opción ingresada por el usuario haciendo uso de la función readNumber
     * y devuelve la opción introducida por el usuario
     * @return el número introducido por el usuario.
     */
    @Override
    public int mainView() {
        System.out.println("****** - Menu principal - ******");
        System.out.println("1-Login.");
        System.out.println("2-Registrarse.");
        System.out.println("3-Salir");
        System.out.println("****** - -------------- - ****** \n");
        return IO.readNumber("Inserte la opcion que desea: ", 1, 3);
    }

    @Override
    public int loginError() {
        System.out.println("Error en la credenciales");
        return IO.readNumber("Vuelva a intentarlo e inserte una de estas opciones: ", 1, 3);

    }

    /**
     * Esta función imprime un mensaje relacionado con el registro de usuarios, en función del dato que recibe
     * @param RegisterSucessfully que será true o false, y determinara que mensaje se imprime.
     */
    @Override
    public void registerMessage(boolean RegisterSucessfully) {
        if(RegisterSucessfully){
            System.out.println("El nombre y el correo estan disponibles. ¿Desea registrarse con estos datos?");

        }else{
            System.out.println("El nombre o correo ya existe. Introduzca unos datos validos");
        }

    }


    /**
     * Esta función se encarga de pedir datos al usuario y devuelve un objeto de la clase User.
     * Informa al usuario de si alguno de los datos no son validos y los vuelve a pedir si es el caso
     * @return un objeto de la clase usuario
     */
    @Override
    public User solicitateUser() {
        User userToRegister;

        do{
            String name = IO.readString("Inserte su nombre");
            String nickName = IO.readString("Inserte el nombre de usuario que desea");
            String email = IO.readString("Inserte su email");
            String password = IO.readString("Inserte su contraseña");
            userToRegister = new User(name, nickName, email, password);
            if (userToRegister.getName() == null  || userToRegister.getNickName() == null){
                System.out.println("El nombre o el nombre de usuario no puede contener espacios en blanco");
            }
            if(userToRegister.getEmail() == null){
                System.out.println("El email debe seguir un formato similar al de: texto@texto y acabado en '.es' o '.com' ");
            }
            if(userToRegister.getPassword() == null){
                System.out.println("La contraseña debe tener minimo 8 y máximo 20 caracteres. Al menos 3 letras, 1 mayúscula y 3 números");
            }

        } while(userToRegister.getName() == null || userToRegister.getNickName() == null || userToRegister.getEmail() == null || userToRegister.getPassword() == null);

        return userToRegister;
    }


}
