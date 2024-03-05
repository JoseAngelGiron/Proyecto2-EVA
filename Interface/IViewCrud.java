package Interface;

import Model.Proyect;
import Model.Task;
import Model.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public interface IViewCrud {


    public int welcomeUser(User user);



    //En esta función, pasa los elementos de el hashSet a ArrayList u otro tipo de lista ordenada, la recorre después
    // y muestra sus elementos. Usa Iterador para recorrer el ArrayList
    public void showProyects(HashSet<Proyect> proyects);

    //opciones: agregar lista, agregar tarea a lista, modificar descripción, borrar proyecto, agregar colaborador a tarea
    public int changeProyect();

    //Menu que debe mostrar entre las distintas opciones del perfil del usuario, nombre, nickname... selecionar una de ellas y poder
    //devolver el número de esa opción.
    public int changeProfile();

    //función que pregunte si quiere mostrar sus proyectos de forma opcional, y que pregunte por el número del proyecto a borrar
    public int deleteProyect();

    //Función que muestre todas las tareas que recibe y permita selecionar una de ellas con un número que se le introduzca por pantalla
    public int showTasks(ArrayList<Task> tasks);


}
