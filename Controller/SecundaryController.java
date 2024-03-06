package Controller;

import Interface.ISecundaryController;
import Model.*;
import View.IO;
import View.ProjectView;
import View.ViewCrud;

import java.util.ArrayList;

public class SecundaryController implements ISecundaryController {

    //CADA SUB-SWITCH HAY QUE DIVIDIRLO EN UN ARCHIVO NUEVO. SUBDIVIDIR Y HACER INSTANCIAS CORRECTAMENTE:


    @Override
    public void userController() {
        Manage manage = Manage.get_Instance();
        ViewCrud secundaryView = new ViewCrud();

         int option = secundaryView.welcomeUser(manage.getUserLoggedIn());
            switch (option){
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

                    if(proyect!=null){ //Esto a través de una función de la vista

                        int optionSubMenu;
                        do{
                            optionSubMenu =projectView.chooseWhatToChange();
                            switch (optionSubMenu){
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

                        }while (optionSubMenu!=5);

                    }else{
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
                        switch (optionToChange){
                            //Tengo que actualizar los proyectos con el nuevo user, para que no de error. Tiene una función de update
                            //hecha para esto.
                            case 1:
                                if(Manage.get_Instance().getUserLoggedIn().setName(IO.readString("Inserte su nuevo nombre"))){
                                    Manage.get_Instance().getUsers().update(manage.getUserLoggedIn());
                                    //Aqui actualizar todos los proyectos con el nuevo usuario
                                }

                                break;
                            case 2:
                                if(Manage.get_Instance().getUserLoggedIn().setNickName(IO.readString("Inserte el apodo por el que quiere ser identificado"))){
                                    Manage.get_Instance().getUsers().update(manage.getUserLoggedIn());
                                }
                                break;
                            case 3:
                                if(Manage.get_Instance().getUserLoggedIn().setEmail(IO.readString("Inserte su nuevo correo electronico"))){
                                    Manage.get_Instance().getUsers().update(manage.getUserLoggedIn());
                                }
                                break;
                            case 4:
                                if(Manage.get_Instance().getUserLoggedIn().setPassword(IO.readString("Inserte su nueva contraseña"))){
                                    Manage.get_Instance().getUsers().update(manage.getUserLoggedIn());
                                }

                                break;
                            case 5:
                                //Mensaje de despedida de este sub menu.
                                break;
                        }

                    }while(optionToChange != 5);
                    //Opciones de usuario

                    break;
                case 8:

                    break;

            }


    }
}
