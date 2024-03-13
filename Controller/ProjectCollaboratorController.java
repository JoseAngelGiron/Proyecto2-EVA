package Controller;

import Interface.Controller_Interface.IProjectCollaboratorController;
import Model.Manage;
import Model.Entity.Proyect;
import Model.Entity.Task;
import View.Utils.Utils;
import View.IO;
import View.TaskView;

import java.util.ArrayList;

public class ProjectCollaboratorController implements IProjectCollaboratorController {
    /**
     * Función encarga de controlar aquello relacionado con los colaboradores de tareas en proyectos.
     */
    @Override
    public void projectsCollaboratorController() {
       Manage manage = Manage.get_Instance();
       TaskView collaboratorProjectsView = new TaskView();
       boolean repeat = false;
       do {

           ArrayList<Proyect> proyects = manage.getRepoProyects().retrieveUserColaboratorProyects(manage.getUserLoggedIn());

           if (!proyects.isEmpty()) {
               Proyect proyectToUpdate = manage.getRepoProyects().retrieveProyectIfColaborator(manage.getUserLoggedIn(),collaboratorProjectsView.showProyects(proyects));
               if(proyectToUpdate!=null) {
                   Task taskToUpdate = manage.getRepoProyects().retrieveTask(manage.getUserLoggedIn(), collaboratorProjectsView.showTasks(proyectToUpdate));
                   if (taskToUpdate != null) {
                       if (taskToUpdate.changeStatus(collaboratorProjectsView.changeStatusMenu())) {

                           taskToUpdate.addComentary(IO.readString("Inserte un comentario al respecto."));
                           manage.getRepoProyects().updateTask(taskToUpdate, proyectToUpdate);
                           collaboratorProjectsView.showTask(taskToUpdate);
                       } else {
                           Utils.printMessage("Ha cancelado la opción de actualización de estado.");
                       }


                   } else {
                       Utils.printMessage("La tarea que ha introducido no se encuentra");
                   }
               }else{
                   Utils.printMessage("El código de proyecto introducido no se corresponde con ninguno de la lista");
               }
           } else {
               Utils.printMessage("No hay proyectos en los que se encuentre como colaborador.");
           }
           if(!proyects.isEmpty()) {
               repeat = IO.readString("¿Quiere volver seleccionar otra tarea? Si desea editar otra tarea del proyecto, inserte " +
                       "'S', de lo contrario" +
                       "pulse cualquier tecla").equalsIgnoreCase("S");
           }
       }while (repeat);

    }
}
