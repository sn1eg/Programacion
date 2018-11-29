package Tema03_Parte01_Ejercicio01;

import java.util.Scanner;
import java.util.Random;

public class Juanlu {
    public static void main(String[]args){
        Scanner teclado = new Scanner(System.in);
        Random random = new Random();

        int valores [] = new int[8];
        int total = 0;
        int mayoresde50 = 0;

        for(int f = 0; f < 8; f++){
            valores[f] = random.nextInt(100)+1; //Esto sirve para que de un número aleatorio entre 1 y 100. Si no colocasemos el "+1" al final, nos daría un número entre 0 y 99.
            total = total + valores[f];
        }

        System.out.println("Los valores mayores de 36 son: ");
        for(int f = 0; f < 8; f++){
            if(valores[f] > 36)
                System.out.println(valores[f]);

            if(valores[f] > 50)
                mayoresde50++;
        }

        System.out.println("La cantidad de valores mayores de 50 son: " + mayoresde50);


    }



}

