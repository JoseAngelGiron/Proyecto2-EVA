import IO.Utils;
import Interface.IMainView;

public class MainController implements Interface.IController {


    @Override
    public void startApp () {
        int opcion;
        do {
            opcion = viewLogin();
            mainController(opcion);
        }while (opcion!=4);
    }

    @Override
    public void mainController(int option) {
        IMainView view;
        switch (option){
            case 1: // logearse
                //lee string == nombre usuario
                String name;
                String password;
                boolean comprobacion = false;
                //comprueba que exista y entra
                do {
                    String tmpName = view.readString();

                    if (!Utils.checkInFiles(tmpName,"User.txt")){
                        name = tmpName;
                        do {
                            String tmpPassword = view.readString();
                            password = tmpPassword;
                            if (Utils.checkInFiles(password,"Password.txt")){
                                comprobacion = true;
                            }
                        }while (Utils.checkInFiles(password,"Password.txt"));

                    }else {
                        view.loginError();
                    }

                }while (!comprobacion);

                //usuario y contraseña existen en el documento de texto
                //llamar a error en Ivie

                break;
            case 2: //registrarse
                Interface.IPassword password;
                Interface.IUser user;

                // Usuario
                do {
                do {
                    user.User("lee string", "le string", "le string");

                    Utils.checkInFiles(user.getName,"User.txt");

                }while (user.getName() == null && user.getNickname() == null && user.getEmail() == null);
                }while (IO.Utils.checkInFiles(user.getName,"User.txt"));
                //Si el nombre no existe da false y sale con el nombre insertado nuevo

                //Contraseña
                // lee string
                do {
                    password.Password("lee string");

                }while (password.getPassword() == null);

                user.getName();

                break;
            case 3: //salir

                // Gracias por entrar por parte del view o utils
                break;
            default:
                // Imprime error
        }
    }

}
