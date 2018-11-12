package Tema02_Parte04_Ejercicio03;

import java.util.Scanner;

public class Tema02_Parte04_Ejercicio03 {

    public static void main(String[]args){
        Scanner teclado = new Scanner(System.in);

        String palabra = "";

        palabra = teclado.nextLine();


        for(int n = 0; n < palabra.length(); n++){
            for(int f = 1; f < palabra.length(); f++){
                System.out.print(palabra.charAt(f));
            }
            System.out.println();
        }


    }
}
