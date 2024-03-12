package View.Utils;

import java.io.*;
import java.time.DateTimeException;
import java.time.LocalDate;

public class Utils {
    /**
     * Lee un objeto y lo escribe en un archivo.
     *
     * @param obj  El objeto a escribir en el archivo.
     * @param file La ruta del archivo donde se escribirá el objeto.
     * @param <T>  El tipo de objeto a escribir.
     */
    public static <T> void fileRead(T obj, String file) {

        try {
            // el true es para que de inserte debajo de lo que ya existe
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(obj.toString());
            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static LocalDate dataTime (String dataString) {

        String[] dataSeparado = dataString.split("/");

        LocalDate fecha = null;
        try {
            int day = Integer.parseInt(dataSeparado[0]);
            int month = Integer.parseInt(dataSeparado[1]);
            int year = Integer.parseInt(dataSeparado[2]);

            fecha = LocalDate.of(year, month, day);
        } catch (NumberFormatException e) { //Para capturar errores al convertir de texto a entero. Que pongan letras
            //System.err.println("Error: La fecha proporcionada no tiene un formato válido.");
            throw new NumberFormatException();
        } catch (ArrayIndexOutOfBoundsException e) { // Que no tiene el formato especifico la fecha es decir dia/mes/año
            // deve ponerse de la forma que se separe con el simbolo puesto en dataString.split
            System.err.println("Error: La fecha proporcionada no tiene el formato esperado.");
        } catch (DateTimeException e) {
            System.err.println("Error en la fecha: la fecha no existe");
        } catch (Exception e) {
            System.err.println("Error");
        }
        if(fecha==null){
            fecha=LocalDate.now();
        }


        return fecha;
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
