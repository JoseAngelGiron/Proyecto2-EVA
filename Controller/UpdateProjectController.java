package Controller;

import Interface.IUpdateProjectController;
import Model.Manage;
import Model.Proyect;
import View.IO;
import View.ProjectView;

public class UpdateProjectController implements IUpdateProjectController {

    /**
     * Esta función se encarga de Controlar las distintas opciones de actualización en relación a los proyectos.
     */
    @Override
    public void updateProjectController() {
        Manage manage = Manage.get_Instance();
        ProjectView projectView = new ProjectView();
        //Aqui muestro todos sus proyectos previamente, si el lo solicita
        Proyect proyect = Manage.get_Instance().getRepoProyects().getByID(IO.readString("Inserte el código de el proyecto que desea actualizar"), Manage.get_Instance().getUserLoggedIn());

        if (proyect != null) {
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
            //Mensaje de error. Que se haga en la vista.
        }

        //Lo actualizo
        //con la lógica de Update en cada case. La función de cambiar creador es algo engañosa, porque deberiamos sacar
        //al usuario de este controlador ya que no tiene permiso para seguir editando los datos relativos al proyecto.
    }
}
