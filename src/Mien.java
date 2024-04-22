
import java.util.Scanner;



public class Mien {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el tamaño de la cola:");
        int capacidad = scanner.nextInt();
        Cola<Object> cola = new Cola<>(capacidad);
        cola.menu();
    }
}