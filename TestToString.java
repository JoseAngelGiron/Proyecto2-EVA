import Model.Proyect;
import Model.Task;
import Model.TaskStatus;
import Model.User;

import java.time.LocalDate;

public class TestToString {
    public static void main(String[] args) {


        // Crear un objeto de tipo User para pasar al constructor de Task
        User colaborator1 = new User("John Doe", "johnny", "john@example.com", "password123");
        User colaborator2 = new User("Alice Smith", "alice", "alice@example.com", "password456");
        User colaborator3 = new User("Bob Johnson", "bob", "bob@example.com", "password789");

        // Inicializar tres objetos Task utilizando el constructor proporcionado
        Task task1 = new Task("20", LocalDate.now(), LocalDate.now().plusDays(7), TaskStatus.IN_PROGRESS, colaborator1);
        Task task2 = new Task("2", LocalDate.now(), LocalDate.now().plusDays(5), TaskStatus.NOT_STARTED, colaborator2);
        Task task3 = new Task("3", LocalDate.now(), LocalDate.now().plusDays(10), TaskStatus.COMPLETED, colaborator3);

        // Imprimir la representación de cadena de cada tarea utilizando el método toString
        System.out.println("Task 1: " + task1.toString());
        System.out.println("Task 2: " + task2.toString());
        System.out.println("Task 3: " + task3.toString());

        System.out.println();
        System.out.println();

        // Crear un objeto de tipo User para el creador del proyecto
        User projectCreator = new User("John Doe", "johnny", "john@example.com", "password123");

        // Inicializar un objeto Project utilizando el constructor proporcionado
        Proyect project = new Proyect("Project 1", "P1", "Description of Project 1", projectCreator);

        // Imprimir los detalles del proyecto
        System.out.println(project.toString());
    }
}

