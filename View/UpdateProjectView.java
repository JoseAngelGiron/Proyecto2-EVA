package View;

import Interface.View_Interface.IProjectView;

public class UpdateProjectView implements IProjectView {
    @Override
    public int chooseWhatToChange() {
        System.out.println("1.- Cambiar el nombre proyecto-.");
        System.out.println("2.- Cambiar la descripción del proyecto-.");
        System.out.println("3.- Cambiar la descripción del proyecto-.");
        System.out.println("4.- Modificar tareas-."); //Aqui dentro van los colaboradores
        System.out.println("5.- Cambiar creador del proyecto-");
        System.out.println("6.- Salir");
        return IO.readNumber("-¿Que desea cambiar?-",1,6);
    }

    @Override
    public String changeCreator() {
        System.out.println(" ¡AVISO! ¡¡Esta opción es irreversible, y transferira todos los permisos de modificación al nuevo usuario !!. \n ");
        System.out.println(" Si desea cancelar, no introduzca ningún nombre valido de usuario");
        return IO.readString("Inserte el apodo de un usuario ya existente: ");
    }




}
