package Tema03_Parte01_Ejercicio10;

import java.util.Random;
//Ni idea de si este está bien o no xdd
public class Tema03_Parte01_Ejercicio10 {
    static int vector[] = new int[50];
    static double vector2[] = new double[50];
    static int total = 0;
    static void cargar(){
        Random random = new Random();
        for(int f = 0; f < vector.length;f++){
            vector[f] = random.nextInt(500)+301;
            System.out.println(vector[f]);
        }
    }

    static void calcular(){
        for(int f = 0; f < vector.length;f++){
            total = total + vector[f];
        }

        double media = total / vector.length;
        System.out.println("+++++++"+media);

        for(int f = 0; f < vector2.length;f++){
            vector2[f] = vector[f];
            System.out.println("-"+vector2[f]);
            vector2[f] = vector[f] / media;
            System.out.println("+"+vector2[f]);
        }
    }

    static void imprimir(){
        System.out.println();
        for(int f = 0; f < vector2.length;f++){
            System.out.println(vector2[f]);
        }
    }
    public static void main(String[]args){
        cargar();
        calcular();
        imprimir();
    }
}
