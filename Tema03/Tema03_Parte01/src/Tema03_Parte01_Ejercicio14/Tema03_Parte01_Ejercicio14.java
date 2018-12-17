package Tema03_Parte01_Ejercicio14;

import java.util.Random;

public class Tema03_Parte01_Ejercicio14 {
    static Boolean botellas[] = new Boolean[100];
    static int count = 0;

    public static void iniciar(){
        for(int f = 0; f < 100; f++){
            botellas[f] = false;
            System.out.println(botellas[f]);
        }
    }

    static void aleatorio(){
        Random random = new Random();
        for(int f = 0; f < 50; f++){
            int aux = random.nextInt(100);

            if(!botellas[aux]){
                botellas[aux] = true;
                count++;
            }
        }
    }

    static void imprimir(){
        for(int f = 0; f < botellas.length;f++){
            System.out.println(botellas[f]);
        }
        System.out.println();
        System.out.println(count);
    }

    public static void main(String[]args){
        iniciar();
        aleatorio();
        imprimir();
    }
}
