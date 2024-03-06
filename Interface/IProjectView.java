package Interface;

import Model.Proyect;
import Model.Task;
import Model.User;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;

public interface IProjectView {

    public int chooseWhatToChange();

    public void showProject(Proyect proyect);

    public void showIfProyectIsAdded(boolean add);

    public int showTasks(ArrayList<Task> tasks);


    public int welcomeUser(User user);

    public void showProyects(ArrayList<Proyect> proyects);


    public String changeProyect();


    public int changeProfile();


    public String deleteProyect();










}
