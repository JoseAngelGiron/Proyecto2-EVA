package Controller;

import Interface.Controller_Interface.IselectController;
import Model.*;
import Model.Entity.Proyect;
import Model.Entity.Task;
import View.IO;
import View.SelectItemView;
import View.Utils.Utils;

public class SelectItemController implements IselectController {
    /**
     * Función que controla como se van a crear tareas. Hace uso de una función de selectTypeOfTask para solicitar
     * que como quiere crear la tarea
     * @return una tarea, diseñada por el usuario.
     */
    @Override
    public Task selectTypeTask() {
        SelectItemView view = new SelectItemView();
        int option;
        Task taskCreated = null;
            option = view.selectTypeOfTask();

            switch (option){
                case 1:
                    taskCreated = (Task) TrelloFactory.build ( ElementstTrello.TASK,IO.readString("Inserte el código de la tarea " +
                            "para identificarla de forma univoca"));
                    break;
                case 2:
                    taskCreated = (Task) TrelloFactory.build ( ElementstTrello.TASK,IO.readString("Inserte el código de la tarea " +
                            "para identificarla de forma univoca"));
                    break;
                case 3:
                    Utils.printMessage("Operación de creación de tarea cancelada...");
            }


        return taskCreated;
    }

    /**
     * Función que controla como se van a crear proyectos. Hace uso de una función de selectTypeOfProyect para solicitar
     * al usuario que como quiere crear el proyecto
     * @return un proyecto, diseñado por el usuario.
     */
    @Override
    public Proyect selectTypeProyect() {
        Manage manage = Manage.get_Instance();
        SelectItemView view = new SelectItemView();
        int option;
        Proyect proyect = null;
        option = view.selectTypeOfProyect();

        switch (option){
            case 1:
                proyect = (Proyect) TrelloFactory.build ( ElementstTrello.PROYECT,IO.readString("Inserte el código del proyecto para " +
                        "identificarlo univoca"), manage.getUserLoggedIn());
                break;
            case 2:

                break;
            case 3:
                Utils.printMessage("Operación de creación de proyecto cancelado...");
        }


        return proyect;
    }
}
