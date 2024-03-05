package View;

import Interface.IList;
import Interface.IViewCrud;
import Model.Proyect;
import Model.Task;
import Model.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Iterator;
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
    public int changeProyect(){
        System.out.println(" Seleccione que desea hacer a continuación: ");
        System.out.println("1.-Agregar lista-");
        System.out.println("2.-Agregar tarea a lista-");
        System.out.println("3.-Modificar descripción-");
        System.out.println("4.-Borrar proyecto-");
        System.out.println("5.-Agregar colaborador a tarea-");
        return IO.readNumber("Inserte la opcion que desee: ", 1,999);
    }
    @Override
    public int changeProfile() {
        System.out.println("1.- Cambiar de Nombre-");
        System.out.println("2.- Cambiar de Nickname-");
        System.out.println("3.- Cambiar de Email");
        System.out.println("4.-Cambiar de contraseña-");
        return IO.readNumber("Inserte la opcion que desee",1,4);
    }
    @Override
    //función que pregunte si quiere mostrar sus proyectos de forma opcional, y que pregunte por el número del proyecto a borrar
    public int deleteProyect() {
        System.out.println("1.-Muestrame mis proyectos");
        System.out.println("2.-¿Que proyectos desea borrar?");
        int opcion = IO.readNumber("Inserte la opción que desee", 1, 2);

        return opcion;
    }

    @Override
    // Función que muestra todas las tareas y permite seleccionar una de ellas mediante un número introducido por pantalla
    public int showTasks(ArrayList<Task> tasks) {
        System.out.println("1. Mostrar todas mis tareas por pantalla");
        int opcion = IO.readNumber("Inserte la opción que desee", 1, 1);
        if (opcion == 1) {
            System.out.println("Listado de proyectos:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((tasks.get(i).toString() + (i + 1)) + ". ");
            }
        }
        return 0;
    }
    @Override
    //En esta función, pasa los elementos de el hashSet a ArrayList u otro tipo de lista ordenada, la recorre después
    // y muestra sus elementos. Usa Iterador para recorrer el ArrayList
    public void showProyects(HashSet<Proyect> proyects) {
        ArrayList<Proyect> proyectList = new ArrayList<>(proyects);
        System.out.println("Listado de proyectos:");
        for (Proyect proyecto : proyectList) {
            System.out.println(proyecto.toString());
        }
    }
        }






