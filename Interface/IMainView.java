package Interface;

public interface IMainView {
    // Haz un paquete IO con 2 funciones por ahora, como indica el diagrama de clase
    // leer entero, que tenga que estar el num introducido entre nMenor y nMayor y que imprima previamente el String
    // que se le pasa.

    // La de leer string que se le pase un String, previamente que imprima el mensaje que recibe
    // y luego impida que le texto introducido por el usuario este vacío



    //Opciones 1 login, 2 registrarse, 3 salir
    public int viewLogin();
    //opción 1 registrarse, 2 volver a la pantalla principal
    public int loginError();



}
