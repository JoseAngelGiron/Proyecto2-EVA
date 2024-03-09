package View;

import Interface.View_Interface.ISelectView;

public class SelectItemView implements ISelectView {
    @Override
    public int selectTypeOfTask() {
        System.out.println("¿Como desea crear la tarea?");
        System.out.println("1- ¿Creación rápida? (Especifique solo un código)");
        System.out.println("2- ¿Creación personalizada? (Especifique mas información al respecto)");
        System.out.println("3- Cancelar creación de tarea");
        return IO.readNumber("Inserte la opción que desea",1,3);
    }

    @Override
    public int selectTypeOfProyect() {
        System.out.println("¿Como desea crear el proyecto?");
        System.out.println("1- ¿Creación rápida? (Especifique solo un código)");
        System.out.println("2- ¿Creación personalizada? (Especifique mas información al respecto)");
        System.out.println("3- Cancelar creación de proyecto");
        return IO.readNumber("Inserte la opción que desea",1,3);
    }
}
