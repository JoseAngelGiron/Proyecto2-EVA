package View;

import Interface.View_Interface.IMainView;
import Model.Entity.User;

public class MainView implements IMainView{
    /**
     * Este método muestra un menú con tres opciones:
     * “Login”, “Registrarse” y “Salir”.
     * Luego, lee la opción ingresada por el usuario haciendo uso de la función readNumber
     * y devuelve la opción introducida por el usuario
     * @return el número introducido por el usuario.
     */
    @Override
    public int mainView() {
        System.out.println("\n\\______   \\\\______   \\\\_____  \\  \\______ \\  |    |   \\\\_   ___ \\ \\__    ___/|   |\\   \\ /   /|   |\\__    ___/\\__  |   | \\______   \\|   ||    |    \\_____  \\  \\__    ___/\n" +
                " |     ___/ |       _/ /   |   \\  |    |  \\ |    |   //    \\  \\/   |    |   |   | \\   Y   / |   |  |    |    /   |   |  |     ___/|   ||    |     /   |   \\   |    |   \n" +
                " |    |     |    |   \\/    |    \\ |    `   \\|    |  / \\     \\____  |    |   |   |  \\     /  |   |  |    |    \\____   |  |    |    |   ||    |___ /    |    \\  |    |   \n" +
                " |____|     |____|_  /\\_______  //_______  /|______/   \\______  /  |____|   |___|   \\___/   |___|  |____|    / ______|  |____|    |___||_______ \\\\_______  /  |____|   \n" +
                "                   \\/         \\/         \\/                   \\/                                             \\/                                \\/        \\/            ");

        System.out.println("\n ****** - Menu principal - ******");
        System.out.println("1-Login.");
        System.out.println("2-Registrarse.");
        System.out.println("3-Salir");
        System.out.println("****** - -------------- - ****** \n");
        return IO.readNumber("Inserte la opcion que desea: ", 1, 3);
    }

    /**
     * Esta función imprime un mensaje relacionado con el registro de usuarios, en función del dato que recibe
     * @param registerMessage que será true o false, y determinara que mensaje se imprime.
     */
    @Override
    public void registerMessage(boolean registerMessage) {
        if(registerMessage){
            System.out.println("El apodo o correo ya existe. Introduzca unos datos validos");
        }else{
            System.out.println("El apodo y el correo están disponibles: ");
        }

    }


    /**
     * Esta función se encarga de pedir datos al usuario y devuelve un objeto de la clase User con la finalidad de
     * proceder al registro.
     * Informa al usuario de si alguno de los datos no son validos y los vuelve a pedir si es el caso
     * @return un objeto de la clase usuario
     */
    @Override
    public User solicitateUser() {
        User userToRegister;

        do{
            String name = IO.readString("Inserte el nombre con el que desea registrarse: ");
            String nickName = IO.readString("Inserte el nombre de usuario con el que desea registrarse: ");
            String email = IO.readString("Inserte el email con el que se va a registrarse: ");
            String password = IO.readString("Inserte una contraseña para registrarse: ");
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

    /**
     * Esta función se encarga de solicitar por pantalla al usuario los datos relativos a sus credenciales, y los devuelve
     * con el objetivo de loguearse
     * @return Un objeto de la clase User, que contiene los credenciales del usuario
     */
    @Override
    public User loginUser() {
        User userToLogin;

        do{

            String nickName = IO.readString("Inserte su apodo en el sistema: ");
            String password = IO.readString("Inserte el su contraseña: ");

            userToLogin = new User(nickName, password);
            if (userToLogin.getNickName() == null){
                System.out.println("El nombre o el nombre de usuario no puede contener espacios en blanco");
            }

            if(userToLogin.getPassword() == null){
                System.out.println("La contraseña debe tener minimo 8 y máximo 20 caracteres. Al menos 3 letras, 1 mayúscula y 3 números");
            }

        } while( userToLogin.getNickName() == null || userToLogin.getPassword() == null);

        return userToLogin;
    }


}
