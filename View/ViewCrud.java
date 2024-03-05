package View;

import Interface.IViewCrud;
import Model.Proyect;
import Model.Task;
import Model.User;

import java.util.ArrayList;
import java.util.HashSet;

public class ViewCrud implements IViewCrud {

    /**
     * Muestra un menú de bienvenida al usuario que recién se loguea en la aplicación, permitiendole elegir entre las
     * opciones deseadas.
     * @param user que son los datos del usuario que se ha logueado en la aplicación
     * @return un número, entre las opciones especificadas
     */
    @Override
    public int welcomeUser(User user) {
        System.out.println(" ¡¡ Bienvenido a trello 2.0"+ user.getNickName()+ " !! ");
        System.out.println(" Seleccione que desea hacer a continuación: ");

        System.out.println(" *************** - Navegación - ****************** \n");
        System.out.println("1- Crear un proyecto nuevo");
        System.out.println("2- Listar todos sus proyectos");
        System.out.println("3- Ver datos de uno de sus proyectos.");
        System.out.println("3- Actualizar datos uno de sus proyectos.");
        System.out.println("4- Cerrar uno de sus proyectos. ");
        System.out.println("5- Ver tareas asignadas de otros proyectos ");
        System.out.println("6- Opciones de usuario");
        System.out.println("7- Cerrar sesión. \n");
        System.out.println("******************- --------------------- - ****************** \n");
        return IO.readNumber("Inserte la opcion que desea: ", 1, 7);

    }



    /**
     * Menu destinado a elegir entre los distintos proyectos existentes. Permite elegir entre 1 y 999, siendo estos los
     * proyectos distintos.
     * @return un número, entre 1 y 999.
     */
    @Override
    public int changeProyect() {
        return IO.readNumber("Introduzca el id del proyecto que desea modificar: ", 1,999);
    }

    @Override
    public int changeProfile() {
        return 0;
    }

    @Override
    public int deleteProyect() {
        return 0;
    }

    @Override
    public int showTasks(ArrayList<Task> tasks) {
        return 0;
    }


    @Override
    public void showProyects(HashSet<Proyect> proyects) {

    }


}
