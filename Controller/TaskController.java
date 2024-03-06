package Controller;

import Interface.ITaskController;
import Model.Manage;
import View.ViewCrud;

public class TaskController implements ITaskController {


    @Override
    public void controllerTask() {
        Manage manage = Manage.get_Instance();
        ViewCrud view = new ViewCrud();
        int optionSubMenu;
        do{
            optionSubMenu = view.chooseWhatToChange();
            switch (optionSubMenu){
                case 1:
                    //Actualizar nombre de la tarea
                    break;
                case 2:
                    //Actualizar descripción
                    break;
                case 3:
                    //Ca
                    break;
                case 4:
                    //AQUI TENGO QUE LLAMAR A OTRO SUB MENU PARA CAMBIAR UNA TAREA EN CONCRETO.
                    break;
                case 5:
                    //Mensaje de despedida de este sub menu.
                    break;
            }

        }while (optionSubMenu!=5);
    }
}
