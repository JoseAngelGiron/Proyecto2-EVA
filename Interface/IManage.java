package Interface;

import Model.Proyect;
import Model.Task;
import Model.User;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface IManage {

    public boolean checkLogin(User userToCheck);

    public void loginUser(User userToLogin);

    public ArrayList<Proyect> retrieveProyects();

    public ArrayList<Task> showAsignedTasks();




}
