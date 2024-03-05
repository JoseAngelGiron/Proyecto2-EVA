package Model;

public class TipoElementTrello{


    public static ElementTrello build(ElementstTrello elementstTrello) {
        ElementTrello result = null;

        switch (elementstTrello) {
            case TASK:
                result = new Task();
                break;
            case PROYECT:
                result = new Proyect();
                break;
        }
        return result;
    }
    public static ElementTrello build(ElementstTrello elementstTrello, int o) {
        ElementTrello result = null;

        switch (elementstTrello) {
            case TASK:
                result = new Task();
                break;
            case PROYECT:
                result = new Proyect();
                break;
        }
        return result;
    }
}



