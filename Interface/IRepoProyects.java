package Interface;

import Model.Proyect;
import Model.Task;
import Model.User;

import java.util.ArrayList;

public interface IRepoProyects {

    ArrayList<Proyect> retrieveUserColaboratorProyects(User user);
    Proyect retrieveProyectIfColaborator(User user, String id);
    Task retrieveTask(User userToCharge, String idTask);
    boolean updateTask(Task task, Proyect proyect);
    Proyect getByID(String id, User user);
    void update(User user);
    private void updateTasks(User newUser){

    }
}
