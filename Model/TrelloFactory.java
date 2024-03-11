package Model;

import Model.Entity.ElementTrello;
import Model.Entity.Proyect;
import Model.Entity.Task;
import Model.Entity.User;

public class TrelloFactory {


    public static ElementTrello build(ElementstTrello elementstTrello, String codigo, User user) {
        ElementTrello result = null;

        switch (elementstTrello) {
            case TASK:
                result = new Task(codigo);
                break;
            case PROYECT:
                result = new Proyect(codigo, user);
                break;
        }
        return result;
    }
    public static ElementTrello build(ElementstTrello elementstTrello, String codigo) {
        ElementTrello result = null;

        switch (elementstTrello) {
            case TASK:
                result = new Task(codigo);
                break;

        }
        return result;
    }
}



