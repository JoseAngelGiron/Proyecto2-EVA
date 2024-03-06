package Controller;

import Model.*;
import View.IO;
import View.MainView;
import View.ProjectView;
import View.ViewCrud;

import java.util.ArrayList;

public class MainController implements Interface.IController {

    MainView mainView = new MainView();
    Manage manage = Manage.get_Instance();

    /**
     * COMENTA ESTO BIEN JOER
     * Inicia el programa y se repite hasta que el usuario salga pulsando 3
     */
    @Override
    public void startApp() {

        int opcion;
        do {

            opcion = mainView.mainView();
            mainController(opcion);

        }while (opcion!=3);

    }

    /**
     * Se le pasa una opcion y segun esta se eligue que hace el programa
     * @param option Se le pasa un numero entre el 1 y el 3 y segun estos se puede
     *      loguearse, registrarse y salir del programa.
     */
    @Override
    public void mainController(int option) {
        SecundaryController secundaryController = new SecundaryController();

        switch (option) {
            case 1:
                boolean userExists;
                String returnToMainMenu =" ";
                User userToLogin;
                do{
                    userToLogin = mainView.solicitateUser();
                    userExists = manage.checkIfUserExists(userToLogin);
                    if(!userExists){
                        returnToMainMenu = IO.readString("Error en los credenciales. ¿Desea volver al menu principal" +
                                "o desea volver a loguearse? 'S' para volver, cualquier otra tecla para volver");
                    }

                }while (!userExists || returnToMainMenu.equalsIgnoreCase("S"));

                if(manage.checkIfUserExists(userToLogin)){
                    manage.setUserLoggedIn(userToLogin);
                    crudController();
                }

                break;
            case 2:
                boolean registered;
                String confirmation = " ";
                User user;

                do {
                    user = mainView.solicitateUser();
                    registered = manage.checkIfUserExists(user);

                    mainView.registerMessage(registered);

                    if(!registered) {
                        confirmation = IO.readString("¿Desea registrase con esos datos? " +
                                "Inserte 'S' para confirmar, o cualquier otra tecla para volver a registrarse. ");
                    }
                } while (registered || !confirmation.equalsIgnoreCase("S"));

                if(confirmation.equalsIgnoreCase("s")){
                    manage.getUsers().add(user);
                }
                manage.saveData("manage.bin");

                break;
            case 3:

                //Mensaje de despedida
                break;

        }




    }

    /**
     * Función encargada de controlar el flujo del usuario por la navegación del programa y sus distintas opciones
     */
    @Override
    public void crudController() {
        ViewCrud secundaryView = new ViewCrud();

        int option = secundaryView.welcomeUser(manage.getUserLoggedIn());
        switch (option) {
            case 1:
                //Necesito una función que me imprima con un boolean si se ha añadido el proyecto correctamente.
                Manage.get_Instance().getRepoProyects().getProyects().add((Proyect) TipoElementTrello.build(
                        ElementstTrello.PROYECT, IO.readString("Inserte un código para el proyecto"), Manage.get_Instance().getUserLoggedIn()));
                Manage.get_Instance().saveData("manage.bin");
                break;
            case 2:
                secundaryView.showProyects(Manage.get_Instance().retrieveProyects());
                break;
            case 3:
                //funcion de la vista que me muestre un proyecto, please
                Manage.get_Instance().getRepoProyects().getByID(IO.readString("Inserte el código de el proyecto que desea visualizar sus datos"));
                break;
            case 4:
                //Esto se pasa a otro sub controlador, por mantener un orden y limpieza:
                ProjectView projectView = new ProjectView();
                Proyect proyect = Manage.get_Instance().getRepoProyects().getByID(IO.readString("Inserte el código de el proyecto que desea actualizar"));

                if (proyect != null) { //Esto a través de una función de la vista

                    int optionSubMenu;
                    do {
                        optionSubMenu = projectView.chooseWhatToChange();
                        switch (optionSubMenu) {
                            case 1:
                                //Actualizar nombre del proyecto
                                break;
                            case 2:
                                //Actualizar descripción
                                break;
                            case 3:
                                //Cambiar el creador. //Que tenga un mensaje de aviso
                                break;
                            case 4:

                                //AQUI TENGO QUE LLAMAR A OTRO SUB MENU PARA CAMBIAR UNA TAREA EN CONCRETO.
                                break;
                            case 5:
                                //Mensaje de despedida de este sub menu.
                                break;
                        }

                    } while (optionSubMenu != 5);

                } else {
                    //Mensaje de error
                }

                //Lo actualizo
                //con la lógica de Update y listo. Esto lo HAGO YO.
                break;
            case 5:
                Manage.get_Instance().getRepoProyects().delete(secundaryView.deleteProyect());
                Manage.get_Instance().saveData("manage.bin");
                //De nuevo, necesito una función de la vista

                break;
            case 6:
                ArrayList<Proyect> proyects = Manage.get_Instance().getRepoProyects().retrieveUserColaboratorProyects(Manage.get_Instance().getUserLoggedIn());
                secundaryView.showProyects(proyects);
                //secundaryView.
                //Aqui va la función de Manage que me devuelva los proyectos, de la lista de proyectos de colaboradores.
                //Debo pedir una función para seleccionar el proyecto que se le muestran, y luego, que vea las tareas de ese proyecto que le interesa
                //Al usuario.
                //Cuando lo haga,
                break;
            case 7:
                int optionToChange;
                do {
                    optionToChange = secundaryView.changeProfile();
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
                                Manage.get_Instance().getUsers().update(manage.getUserLoggedIn());
                            }

                            break;
                        case 5:
                            //Mensaje de despedida de este sub menu.
                            break;
                    }

                } while (optionToChange != 5);
                //Opciones de usuario

                break;
            case 8:

                break;


        }

    }
}
