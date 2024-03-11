package View;

import Interface.View_Interface.IProjectView;
import Model.Entity.Task;

public class UpdateProjectView implements IProjectView {
    /**
     * Función encargada de mostrar un menú en relación a las distintas opciones de actualización de un proyecto
     * @return la opción introducida por el usuario, que será una de las que se muestran en el menú
     */
    @Override
    public int chooseWhatToChange() {
        System.out.println("\n ****** - Menu de actualización de proyectos - ******");
        System.out.println("1.- Cambiar el nombre proyecto-.");
        System.out.println("2.- Cambiar la descripción del proyecto-.");
        System.out.println("3.- Añadir una tarea al proyecto-.");
        System.out.println("4.- Eliminar una tarea del proyecto-.");
        System.out.println("5.- Modificar tareas-."); //Aqui dentro va el añadir los colaboradores
        System.out.println("6.- Cambiar creador del proyecto-");
        System.out.println("7.- Salir");
        return IO.readNumber(" ¿Que desea cambiar?: ",1,7);
    }

    /**
     * Función encargada de mostrar un mensaje de aviso, en relación al cambio de creador de un proyecto
     * @return un cadena de texto que es la introducida por el usuario
     */
    @Override
    public String changeCreator() {
        System.out.println(" ¡AVISO! ¡¡Esta opción es irreversible, y transferira todos los permisos de modificación al nuevo usuario !!. \n ");
        System.out.println(" Si desea cancelar, no introduzca ningún nombre valido de usuario");
        return IO.readString("Inserte el apodo de un usuario ya existente: ");
    }

    @Override
    public void showTaskRemoved(Task task) {
        if(task!=null){
            System.out.println("Los datos de la tarea que se eliminaron fueron: ");
            System.out.println(task);
        }else{
            System.out.println("No se encontro la tarea en cuestión.");
        }
    }


}
