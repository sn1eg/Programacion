package Tema03_Parte04_Ejercicio12;

import java.util.Random;
import java.util.Scanner;

public class Tema03_Parte04_Ejercicio12 {

    static int tablero [][] = new int[8][8];

    public static void carga(){
        Random random = new Random();

        for(int f = 0; f < tablero.length; f++){
            for(int c = 0; c < tablero[f].length; c++){
                tablero[f][c] = random.nextInt(5);
            }
        }
    }

    public static void main(String[]args){
        Scanner teclado = new Scanner(System.in);

        int count = 0;
        int fila = 0;
        int columna = 0;

        carga();
        do{
            count = 0;

            System.out.println("Introduce la fila y seguidamente introduce la columna a bombardear:");
            fila = teclado.nextInt();
            columna = teclado.nextInt();
            tablero[fila-1][columna-1] = tablero[fila-1][columna-1]+100;

            for(int f = 0; f < tablero.length; f++){
                for(int c = 0; c < tablero[f].length; c++){
                    System.out.print(tablero[f][c]+" ");
                    if(tablero[f][c] != 1){
                        count++;
                    }
                }
                System.out.println();
            }
            System.out.println(count);
            System.out.println();


        }while (count != 64);
    }
}
