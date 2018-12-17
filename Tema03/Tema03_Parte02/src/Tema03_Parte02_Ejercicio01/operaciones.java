package Tema03_Parte02_Ejercicio01;

import java.util.Scanner;

public class operaciones {
    static int valor1 = 0;
    static int valor2 = 0;
    static int resultado = 0;
    static Scanner teclado = new Scanner(System.in);

    public static void cargarvalores(){
        System.out.println("Introduce dos valores:");
        valor1 = teclado.nextInt();
        valor2 = teclado.nextInt();
    }

    public static void suma(){
        resultado = valor1 + valor2;
        System.out.println(resultado);
    }

    public static void resta(){
        resultado = valor1 - valor2;
        System.out.println(resultado);
    }

    public static void multiplicacion(){
        resultado = valor1 * valor2;
        System.out.println(resultado);
    }

    public static void division(){
        resultado = valor1 / valor2;
        System.out.println(resultado);
    }

    public static void main(String[]args){
        cargarvalores();

        int op1 = 0;
        System.out.println("Introduce la opción deseada:");
        System.out.println("1.- Sumar");
        System.out.println("2.- Restar");
        System.out.println("3 - Multiplicar");
        System.out.println("4 - Dividir");
        System.out.println("0 - Salir");

        op1 = teclado.nextInt();

        switch (op1){
            case 1:
                suma();
                break;
            case 2:
                resta();
                break;
            case 3:
                multiplicacion();
                break;
            case 4:
                division();
                break;
            case 0:
                System.exit(0);
                break;
        }
    }
}
