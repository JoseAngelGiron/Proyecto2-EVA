package Controller;

import Interface.Controller_Interface.IselectController;
import Model.*;
import Model.Entity.Proyect;
import Model.Entity.Task;
import View.IO;
import View.SelectItemView;
import View.Utils.Utils;

import java.time.LocalDate;

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
                            "para identificarla de forma univoca"), Manage.get_Instance().getUserLoggedIn());
                    break;
                case 2:
                    taskCreated = (Task) TrelloFactory.build ( ElementstTrello.TASK,IO.readString("Inserte el nombre de la tarea "),
                            IO.readString("Inserte el código de la tarea por el cual se identificara"),
                            IO.readString("Inserte una descripción"),Manage.get_Instance().getUserLoggedIn(),
                            LocalDate.parse(IO.readString("Inserte una fecha de fin")),LocalDate.parse(IO.readString("Inserte una fecha de inicio "))
                             );
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
                proyect = (Proyect) TrelloFactory.build ( ElementstTrello.PROYECT,IO.readString("Inserte el código del proyecto por el " +
                        "que se identificara"), manage.getUserLoggedIn());
                break;
            case 2:
                proyect = (Proyect) TrelloFactory.build (ElementstTrello.PROYECT,IO.readString("Inserte el nombre del proyecto "),
                        IO.readString("Inserte el código del proyecto por el cual se identificara"),
                        IO.readString("Inserte una descripción"), Manage.get_Instance().getUserLoggedIn(),
                        LocalDate.parse(""), LocalDate.parse(""));
                break;
            case 3:
                Utils.printMessage("Operación de creación de proyecto cancelado...");
        }


        return proyect;
    }
}
