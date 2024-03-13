package View;

import Interface.View_Interface.IOwnProjectsView;

public class OwnProjectsView implements IOwnProjectsView {
    /**
     * Función encarga de mostrar todas las opciones en relación al menú de la creación de proyectos
     * @return una opción, entre las que se corresponden con las mostradas en el menú
     */
    @Override
    public int showMenuProjects() {
        System.out.println(" *************** - Relación de proyectos - ****************** \n");
        System.out.println("| 1- Crear un proyecto nuevo                                  |");
        System.out.println("| 2- Listar todos sus proyectos                               |");
        System.out.println("| 3- Ver datos de uno de sus proyectos                        |");
        System.out.println("| 4- Actualizar datos de uno de sus proyectos                 |");
        System.out.println("| 5- Cerrar uno de sus proyectos                              |");
        System.out.println("| 6- Volver al menú de navegación                             |");
        System.out.println("  **************** - ------------------- - ****************** \n");
        return IO.readNumber("¿Que opción desea?: ",1,6);
    }
}
