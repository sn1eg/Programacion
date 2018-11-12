package Tema02_Parte05_Ejercicio03;

import java.util.Scanner;

public class Empleados {

    public static void entrada(){
        Scanner teclado = new Scanner(System.in);
        int antiguedad = 0;
        System.out.println("Introduce la antiguedad del empleado en años:");
        antiguedad = teclado.nextInt();

        int aux = calculo(antiguedad);
        salida(aux);

    }

    private static int calculo(int valor1){
        valor1 = valor1 / 3;
        return valor1;
    }

    private static void salida(int valor1){
        System.out.println("El empleado tiene " + valor1 +" trienios de antigüedad.");
    }
}
