package Controller;

import Interface.ITaskController;
import Model.Manage;
import Model.Proyect;
import Model.Task;
import Repo.RepoProyects;
import View.IO;
import View.TaskView;
import View.ViewCrud;

import java.util.ArrayList;

public class TaskController implements ITaskController {

    /**
     * Función encargada de gestionar lo relacionado con las opciones de actualización de una tarea.
     */
    @Override
    public void controllerTask(ArrayList<Proyect> proyect) {
        Manage manage = Manage.get_Instance();
        //Lo primero es mostrar todos los proyectos y pedir el proyecto que quiere seleccionar
        //Aqui muestro todos los datos relativos a todos las tareas de un proyecto.
        //Selecciono una, del proyecto y si existe, que entre al sub-menu. Desde este submenu también modificamos
        //La cosa esta de

        //función vista muestra p

        // Pide una id del proyecto
        boolean cheker = false;
        Proyect tmpProyect = null;     // Para almacenar el proyecto y entrar directamente a este
        String returnToMainMenu;
        boolean cheker2 = false;

        do {
            cheker = ShowProjects (IO.readString("Inserte el id del proyecto"));
            if (!cheker){
                returnToMainMenu = IO.readString("Error de busqueda. ¿Deseas buscar otra vez" +
                        " o salir directamente al menu. Si deseas salir ponga s. si deseas probar otra" +
                        " vez pulse otra tecla");
            }
            returnToMainMenu = "";

        }while (!cheker || returnToMainMenu.equalsIgnoreCase("S"));

        if (cheker) {

            do {
                cheker2 = ShowTask (IO.readString("Inserte el id de la tarea que deseas configurar"));
                if (!cheker2){
                    returnToMainMenu = IO.readString("Error de busqueda. ¿Deseas buscar otra vez" +
                            " o salir directamente al menu. Si desea salir pulse s. si deseas probar otra" +
                            " vez pulse otra tecla");
                }
            }while (!cheker2 || returnToMainMenu.equalsIgnoreCase("S"));
        }
        TaskView view = new TaskView();
        int optionSubMenu;
        do {
            optionSubMenu = view.taskView();
            switch (optionSubMenu) {
                case 1:
                    //Actualizar nombre de la tarea
                    manage.getRepoProyects().update();
                    break;
                case 2:
                    //Actualizar descripción
                    break;
                case 3:
                    //Actualizar fecha de inicio y de fin
                    break;
                case 4:
                    //AQUI TENGO QUE LLAMAR A OTRO SUB MENU PARA CAMBIAR UNA TAREA EL ESTADO, QUIZÁS, NO ESTOY SEGURO.
                    break;
                case 5:
                    //Mensaje de despedida de este sub menu.
                    break;
                case 6:
                    //Asignar un colaborador a cargo de la tarea.
                default:

            }

        } while (optionSubMenu != 7);
    }
}
