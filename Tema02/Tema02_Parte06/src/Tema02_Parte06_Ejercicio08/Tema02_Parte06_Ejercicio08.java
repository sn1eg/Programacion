package Tema02_Parte06_Ejercicio08;

import java.util.Scanner;

public class Tema02_Parte06_Ejercicio08 {

    public static void main(String[]args){
        Scanner teclado = new Scanner(System.in);

        String valor = "";

        valor = teclado.nextLine();

        int longitud = valor.length();

        System.out.println(longitud);
    }
}
