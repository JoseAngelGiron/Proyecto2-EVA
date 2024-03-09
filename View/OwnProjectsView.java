package View;

import Interface.View_Interface.IOwnProjectsView;

public class OwnProjectsView implements IOwnProjectsView {
    @Override
    public int showMenuProjects() {
        System.out.println(" *************** - Relación de proyectos - ****************** \n");
        System.out.println("1- Crear un proyecto nuevo");
        System.out.println("2- Listar todos sus proyectos");
        System.out.println("3- Ver datos de uno de sus proyectos.");
        System.out.println("4- Actualizar datos de uno de sus proyectos.");
        System.out.println("5- Cerrar uno de sus proyectos. ");
        System.out.println("6- Volver al menu de navegación. ");
        return IO.readNumber("¿Que opción desea?",1,6);
    }
}
