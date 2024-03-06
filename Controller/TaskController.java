package Controller;

import Interface.ITaskController;
import Model.Manage;
import Model.Proyect;
import View.TaskView;
import View.ViewCrud;

public class TaskController implements ITaskController {

    /**
     * Función encargada de gestionar lo relacionado con las opciones de actualización de una tarea.
     */
    @Override
    public void controllerTask(Proyect proyect) {
        Manage manage = Manage.get_Instance();
        //Aqui muestro todos los datos relativos a todos las tareas de un proyecto.
        //Selecciono una, del proyecto y si existe, que entre al sub-menu. Desde este submenu también modificamos
        //La cosa esta de

        TaskView view = new TaskView();


        int optionSubMenu;
        do{
            optionSubMenu = view.taskView();
            switch (optionSubMenu){
                case 1:
                    //Actualizar nombre de la tarea
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
                case 6:
                    //Asignar un colaborador a cargo de la tarea.
                case 5:
                    //Mensaje de despedida de este sub menu.
                    break;
            }

        }while (optionSubMenu!=6);
    }
}
