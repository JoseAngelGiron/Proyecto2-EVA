package Controller;

import Interface.IUpdateProjectController;
import Model.*;
import View.IO;
import View.MainView;
import View.ProjectView;

public class UpdateProjectController implements IUpdateProjectController {

    /**
     * Esta función se encarga de Controlar las distintas opciones de actualización en relación a los proyectos.
     */
    @Override
    public void updateProjectController() {
        Manage manage = Manage.get_Instance();
        ProjectView projectView = new ProjectView();
        Proyect proyect = Manage.get_Instance().getRepoProyects().getByID(IO.readString("Inserte el código de el proyecto que desea actualizar"), Manage.get_Instance().getUserLoggedIn());

        if (proyect != null) {
            int optionSubMenu;
            do {
                optionSubMenu = projectView.chooseWhatToChange();
                switch (optionSubMenu) {
                    case 1:
                        String newName = IO.readString("Inserte el nuevo nombre del proyecto: ");
                        proyect.setName(newName);
                        break;
                    case 2:
                        String newDescription = IO.readString("Inserte la nueva descripción del proyecto: ");
                        proyect.setDescription(newDescription);
                        break;
                    case 3:
                        String newCreatorNickName = IO.readString("Inserte el apodo del nuevo creador:");
                        User newCreator = null;
                        for (User user : Manage.get_Instance().getUsers().getElements()) {
                            if (user.getNickName().equals(newCreatorNickName)) {
                                newCreator = user;
                            }
                        }
                        if (newCreator != null) {
                            proyect.setProjectCreator(newCreator);
                            System.out.println("El creador del proyecto se ha actualizado correctamente.");
                        }
                        break;
                    case 4:
                        boolean taskChanged = submenu();
                        //Falta el submenu
                        if (taskChanged) {
                            System.out.println("La tarea se ha actualizado correctamente.");
                        }
                        break;
                    case 5:
                        System.out.println("Gracias por usarlo");
                        //Mensaje de despedida de este sub menu.
                        break;
                }

            } while (optionSubMenu != 5);

        } else {
            //Aqui va el mensaje de error de la clase MainView lo que pasa es que por evitar conflictos no lo he puesto
        }
    }
}
