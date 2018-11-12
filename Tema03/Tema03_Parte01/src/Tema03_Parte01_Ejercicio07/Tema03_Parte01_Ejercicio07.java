package Tema03_Parte01_Ejercicio07;

import java.util.Scanner;
import java.util.Random;

public class Tema03_Parte01_Ejercicio07 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Random random = new Random();

        double vector[] = new double[25];
        double rangeMin = 1.2;
        double rangeMax = 6.9;
        double mayor = 0;
        double menor = 10;
        double total = 0;
        double media = 0;

        double numintroducido = 0;

        for (int f = 0; f < 25; f++) {
            double randomValue = rangeMin + (rangeMax - rangeMin) * random.nextDouble();
            vector[f] = randomValue;
            System.out.println(randomValue);

            if (vector[f] > mayor)
                mayor = vector[f];

            if (vector[f] < menor)
                menor = vector[f];

            total = total + vector[f];

        }

        media = total / 25;

        System.out.println("");
        System.out.println("");
        System.out.println("");

        System.out.println("Introduce un número para introducirlo en el vector:");
        numintroducido = teclado.nextDouble();

        for(int f = 0; f < 25; f++){
            if(vector[f] == numintroducido)
                System.out.println("El numero introducido se encuentra en la posición " + f);
            else
                System.out.println("El número introducido no se encuentra en el vector");
        }
    }

}
