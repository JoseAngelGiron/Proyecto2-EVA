package View;
import java.util.InputMismatchException;
import java.util.Scanner;
public class IO{
    public static Scanner scanner = new Scanner(System.in);
    public static String readString(String msg){
        System.out.print(msg);
        return scanner.nextLine();
    }
    public static String readEmpty(String msg){
        String empty;
        do{System.out.print(msg);
            empty= scanner.nextLine();
        }while (empty.isEmpty());
        System.out.println("El mensaje esta vacío,Introduce otro numero");
        return empty;
    }
    public static int readNumber(String msg, int numMenor, int numMayor){
        int numero = 0;
        do{
            System.out.print(msg);
            try {
                numero = scanner.nextInt();
                if (numero < numMenor || numero > numMayor){
                    System.out.println("Número no permitido.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor,Introduce un número valido.");
                scanner.nextLine();
            }
            } while(numero < numMenor || numero > numMayor);
        return numero;
    }
}