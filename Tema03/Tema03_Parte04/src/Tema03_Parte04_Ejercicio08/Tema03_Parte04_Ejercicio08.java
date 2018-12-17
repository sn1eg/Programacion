package Tema03_Parte04_Ejercicio08;

import java.util.Scanner;

public class Tema03_Parte04_Ejercicio08 {
    public static void main(String[]args){
        Scanner teclado = new Scanner(System.in);
        int Array[][] = new int[6][];

        for(int z = 0; z < Array.length; z++){
            Array[z] = new int[z];
        }

        for(int f = 0; f < Array.length; f++){
            for(int c = 0; c < Array[f].length;c++){
                Array[f][c] = teclado.nextInt();
            }
        }

        for(int f = 0; f < Array.length; f++){
            for(int c = 0; c < Array[f].length;c++){
                System.out.print(Array[f][c]+"");
            }
            System.out.println();
        }
    }
}
