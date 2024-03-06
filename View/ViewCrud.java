package View;

import Interface.IViewCrud;
import Model.Proyect;
import Model.Task;
import Model.User;

import java.util.ArrayList;

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
        System.out.println("4- Actualizar datos de uno de sus proyectos.");
        System.out.println("5- Cerrar uno de sus proyectos. ");
        System.out.println("6- Entrar a un proyecto del cual se es colaborador ");
        System.out.println("7- Opciones de usuario");
        System.out.println("8- Cerrar sesión.\n");
        System.out.println("******************- --------------------- - ****************** \n");
        return IO.readNumber("Inserte la opcion que desea: ", 1, 8);

    }

    /**
     * Menu destinado a elegir entre los distintos proyectos existentes. Permite introducir un código de proyecto.
     * @return un String, que será el código de un proyecto.
     */
    @Override
    public String changeProyect() {

        return IO.readString("Introduzca el id del proyecto que desea modificar: ");
    }


    /**
     * Menu destinado a pedir un identificador del proyecto que se busca, con el objetivo de borrarlo.
     * @return un código de proyecto.
     */
    @Override
    public String deleteProyect() {
        String msg = " ";
        System.out.println("-¿Que proyecto desea borrar?:-");
        msg = IO.readString("-Inserte el identificador del proyecto que desea.-");
        boolean confirmado = false;
        //modifica para pedir confirmación antes de enviar.
        do {
            System.out.print("-¿Está seguro de que desea borrar el proyecto?-.");
            String borrar =borrar.nextLine().trim().toLowerCase();
            if (borrar.equals("Sí")||borrar.equals("Si")){
            } else if (borrar.equals("No")) {
                System.out.println("-Operación cancelada-.");
            } else {
                System.out.println("-Respuesta inválida. Por favor, responda con 'Sí' o 'No'.-");
            }
        } while (!confirmado);
        return msg;
    }

    /**
     * Función que muestra todas las tareas y permite seleccionar una de ellas mediante un número introducido por pantalla
     *
     * @param tasks las tareas que se van a mostrar
     * @return un número, entre 1 y 999
     */ //Esta función me la cambias, que devuelva un string y con ITERATOR
    @Override
    public String showTasks(ArrayList<Task> tasks){
        StringBuilder taskList = new StringBuilder();
        for (int i = 0; i < tasks.size(); i++){
            taskList.append(tasks.get(i).toString()).append(" (").append(i + 1).append(")\n");
        }
        return taskList.toString();
    }

    @Override
    public void showIfProyectIsAdded(boolean add) {
        if (add) {
            System.out.println("¡El proyecto fue añadido con éxito!");
        } else {
            System.out.println("El proyecto no pudo ser añadido.");
        }
    }



    @Override
    public void showProject(Proyect proyect) {
        System.out.println("-Detalles del proyecto:-");
        System.out.println(proyect.toString());
        System.out.println("-Tareas del proyecto:-");
        for (Task task : proyect.getElements()) {
            System.out.println(task.toString());
        }
    }


    /**
     * Esta función se encarga de mostrar todos los elementos de una lista de proyectos,
     * la recorre y muestra sus elementos.
     * @param proyects Los proyectos que se van a mostrar
     */
    @Override
    public void showProyects(ArrayList<Proyect> proyects) {
        System.out.println("-Lista de proyectos-.");
        for (Proyect proyect : proyects) {
            System.out.println(proyect.toString());
        }
    }
}
