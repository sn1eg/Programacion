package Tema02_Parte05_Ejercicio05;

import java.util.Scanner;

public class Tema02_Parte05_Ejercicio05 {

    public static void imprimir(String palabrilla){
        System.out.println(palabrilla.length());
    }

    public static int contar(String palabrilla){
        int contadorcillo = 0;
        if(palabrilla.length() == 4){
            contadorcillo++;
        }

        return contadorcillo;
    }


    public static void sustituir(){

    }

    public static void invertir(){

    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        String palabra = "";
        int count = 0;

        while(!palabra.equals("*")){
            imprimir(palabra);
            count = contar(palabra);
            sustituir();
            invertir();
            System.out.println("Introduce una palabra:");
            palabra = teclado.nextLine();
        }
        System.out.println(count);
    }
}
