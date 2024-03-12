package View.Utils;

import java.io.*;
import java.time.DateTimeException;
import java.time.LocalDate;

public class Utils {
    /**
     * Lee un objeto y lo escribe en un archivo.
     *
     * @param obj  El objeto a escribir en el archivo.
     * @param <T>  El tipo de objeto a escribir.
     */
    public static <T> void fileRead(T obj) {
        String rutaArchivo = ".//ProductivityPilot.txt";
        try {

            FileWriter fileWriter = new FileWriter(rutaArchivo, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(obj.toString());
            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    /**
     * Comprueba si un objeto está presente en un archivo.
     *
     * @param obj  El objeto a buscar en el archivo.
     * @param file La ruta del archivo donde se realizará la búsqueda.
     * @param <T>  El tipo de objeto a buscar.
     * @return true si el objeto se encuentra en el archivo, false si no.
     */
    public static <T> boolean checkInFiles(T obj, String file) {

        boolean found = false;
        try {
            FileInputStream fileIn = new FileInputStream(file);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileIn));
            String lineFile;
            if (obj.equals(obj)) {
                String[] dataUser = obj.toString().split(" ");

                while ((lineFile = bufferedReader.readLine()) != null && !found) {
                    String[] parts = lineFile.split(":");
                    found = (dataUser[0].equals(parts[0]) && (dataUser[2].equals(parts[2])));
                }
            } else {

                while ((lineFile = bufferedReader.readLine()) != null && !found) {
                    found = (obj.toString().equals(lineFile));
                }
            }
            bufferedReader.close();
            fileIn.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return found;
    }

    /**
     * Función generica para imprimir un mensaje
     * @param message el mensaje que va a recibir, que se va a imprimir por pantalla
     */
    public static void printMessage(String message){
        try {
            Thread.sleep(500);
            System.out.println(message);
        }catch (InterruptedException e) {

        }
    }
}
