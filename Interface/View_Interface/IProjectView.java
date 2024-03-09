package Interface.View_Interface;

import Model.Proyect;
import Model.Task;
import Model.User;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;

public interface IProjectView {
    public int chooseWhatToChange();
    String changeCreator();
    void genericMessage(String message) throws InterruptedException;
}
