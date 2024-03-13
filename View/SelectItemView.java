package View;

import Interface.View_Interface.ISelectView;

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
}
