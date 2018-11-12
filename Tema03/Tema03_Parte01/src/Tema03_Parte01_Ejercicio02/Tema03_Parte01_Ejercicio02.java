package Tema03_Parte01_Ejercicio02;

import java.util.Scanner;
import java.util.Random;

public class Tema03_Parte01_Ejercicio02 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Random random = new Random();

        int notas[] = new int[30];
        String op1_1 = "";
        int consultanota = 0;
        int contadoralumnos = 0;

        for(int f = 0; f < 30; f++){
            notas[f] = random.nextInt(11);
            System.out.println(notas[f]);
        }

        System.out.println("Quieres ver cuantos alumnos han sacado una nota específica? (s/n)");
        op1_1 = teclado.nextLine();

        if(op1_1.equals("n")){
            System.exit(0);
        }

        System.out.println("Qué nota quieres consultar?");
        consultanota = teclado.nextInt();

        for(int f = 0; f < 30; f++){
            if(notas[f] == consultanota)
                contadoralumnos++;
        }

        System.out.println("La cantidad de alumnos que ha sacado un " + consultanota + " es de " + contadoralumnos);


    }
}
