package Tema03_Parte01_Ejercicio06;

import java.util.Scanner;

public class Tema03_Parte01_Ejercicio06 {
    public static void main(String[]args){
        Scanner teclado = new Scanner(System.in);

        int vector [] = new int[30];

        System.out.println("Introduce el primer valor:");
        vector[0] = teclado.nextInt();

        for(int f = 1; f < 30; f++){
            vector[f] = vector[f-1] + 1;
            System.out.println(vector[f]);
        }

        System.out.println("");

        for(int f = 29; f >= 0; f--){
            System.out.println(vector[f]);
        }
    }
}
