package Controller;

import Model.RepoUsers;
import Model.User;
import Utils.Serializator;
import View.IO;
import View.MainView;

import java.security.NoSuchAlgorithmException;

public class MainController implements Interface.IController {

    MainView mainView = new MainView();
    RepoUsers registeredUsers = new RepoUsers();
    RepoUsers load;

    @Override
    public void startApp() {

        loadData();

        int opcion;

        do {

            opcion = mainView.mainView();
            mainController(opcion);

        }while (opcion!=4);

    }

    @Override
    public void mainController(int option) {

        switch (option) {
            case 1:
                User userToLogin = mainView.solicitateUser();
                System.out.println(registeredUsers.checkIfUserExists(userToLogin));


                break;
            case 2:
                boolean registered;
                String confirmation = "S";
                do {
                    User user = mainView.solicitateUser();
                    registered = registeredUsers.addUser(user);

                    mainView.registerMessage(registered);

                    if(registered) {
                        confirmation = IO.readString("¿Desea registrase con esos datos? " +
                                "Inserte 'S' para confirmar, o cualquier otra tecla para volver a registrarse. ");
                    }
                } while (!registered || !confirmation.equalsIgnoreCase("S"));
                Serializator.serialize(registeredUsers, "RepositorioUsuarios.bin");
                break;
            case 3:


                break;
            default:

        }
    }

    @Override
    public void loadData() {
        if(load==null){
            load = Serializator.desearize("RepositorioUsuarios.bin");
            if(load!=null){
                registeredUsers = load;
                System.out.println("""

                        Se han encontrado datos de favoritos y se han cargado.\s
                        Estos se encuentran disponibles para su consulta.
                        """);
            }

        }

    }

}
