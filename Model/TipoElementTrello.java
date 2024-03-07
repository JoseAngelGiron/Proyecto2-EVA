package Model;

public class TipoElementTrello{


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
    public static ElementTrello build(ElementstTrello elementstTrello, String codigo, User user, String fff) {
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
}



