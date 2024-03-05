package View;
import java.util.InputMismatchException;
import java.util.Scanner;
public class IO{
    public static Scanner teclado = new Scanner(System.in);

    /**
     * Esta función permite al usuario introducir un mensaje por consola y devuelve dicho mensaje
     * @param msg un mensaje informativo para saber que información se le solicita al usuario
     * @return el mensaje introducido por el usuario
     */
    public static String readString(String msg){
        String msg2;
        do {
            System.out.print(msg + ": ");
            msg2 = teclado.next();

            if (msg2.isEmpty()){
                System.out.println("""
                        Por favor, introduzca algún tipo de información.
                         Pruebe de nuevo por favor\s
                        """);
            }

        } while (msg2.isEmpty());
        return msg2;
    }

    /**
     * Función que permite introducir un número al usuario, entre 2 números que se le pasan
     * @param msg mensaje que se muestra al usuario antes de introducir el número
     * @param numMenor el primer número, el número introducido debe estar por encima de este
     * @param numMayor el segundo número, el número introducido debe estar por debajo de este
     * @return el número introducido, siempre que se encuentre entre el n1 y el n2.
     */
    public static int readNumber(String msg, int numMenor, int numMayor){
        int numero = 0;
        do{
            System.out.print(msg);
            try {
                numero = teclado.nextInt();

            } catch (Exception e) {
                System.out.println("Por favor, introduce un número valido.");
                teclado.nextLine();
            }

            if (numero < numMenor || numero > numMayor){
                System.out.println("La opción introducida no se contempla. Pruebe de nuevo.");
            }

        } while(numero < numMenor || numero > numMayor);
        return numero;
    }
}