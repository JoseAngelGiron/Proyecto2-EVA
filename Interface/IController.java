package Interface;

public interface IController {

    // Llama a main view y mainview. Recoge la opción, y si es 3 sale

    public void startApp();

    //un switch case, con opcion. 1, te logueas, 2 te registras, 3 sales del programa
    //Imprimiendo un mensaje de despedida
    //En opción 1 lees el archivo de texto, en el 2 escribimos en el.
    //Esto ultimo me metere contigo a hacerlo, porque hay que poner control de excepciones y tengo que ver
    //como se hace.
    public void mainController(int opcion);
}
