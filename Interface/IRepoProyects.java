package Interface;

import Model.Proyect;
import Model.User;

import java.util.ArrayList;

public interface IRepoProyects {
    //Basicamente, necesito que recorras el array de proyectos y sus respectivas tareas, y me compares el user
    // con uno de los 3 users que tiene el array de colaborador de las tareas. Si encaja, me devuelves el proyecto
    // en cuestión en el array list.
    public ArrayList<Proyect> retrieveUserColaboratorProyects(User user);

    //Esta función que reciba un newUser y que si los usuarios son iguales, actualiza el user de los proyectos.
    //Funciona porque basicamente user tiene dos claves que son identicas. Me daría problema la contraseña, que no puedo cambiarla

    //public void updateProyectsWithNewUser(User newUser);
}
