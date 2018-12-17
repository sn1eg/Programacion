package Tema03_Parte01_Ejercicio04;

import java.util.Random;

public class Tema03_Parte01_Ejercicio04 {
    public static void main(String[]args){
        Random random = new Random();

        int vector [] = new int[10];
        int suma = 0;
        int producto = 1;

        for(int f = 0;f < 10;f++){
            vector[f] = random.nextInt(20)+1;
            System.out.println(vector[f]);

            if(f % 2 == 0)
                suma = suma + vector[f];
            else
                producto = producto * vector[f];
        }

        System.out.println("Producto de los impares: "+producto);
        System.out.println("Suma de los pares: "+suma);

    }
}
