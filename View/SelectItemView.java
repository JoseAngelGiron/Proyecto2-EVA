package View;

import Interface.View_Interface.ISelectView;
import View.Utils.Utils;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SelectItemView implements ISelectView {
    /**
     * Menu encargado de mostrar las distintas opciones de creado disponibles, en relación a las tareas
     * @return una opción, entre las que se muestran en el menú
     */
    @Override
    public int selectTypeOfTask() {
        System.out.println(" ********************************************* ");
        System.out.println("|     -¿Cómo desea crear la tarea?-              |");
        System.out.println(" ********************************************* ");
        System.out.println("| 1- ¿Creación rápida?       (Especifique un     |");
        System.out.println("|                             código)            |");
        System.out.println("|                                                |");
        System.out.println("| 2- ¿Creación personalizada? (Proporcione más   |");
        System.out.println("|                             información)       |");
        System.out.println("|                                                |");
        System.out.println("| 3- Cancelar creación de tarea                  |");
        System.out.println(" ********************************************* ");
        return IO.readNumber("Inserte la opción que desea: ",1,3);
    }
    /**
     * Menu encargado de mostrar las distintas opciones de creado disponibles, en relación a los proyectos
     * @return una opción, entre las que se muestran en el menú
     */
    @Override
    public int selectTypeOfProyect() {
        System.out.println(" *************-¿Cómo desea crear el proyecto?-************* ");
        System.out.println("| 1- ¿Creación rápida?        (Solo especifique un código       |");
        System.out.println("|                                y edite los datos más tarde)   |");
        System.out.println("|                                                               |");
        System.out.println("| 2- ¿Creación personalizada? (Proporcione toda la información) |");
        System.out.println("|                                                               |");
        System.out.println("| 3- Cancelar creación de proyecto                              |");
        System.out.println(" *************- ------------------------- -************* ");
        return IO.readNumber("Inserte la opción que desea: ",1,3);
    }

    /**
     * Función que solicita un nombre y valida dicho nombre haciendo uso de la función "validate name"
     * @return una cadena de texto validada
     */
    @Override
    public String solicitateName() {
        String name;
        do {
            name = IO.readString("Inserte el nombre que desea: ");
            if(!validateName(name)){
                Utils.printMessage("El nombre debe estar entre 4 y 6 caracteres, incluidos números");
            }
        }while(!validateName(name));
        
        return name;
    }

    /**
     * Función que valida una cadena de texto que se le pasa
     * @param name que será la cadena de texto
     * @return true o false, si se encuentra validada, o no
     */
    private boolean validateName(String name) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]{4,6}$");
        return pattern.matcher(name).matches();
    }

    /**
     * Función que solicita un código y que devuelve dicho código, validado haciendo uso de la función validar código
     * @return una cadena de texto validada
     */
    @Override
    public String solicitateCod() {
        String cod;
        do {
            cod = IO.readString("Inserte el cod que desea: ");
            if(!validateCod(cod)){
                Utils.printMessage("El código debe tener 4 numeros, exactamente");
            }
        }while(!validateCod(cod));

        return cod;
    }

    /**
     * Función que valida una cadena de texto que se le pasa
     * @param cod que será la cadena de texto
     * @return true o false, si se encuentra validada, o no
     */
    private boolean validateCod(String cod) {

        Pattern pattern = Pattern.compile("^[0-9]{4}$");
        return pattern.matcher(cod).matches();
    }

    /**
     * Función que solicita una descripción y devuelve dicha descripción validada, haciendo uso de la función
     * validateDescription
     * @return una cadena de texto validad
     */
    @Override
    public String solicitateDescription() {
        String description;
        do {
            description = IO.readString("Inserte una descripción");
            if(!validateDescription(description)){
                Utils.printMessage("El código debe tener hasta 40 caracteres");
            }
        }while(!validateDescription(description));

        return description;
    }
    /**
     * Función que valida una cadena de texto que se le pasa
     * @param description que será la cadena de texto
     * @return true o false, si se encuentra validada, o no
     */
    private boolean validateDescription(String description) {

        Pattern pattern = Pattern.compile("^.{1,40}$");
        return pattern.matcher(description).matches();
    }

    /**
     * Función que recibe una cadena de texto, y la convierte a fecha, controlando los posibles errores
     * @param msg que será un mensaje informativo para el usuario, en función de que fecha se le solicite
     * @return una fecha, que será la que el usuario ha introducido si es valida, o la fecha actual si no es correcta.
     */
    @Override
    public LocalDate solicitateDate(String msg) {
        LocalDate fecha = null;
        Utils.printMessage("La fecha debe cumplir con el formato (formato dd/mm/yyyy)");
        Utils.printMessage("La fecha de inicio, no podrá ser posterior a la de fin");
        Utils.printMessage("En tal caso, se asignara automaticamente la fecha del día de hoy. Podrá cambiarla mas" +
                "adelante en la opción de actualizar las tareas");
        String dateIntroduced = IO.readString(msg);

        String[] dataSeparado = dateIntroduced.split("/");
        try {
            int day = Integer.parseInt(dataSeparado[0]);
            int month = Integer.parseInt(dataSeparado[1]);
            int year = Integer.parseInt(dataSeparado[2]);

            fecha = LocalDate.of(year, month, day);
        } catch (NumberFormatException e) {
            System.err.println("Error: La fecha proporcionada no tiene un formato válido.");

        } catch (ArrayIndexOutOfBoundsException e) {
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


}
