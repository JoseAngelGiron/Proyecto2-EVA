package View;

import Interface.View_Interface.IViewCrud;
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
        System.out.println(" ¡¡ Bienvenido a ProductivityPilot "+ user.getNickName()+ " !! \n" );
        System.out.println(" Seleccione que desea hacer a continuación: ");
        System.out.println(" *************** - Navegación - ****************** \n");
        System.out.println("1- Entrar a proyectos propios");
        System.out.println("2- Entrar a un proyecto del cual se es colaborador ");
        System.out.println("3- Opciones de usuario");
        System.out.println("4- Cerrar sesión.\n");
        System.out.println("******************- --------------------- - ****************** \n");
        return IO.readNumber("Inserte la opcion que desea: ", 1, 4);

    }
    /**
     * Menu destinado a pedir un identificador del proyecto que se busca, con el objetivo de borrarlo.
     * @return un código de proyecto.
     */
    @Override
    public String deleteProyect() {
        String msg;
        String confirmation;

        msg = IO.readString("Inserte el identificador del proyecto que desea borrar ");

        confirmation = IO.readString("¿Esta seguro que desea proceder? si se encuentra el código, " +
                "se borrara permanentemente el proyecto junto a todos sus datos. \nPulse N/ para cancelar o cualquier otra tecla para proceder." );

        if(confirmation.equalsIgnoreCase("N")){
            msg = " ";
        }

        return msg;
    }

    /**
     * Función que muestra por pantalla un mensaje relacionado con el borrado del proyecto.
     * @param proyectDeleted que será true o false, en función de si el proyecto fue borrado, o no
     */
    @Override
    public void showIfProjectDeleted(Proyect proyectDeleted) {
        if(proyectDeleted!=null){
            System.out.println("El proyecto "+ proyectDeleted.getName() + proyectDeleted.getId() +" que has introducido, ha sido borrado");
        }else{
            System.out.println("No sé encontro ningún proyecto, o cancelaste la opción de borrado.");
        }
    }

    /**
     * Función que muestra todas las tareas y permite seleccionar una de ellas mediante un número introducido por pantalla
     *
     * @param tasks las tareas que se van a mostrar
     * @return una cadena de texto, que se identifica con el código de texto que se le pide al usuario
     */
    @Override
    public String showTasks(ArrayList<Task> tasks){

        for (Task task:tasks){
            System.out.println(task);
        }
        return IO.readString("Introduzca el código de la tarea que desea buscar");
    }

    /**
     * Función que se encarga de mostrar un mensaje de confirmación, en relación a si un proyecto se ha añadido correctamente
     * o no
     * @param add el dato que determinara el mensaje que aparecera por pantalla. True, para confirmar que se añadio correctamente
     *  o false, si no fue así
     */
    @Override
    public void showIfProyectIsAdded(boolean add) {
        if (add) {
            System.out.println("El proyecto fue añadido a la base de datos. Puede consultarlo a partir de ahora con" +
                    "su código de proyecto o de forma general listando sus proyectos añadidos");
        } else {
            System.out.println("Debe haberse confundido, ya existe un proyecto con el mismo código. Pruebe de nuevo, por favor.");
        }
    }


    /**
     * Función encargada de mostrar los datos relativos a un proyecto. Si el objeto que recibe es null, muestra un
     * mensaje diciendo que no se encontro el proyecto
     * @param proyect un objeto de Proyect, del cual se mostraran sus datos.
     */
    @Override
    public void showProject(Proyect proyect) {
        if(proyect==null){
            System.out.println("No se encontro el proyecto asociado al código que ha solicitado." +
                    "Pruebe de nuevo, porfavor ");
        }else {
            System.out.println("-Detalles del proyecto:-");
            System.out.println(proyect);
            System.out.println("-Tareas del proyecto:-");
            for (Task task : proyect.getElements()) {
                System.out.println(task.toString());
            }
        }
    }


    /**
     * Esta función se encarga de mostrar todos los elementos de una lista de proyectos,
     * la recorre y muestra sus elementos.
     * @param proyects Los proyectos que se van a mostrar
     */
    @Override
    public void showProyects(ArrayList<Proyect> proyects) {
        if(proyects != null){
            System.out.println("-Lista de proyectos-.");
            for (Proyect proyect : proyects) {
                System.out.println(proyect.toString());
            }

        }else{
            System.out.println("No se han encontrado proyectos asociados. Pruebe de nuevo, por favor.");

        }

    }
}
