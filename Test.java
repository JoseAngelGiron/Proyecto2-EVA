import Model.Entity.Task;
import View.IO;

public class Test {
    public static void main(String[] args) {
        Task task = new Task("234");

        System.out.println(task);
        task.changeStatus(IO.readNumber("",1,3));
        System.out.println(task);
    }

}
