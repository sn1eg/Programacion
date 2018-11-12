package Tema02_Parte05_Ejercicio02;

import java.util.Scanner;

public class Asteriscos {

    private static void asterisco(int n){
        for(int f = 1;f<=n;f++){
            System.out.print("*");
        }
    }

    public static void main(String[]args){
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce la cantidad de asteriscos a imprimir:");
        int cantidad = teclado.nextInt();

        asterisco(cantidad);
    }
}
