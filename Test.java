import Model.Task;
import Model.User;
import View.IO;
import View.MainView;

import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        Task task = new Task("234");

        System.out.println(task);
        task.changeStatus(IO.readNumber("",1,3));
        System.out.println(task);
    }

}
