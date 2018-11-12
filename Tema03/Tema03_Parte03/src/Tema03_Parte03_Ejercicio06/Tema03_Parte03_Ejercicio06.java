package Tema03_Parte03_Ejercicio06;

import java.util.Random;

public class Tema03_Parte03_Ejercicio06 {
    static int array[] = new int[15];

    static void imprimir(){
        for(int f = 0; f < array.length;f++){
            System.out.println(array[f]);
        }
    }

    static void cargar(){
        Random random = new Random();

        for(int f = 0; f < array.length;f++){
            array[f] = random.nextInt(11);
        }
        imprimir();
    }

    static void rotar(){
        int aux = 0;
        for(int f = 0; f < array.length-1;f++){
            aux = array[f];
            array[f] = array[f+1];
            array[f+1] = aux;
        }
        imprimir();
    }
    public static void main(String[]args){
        cargar();
        System.out.println();
        rotar();
    }
}
