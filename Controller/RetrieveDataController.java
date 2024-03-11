package Controller;

import Interface.Controller_Interface.IRetrieveDataController;
import Model.Manage;
import Model.Entity.Proyect;
import Model.Entity.Task;
import View.IO;

public class RetrieveDataController implements IRetrieveDataController {

    /**
     * Metodo destinado a controlar el pedido de datos sobre uno de los proyectos del usuario que tiene iniciada la sesión y
     * devolver el proyecto que ha solicitado
     * @return El objeto Proyecto que ha solicitado, que puede ser null si no se encuentra y cancela la opción
     */
    @Override
    public Proyect retrieveProyect() {
        Manage manage = Manage.get_Instance();
        String confirmation;
        Proyect proyect;
        do {
            confirmation =" ";

            proyect = manage.getRepoProyects().getByID((IO.readString(
                    "Inserte el código del proyecto que desea seleccionar")), manage.getUserLoggedIn());

            if (proyect==null){
                confirmation = IO.readString("Error al introducir el código. ¿Desea volver a introducir otro código de proyecto?" +
                        " S/para pedir otro código. Cualquier otra tecla para volver al menu anterior.");
            }

        }while (confirmation.equalsIgnoreCase("S"));
        return proyect;
    }

    /**
     * Metodo destinado a controlar el pedir datos sobre una de las tareas que el usuario que tiene iniciada la sesión y
     * devolver el tarea que ha pedido
     * @param proyect el proyecto sobre el que se van a pedir datos de las tareas
     * @return un objeto del tipo tarea, solicitado por el usuario. Este puede ser null, si el usuario cancela la operación.
     */
    @Override
    public Task retrieveTask(Proyect proyect) {
        Manage manage = Manage.get_Instance();
        Task task;
        String confirmation;

        do {
            confirmation =" ";

            task = manage.getRepoProyects().retrieveTaskFromProject(IO.readString(
                    "Inserte el código de tarea que desea seleccionar"), proyect);

            if (task==null){
                confirmation = IO.readString("Error al introducir el código. ¿Desea volver a introducir otro código de tarea?" +
                        " S/para pedir otro código. Cualquier otra tecla para volver al menu anterior.");
            }

        }while (confirmation.equalsIgnoreCase("S"));
        return task;
    }
}
