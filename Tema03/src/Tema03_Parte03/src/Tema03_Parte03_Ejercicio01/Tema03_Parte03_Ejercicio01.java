package Tema03_Parte03_Ejercicio01;

import java.util.Scanner;
import java.util.Random;

public class Tema03_Parte03_Ejercicio01 {
    public static void main(String[]args){
        Scanner teclado = new Scanner(System.in);
        Random random = new Random();

        String nombre[] = new String[15];
        int edad[] = new int[15];

        for(int f = 0; f < nombre.length;f++){
            System.out.println("Nombre nº "+ f);
            nombre[f] = teclado.nextLine();
            edad[f] = random.nextInt(50)+1;
            System.out.println(edad[f]);
        }
    }
}
