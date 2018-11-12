package Tema02_Parte05_Ejercicio01;

import java.util.Scanner;

public class Operaciones {

    private static void sumar(int v1, int v2){
        int resultado = v1 + v2;
        System.out.println(resultado);
    }

    private static void restar(int v1, int v2){
        int resultado = v1 - v2;
        System.out.println(resultado);
    }

    private static void multiplicar(int v1, int v2){
        int resultado = v1 * v2;
        System.out.println(resultado);
    }

    private static void dividir(int v1, int v2){
        int resultado = v1 / v2;
        System.out.println(resultado);
    }

    public static void main(String[]args){
        Scanner teclado = new Scanner(System.in);

        int op1 = 0;

        do {
            System.out.println("Introduce un valor");
            int valorA = teclado.nextInt();
            System.out.println("Introduce otro valor valor");
            int valorB = teclado.nextInt();

            System.out.println("Selecciona una opción:");
            System.out.println("1.- Sumar");
            System.out.println("2.- Restar");
            System.out.println("3.- Multiplicar");
            System.out.println("4.- Dividir");
            System.out.println("0.- Salir");

            op1 = teclado.nextInt();

            switch (op1) {
                case 1:
                    sumar(valorA, valorB);
                    break;
                case 2:
                    restar(valorA, valorB);
                    break;
                case 3:
                    multiplicar(valorA, valorB);
                    break;
                case 4:
                    dividir(valorA, valorB);
                    break;
            }

        }while(op1!=0);
    }

}
