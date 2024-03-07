package Controller;

import Interface.ITaskController;
import Model.Manage;
import Model.Proyect;
import Model.Task;
import Model.User;
import Repo.RepoProyects;
import View.IO;
import View.TaskView;
import View.ViewCrud;

import java.util.ArrayList;

public class TaskController implements ITaskController {

    /**
     * Función encargada de gestionar lo relacionado con las opciones de actualización de las tareas.
     */
    @Override
    public void controllerTask() {
        Manage manage = Manage.get_Instance();
        ViewCrud view = new ViewCrud();
        TaskView taskView = new TaskView();

        Task task;
        Proyect proyectRetrieved;
        String confirmation = " ";


        do{
            //Lo primero es mostrar todos los proyectos y pedir el proyecto que quiere seleccionar
            ArrayList<Proyect> proyectsColaborator = manage.getRepoProyects().retrieveUserColaboratorProyects(manage.getUserLoggedIn());
            view.showProyects(proyectsColaborator);
            proyectRetrieved = manage.getRepoProyects().retrieveProyectIfColaborator(manage.getUserLoggedIn(),IO.readString("Inserte el ID del proyecto que quiere conseguir"));

            //Aqui muestro todos los datos relativos a todas las tareas de un proyecto y pido un código
            task = manage.getRepoProyects().retrieveTask(manage.getUserLoggedIn(),taskView.selectTask(proyectRetrieved));
            if(task == null){
                confirmation = IO.readString("No ha introducido un ID de tarea concreta. ¿Quiere volver al proceso de selección?" +
                        "S/para volver. Cualquier otra tecla para salir");
            }
        }while(task ==null ||confirmation.equalsIgnoreCase("S"));



        if(task != null){
            int optionSubMenu;
            do {
                optionSubMenu = taskView.taskView();
                switch (optionSubMenu) {
                    case 1:
                        task.setName(IO.readString("Inserte el nuevo nombre de la tarea"));
                        manage.getRepoProyects().updateTask(task, proyectRetrieved);
                        manage.saveData();
                        break;
                    case 2:
                        task.setDescription(IO.readString("Inserte la nueva descripción"));
                        manage.getRepoProyects().updateTask(task, proyectRetrieved);
                        manage.saveData();
                        //Actualizar descripción
                        break;
                    case 3:
                        //Actualizar fecha de inicio y de fin
                        break;
                    case 4:
                        //task.changeStatus(IO.readNumber("",1,3));
                        //AQUI TENGO QUE LLAMAR A OTRO SUB MENU PARA CAMBIAR UNA TAREA EL ESTADO, QUIZÁS, NO ESTOY SEGURO.
                        break;
                    case 5:

                        break;
                    case 6:
                        User userToAddAsColaborator = manage.getUsers().getByID(IO.readString("Insertar el nombre del colaborador o su e-mail para añadirlo"));
                        if (userToAddAsColaborator!=null){
                            if (task.setColaboratorToCharge(userToAddAsColaborator)){
                                manage.getRepoProyects().updateTask(task, proyectRetrieved);
                                manage.saveData();
                            }

                        }else{
                            //imprimir mensaje de error. No se encontro el usuario a añadir como colaborador.
                        }

                    case 7:
                        //Mensaje de despedida de este sub menu.
                    default:
                        //Mensaje ingo
                }

            } while (optionSubMenu != 7);
        }



    }
}
