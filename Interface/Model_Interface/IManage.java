package Interface.Model_Interface;

import Model.Entity.Proyect;
import Model.Entity.Task;
import Model.Entity.User;

import java.util.ArrayList;

public interface IManage {

    public boolean checkLogin(User userToCheck);

    public void loginUser(User userToLogin);

    public ArrayList<Proyect> retrieveProyects();

    public ArrayList<Task> showAsignedTasks();

    Proyect deleteProyectFromCreator(String id, User userLogged);






}
