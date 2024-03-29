package Interface.Repo_Interface;

import Model.Entity.Proyect;
import Model.Entity.Task;
import Model.Entity.User;

import java.util.ArrayList;

public interface IRepoProyects {

    ArrayList<Proyect> retrieveUserColaboratorProyects(User user);
    Proyect retrieveProyectIfColaborator(User user, String id);
    Task retrieveTask(User userToCharge, String idTask);
    Task retrieveTaskFromProject(String idTarea, Proyect proyect);
    boolean updateTask(Task task, Proyect proyect);
    Proyect getByID(String id, User user);
    void update(User user);
    private void updateTasks(User newUser){

    }
}
