package Tema03_Parte01_Ejercicio01;

import java.util.Scanner;

public class Tema03_Parte01_Ejercicio01 {
    public static void main(String[]args){
        Scanner teclado = new Scanner(System.in);

        int valores [] = new int[3];
        int total = 0;
        int mayoresde50 = 0;

        for(int f = 0; f < 3; f++){
            System.out.println("Ingresa un número: ");
            valores[f] = teclado.nextInt();
            total = total + valores[f];
        }

        System.out.println("Los valores mayores de 36 son: ");
        for(int f = 0; f < 3; f++){
           if(valores[f] > 36)
               System.out.println(valores[f]);

           if(valores[f] > 50)
               mayoresde50++;
        }

        System.out.println("La cantidad de valores mayores de 50 son: " + mayoresde50);


        }



    }

