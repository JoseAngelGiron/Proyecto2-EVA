package View;

import Interface.View_Interface.ISelectView;
import View.Utils.Utils;

import java.time.DateTimeException;
import java.time.LocalDate;

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

    @Override
    public String solicitateName() {
        String name;
        name = IO.readString("Inserte el nombre que desea: ");
        return name;
    }

    @Override
    public String solicitateCod() {
        String cod;
        cod = IO.readString("Inserte un código para identificarlo univocamente: ");
        return cod;
    }

    @Override
    public String solicitateDescription() {
        String description;
        description = IO.readString("Inserte una descripción");
        return description;
    }

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
