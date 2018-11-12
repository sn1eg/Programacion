package Tema02_Parte07_Ejercicio07;

import java.util.Scanner;

public class Tema02_Parte07_Ejercicio07 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);


        int n = 0;
        n = teclado.nextInt();

        for (int linea = 1; linea <= n; linea++) {
            for (int espacio = 1; espacio <= n - linea; espacio++) {
                System.out.print(" ");
            }
            for (int num = 1; num <= linea; num++) {
                System.out.print(num);
            }
            for (int num2 = linea - 1; num2 >= 1; num2--) {
                System.out.print(num2);
            }
        }
    }
}


