package Tema03_Parte04_Ejercicio03;

import java.util.Scanner;

public class Tema03_Parte04_Ejercicio03 {

    static int matriz[][];
    static int aux[][];


    static Scanner teclado = new Scanner(System.in);

    public static void cargar(){
        for(int f = 0; f < matriz.length; f++){
            for(int c = 0; c < matriz[0].length; c++){
                matriz[f][c] = teclado.nextInt();
            }
        }
    }

    public static void llenaraux(){
        for(int f = 0; f < matriz.length; f++){
            for(int c = 0; c < matriz[0].length; c++){
                aux[f][c] = matriz[f][c];
            }
        }
    }

    public static void swap(){
        for(int f = 0; f < matriz.length; f++){
            matriz[0][f] = aux[1][f];
            matriz[1][f] = aux[0][f];
        }
    }

    public static void imprimir(){
        for(int f = 0; f < matriz.length; f++){
            for(int c = 0; c < matriz[0].length; c++){
                System.out.print(matriz[f][c] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[]args){

        int n = teclado.nextInt();
        int m = teclado.nextInt();

        matriz = new int[n][m];
        aux = new int[n][m];

        cargar();
        llenaraux();
        System.out.println("Matriz original:");
        imprimir();
        swap();
        System.out.println("Matriz cambiada:");
        imprimir();







    }
}
