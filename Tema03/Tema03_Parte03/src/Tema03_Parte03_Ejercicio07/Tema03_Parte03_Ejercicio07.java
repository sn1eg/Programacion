package Tema03_Parte03_Ejercicio07;

import java.util.Random;

public class Tema03_Parte03_Ejercicio07 {
    static int array[] = new int[40];
    static int arraypar[] = new int[40];
    static int arrayimpar[] = new int[40];
    static int count;
    static int countb;

    static void imprimir(){
        for(int f = 0; f < array.length;f++){
            System.out.println(array[f]);
        }

        System.out.println();

        for(int f = 0; f < arraypar.length;f++){
            System.out.println(arraypar[f]);
        }

        System.out.println();

        for(int f = 0; f < arraypar.length;f++){
            System.out.println(arrayimpar[f]);
        }
    }

    static void cargar(){
        Random random = new Random();

        for(int f = 0; f < array.length; f++){
            array[f] = random.nextInt(101);
        }
        imprimir();
    }

    static void limpiar(){
        for(int f = 0; f < array.length;f++){
            array[f] = 0;
        }
    }

    static void ordenar(){
        count = 0;
        countb = 0;
        for(int f = 0; f < array.length; f++){
            if(array[f] % 2 == 0){
                arraypar[count] = array[f];
                count++;
            }
            else{
                arrayimpar[countb] = array[f];
                countb++;
            }
        }

        limpiar();

        for(int f = 0; f <= count;f++){
            array[f] = arraypar[f];
        }

        for(int f = count; f <= array.length-count+1;f++){
            array[f] = arrayimpar[f];
        }

        imprimir();
    }

    public static void main(String[]args){
        cargar();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        ordenar();
        System.out.println();
        System.out.println();
        System.out.println(count);
    }
}
