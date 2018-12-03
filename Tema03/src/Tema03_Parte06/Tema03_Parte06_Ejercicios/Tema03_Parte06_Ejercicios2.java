package Tema03_Parte06.Tema03_Parte06_Ejercicios;

import java.util.Random;

public class Tema03_Parte06_Ejercicios2 {

    public static void generaArrayInt(int maxintervalo, int minintervalo, int longitud, int array[]){
        Random random = new Random();
        array = new int[longitud];

        for(int aux : array){
            aux = random.nextInt(maxintervalo)+minintervalo;
        }
    }

    public static int minimoArrayInt(int array[]){
        int menor = 100000;
        for (int x: array) {
            if(x < menor){
                menor = x;
            }
        }
        return menor;
    }

    public static int maximoArrayInt(int array[]){
        int mayor = 0;
        for (int x: array) {
            if(x > mayor){
                mayor = x;
            }
        }
        return mayor;
    }

    public static int mediaArrayInt(int array[]){
        int total = 0;

        for(int x : array){
            total = total + x;
        }

        total = total/array.length;
        return total;
    }

    public static boolean estaEnArrayInt(int numeroabuscar, int array[]){
        boolean flag = false;

        for(int x : array){
            if(x == numeroabuscar){
                flag = true;
            }
        }

        return flag;
    }

    public static int posicionEnArrayInt(int numeroabuscar, int array[]){

        for(int x : array){
            if(x == numeroabuscar){
                return x;
            }
        }

        return -1;
    }

    public static void main(String[]args){

        int miarray[] = new int[15];

        estaEnArrayInt(7,miarray);
    }
}
