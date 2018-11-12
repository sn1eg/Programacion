package Tema02_Parte06_Ejercicio06;

import java.util.Scanner;

public class Tema02_Parte06_Ejercicio06 {

    public static void main(String[]args){
        Scanner teclado = new Scanner(System.in);

        int valor = 0;
        int total = 0;
        int count = 0;

        while(total <= 100){
            count++;
            valor = teclado.nextInt();
            total = total + valor;
        }

        System.out.println("Total acumulado: "+ total);
        System.out.println("Total de numeros: "+ count);
        System.out.println("Media: "+ (total/count));
    }
}
