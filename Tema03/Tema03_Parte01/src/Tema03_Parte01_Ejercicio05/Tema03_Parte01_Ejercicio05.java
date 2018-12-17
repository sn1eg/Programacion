package Tema03_Parte01_Ejercicio05;

import java.util.Scanner;

public class Tema03_Parte01_Ejercicio05 {


    public static String vector[] = new String[5];


    public static Scanner teclado = new Scanner(System.in);

    public static void llenarvector(){
        for(int f = 0; f < 5; f++){
            System.out.println("");
            System.out.println("Ingresa un nombre:");
            vector[f] = teclado.nextLine();
        }

    }

    public static int consultarposicion(){
        System.out.println("Ingresa la palabra que quieres buscar:");
        String palabra = teclado.nextLine();
        int dev = -1;
        for(int f = 0; f < 5; f++){
            if(vector[f].equals(palabra))
                dev = f;
        }
        return dev;
    }

    public static void main(String[]args){
        llenarvector();
        int resultado = consultarposicion();

        if(resultado == -1)
            System.out.println("La palabra no se encuentra en el vector");

        else
            System.out.println("La palabra está en la posición " + resultado);

    }
}
