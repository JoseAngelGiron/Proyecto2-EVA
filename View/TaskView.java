package View;

import Interface.View_Interface.ITaskView;
import Model.Entity.Proyect;
import Model.Entity.Task;
import Model.Entity.User;

import java.util.ArrayList;

public class TaskView implements ITaskView {

    /**
     * Metodo que muestra el menu del editor de tareas y permite seleccionar una opción de entre las disponibles
     * @return un número, que se corresponderá con una de las opciones del editor de tareas
     */
    @Override
    public int taskView() {
        System.out.println("\n ****** - Editor de tareas - ******");
        System.out.println("1- Visualizar el estado de la tarea");
        System.out.println("2- Cambiar el nombre de la tarea");
        System.out.println("3- Cambiar la descripción de la tarea.");
        System.out.println("4- Cambiar las fechas de la tarea.");
        System.out.println("5- Cambiar el estado de la tarea.");
        System.out.println("6- Modificar colaboradores de tarea.");
        System.out.println("7- Salir.");
        System.out.println("****** - -------------- - ****** \n");
        return IO.readNumber("Inserte la opción deseada: ",1,7);
    }

    /**
     * Función que muestra todas las tareas disponibles y permite seleccionar una de ellas, introduciendo su código
     * @param proyect el proyecto, sobre el cual se van a mostrar sus tareas
     * @return una cadena de texto, con la que se identifica el código de la tarea
     */
    @Override
    public String selectTask(Proyect proyect) {
        for(Task task: proyect.getElements()){
            System.out.println(task.toString());
        }
        return IO.readString("Inserte el ID de la tarea que desea seleccionar: ");
    }

    /**
     * Función que muestra un menu en relación al cambio de estado de una tarea y devuelve una opción
     * introducida por el usuario, entre las que se muestran en el menu
     * @return la opción, que será entre uno de los números disponibles que se muestran en el menu
     */
    @Override
    public int changeStatusMenu() {
        System.out.println(" ¿Que nuevo estado desea asignarle a la tarea? ");
        System.out.println("1- No empezada");
        System.out.println("2- En progreso ");
        System.out.println("3- Completada");
        System.out.println("4- Cancelar operación");
        return IO.readNumber("Inserte el nuevo el nuevo estado de la tarea: ",1,4);
    }

    /**
     * Metodo encargado de mostrar por pantalla información relacionada al des-asignamiento de un usuario a una tarea
     * @param user que será el usuario sobre el que se mostrara información. Si es null, se imprimira un mensaje distinto
     */
    @Override
    public void showCollaboratorUnassigned(User user) {
        if(user!=null){
            System.out.println("El usuario "+user.getName()+" fue eliminado como colaborador de la tarea");
        }else{
            System.out.println("No se encontro el colaborador.");
        }
    }



    /**
     * Función que muestra información en relación si un colaborador fue añadido, o no, debido a que este no fue encontrado
     * @param user que será el colaborador sobre el que se mostrará la información
     */
    @Override
    public void showColaboratorAdd(User user) {
        if(user!=null){
            System.out.println("El usuario "+user.getName()+" fue añadido a la tarea");
        }else{
            System.out.println("No se encontro el colaborador.");
        }
    }

    /**
     * Función encargada de mostrar una lista de proyectos y devolver una opción que el usuario ha introducido por pantalla
     * @param proyects la lista de proyectos que recibe
     * @return la opción que el usuario ha introducido por pantalla
     */
    @Override
    public String showProyects(ArrayList<Proyect> proyects) {
        System.out.println("La lista de proyectos en la que figura como colaborador es :");
        for (Proyect proyect: proyects){
            System.out.println(proyect);
        }
        return IO.readString("Inserte el código de uno de los proyectos a los que quiere acceder: ");
    }

    /**
     * Función encargada de mostrar una lista de tareas y que permite introducir texto, que debería corresponderse con
     * uno de los códigos de las tareas que se muestran.
     * @param proyect el proyecto, sobre el que se van a mostrar las tareas
     * @return una cadena de texto, la cual el usuario ha introducido por pantalla.
     */
    @Override
    public String showTasks(Proyect proyect) {
        System.out.println("La lista de tareas de las que es colaborador es: ");
        for (Task task: proyect.getElements()){
            System.out.println(task);
        }
        return IO.readString("Inserte el código de una de las tareas para modificar su estado: ");
    }

    /**
     * Función encargada de mostrar los comentarios emparejados a una tarea
     * @param task que será la tarea sobre la que se mostrarán los comentarios
     */
    @Override
    public void showTask(Task task) {
        System.out.println("El estado actual de la tarea es el siguiente: ");
        System.out.println(task);
        System.out.println("Los datos relacionados con la tarea hasta ahora, son : ");
        for(String comentary:task.getFeedback()){
            System.out.println(comentary);
        }
    }

    /**
     * Función que nos muestra un simple menú y que nos permite seleccionar entre las opciones que muestra.
     * @return un número, que es el que el usuario introduce por consola, entre las opciones que se le muestran.
     */
    @Override
    public int selectAssignOrUnassigned() {
        System.out.println(" ¿Que desea hacer? ");
        System.out.println("1- Añadir colaborador");
        System.out.println("2- Eliminar colaborador ");
        System.out.println("3- Cancelar operación");
        return IO.readNumber("Introduzca la opción que desea: ",1,3);
    }


}
