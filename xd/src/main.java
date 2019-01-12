import java.util.Scanner;

public class main {

    public static void main(String[]args){
        int x = 0;

        Scanner teclado = new Scanner(System.in);
        do{
            System.out.println("Introduce un número por teclado:");
            x = teclado.nextInt();

            if( x == 25){
                System.out.println("\n :)\n");
            }
            System.out.println();
        }while(x != 0);
    }
}
