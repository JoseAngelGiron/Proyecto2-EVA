import Model.Entity.Task;
import View.IO;
import View.SelectItemView;

public class Test {
    public static void main(String[] args) {
        SelectItemView view = new SelectItemView();
        Task task = new Task("djf","6364","fjgong",view.solicitateDate("Inserte una fecha de inicio: "),view.solicitateDate("Inserte una fecha de fin: "));
    }

}
