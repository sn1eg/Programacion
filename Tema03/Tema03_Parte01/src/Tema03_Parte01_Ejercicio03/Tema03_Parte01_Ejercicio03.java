package Tema03_Parte01_Ejercicio03;

import java.util.Scanner;
import java.util.Random;

public class Tema03_Parte01_Ejercicio03 {
    public static void main(String[]args){
        Scanner teclado = new Scanner(System.in);
        Random pepe = new Random();

        int vector[] = new int[15];
        int carga = 0;
        int nummayor = 1;
        int cantnummayor = 0;
        int nummenor = 500;
        int cantnummenor = 0;

        for(int f = 0; f < 15; f++){
            carga = pepe.nextInt(500)+1;
            vector[f] = carga;

            if(vector[f] > nummayor)
                nummayor = vector[f];

            if(vector[f] < nummenor)
                nummenor = vector[f];
        }

        for(int f = 0; f < 15; f++){
        if(vector[f] == nummayor)
            cantnummayor++;
        else if(vector[f] == nummenor)
            cantnummenor++;
        }

        System.out.println("El número mayor es: " +nummayor);
        System.out.println("El número menor es: " +nummenor);


        System.out.println("El número mayor ha salido " +cantnummayor+" veces");
        System.out.println("El número menor ha salido " +cantnummenor+" veces");

    }
}
