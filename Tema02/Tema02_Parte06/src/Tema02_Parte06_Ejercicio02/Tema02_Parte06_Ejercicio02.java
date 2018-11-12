package Tema02_Parte06_Ejercicio02;

import java.util.Scanner;

public class Tema02_Parte06_Ejercicio02 {

    private static int sumarCien(int v1){
        int total = 0;

        for(int f = 1; f <= 100; f++){
            total = v1 + total;
            v1 = v1 + 1;

        }

        return total;
    }

    public static void main(String[]args){
        Scanner teclado = new Scanner(System.in);

        int valor = 0;
        int ciensiguientes = 0;

        valor = teclado.nextInt();

        if(valor >= 0)
        ciensiguientes = sumarCien(valor);

        System.out.println(ciensiguientes);
    }
}
