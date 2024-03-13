import Model.Entity.Proyect;
import Model.Entity.Task;
import Model.Entity.User;
import View.IO;
import View.SelectItemView;

public class Test {
    public static void main(String[] args) {
        /*SelectItemView view = new SelectItemView();
        Task task = new Task("djf","636","fjgong",view.solicitateDate("Inserte una fecha de inicio: "),view.solicitateDate("Inserte una fecha de fin: "));
        System.out.println(task);*/
        User user = new User("ho","ho","a@gmail.com","slkdj");
        Proyect proyect = new Proyect("hola","hola","holaowld",user);
        System.out.println(proyect);
    }

}
