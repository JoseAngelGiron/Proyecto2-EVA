package View;

import Interface.IProjectView;
import Model.Proyect;
import Model.Task;
import Model.User;

import java.util.ArrayList;

public class ProjectView implements IProjectView {
    @Override
    public int chooseWhatToChange() {
        return 0;
    }

    @Override
    public void showProject(Proyect proyect) {

    }

    @Override
    public void showIfProyectIsAdded(boolean add) {

    }

    @Override
    public int showTasks(ArrayList<Task> tasks) {
        return 0;
    }

    @Override
    public int welcomeUser(User user) {
        return 0;
    }

    @Override
    public void showProyects(ArrayList<Proyect> proyects) {

    }

    @Override
    public String changeProyect() {
        return null;
    }

    @Override
    public int changeProfile() {
        return 0;
    }

    @Override
    public String deleteProyect() {
        return null;
    }
}
