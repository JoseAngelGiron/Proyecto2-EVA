package Interface;

import Model.User;

public interface IViewCrud {

    //Menu de bienvenida al usuario que se loguea. Que devuelva una opción sobre que quiere hacer
    //opciones: ver proyectos propios, ver proyectos que es colaborador, crear un proyecto, acceder a un proyecto,
    // cerrar sesión
    public int welcomeUser(User user);

    //opciones: agregar lista, agregar tarea a lista, modificar descripción, borrar proyecto, agregar colaborador a tarea
    public int changeProyect();
}
