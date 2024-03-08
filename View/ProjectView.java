package View;

import Interface.IProjectView;
import Model.Proyect;
import Model.Task;
import Model.User;

import java.util.ArrayList;

public class ProjectView implements IProjectView {
    @Override
    public int chooseWhatToChange() {
        System.out.println("1.-Cambiar el nombre proyecto-.");
        System.out.println("2.-Cambiar del proyecto descripción-.");
        System.out.println("3.-Modificar tareas-.");
        System.out.println("4.-Cambiar usuario-.");
        System.out.println("5.-Cambiar creador-");
        return IO.readNumber("-¿Que desea cambiar?-",1,5);
    }


}
