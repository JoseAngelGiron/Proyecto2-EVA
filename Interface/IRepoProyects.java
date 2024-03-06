package Interface;

import Model.Proyect;
import Model.User;

import java.util.ArrayList;

public interface IRepoProyects {

    public ArrayList<Proyect> retrieveUserColaboratorProyects(User user);

    public Proyect getByID(String id, User user);

    //Esta función que reciba un newUser y que si los usuarios son iguales, actualiza el user de los proyectos.
    //Funciona porque basicamente user tiene dos claves que son identicas. Me daría problema la contraseña, que no puedo cambiarla

    //public void updateProyectsWithNewUser(User newUser);
}
