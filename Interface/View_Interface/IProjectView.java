package Interface.View_Interface;

import Model.Entity.Task;

public interface IProjectView {
    public int chooseWhatToChange();
    String changeCreator();
    void showTaskRemoved(Task task);
    void showTaskAdded(Task task);

}
