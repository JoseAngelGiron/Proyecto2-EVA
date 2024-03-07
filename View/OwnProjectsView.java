package View;

import Interface.IOwnProjectsView;

public class OwnProjectsView implements IOwnProjectsView {
    @Override
    public int showMenuProjects() {
        System.out.println(" *************** - Navegación - ****************** \n");
        System.out.println("1- Crear un proyecto nuevo");
        System.out.println("2- Listar todos sus proyectos");
        System.out.println("3- Ver datos de uno de sus proyectos.");
        System.out.println("4- Actualizar datos de uno de sus proyectos.");
        System.out.println("5- Cerrar uno de sus proyectos. ");
        return IO.readNumber("¿Que opción desea?",1,5);
    }
}
