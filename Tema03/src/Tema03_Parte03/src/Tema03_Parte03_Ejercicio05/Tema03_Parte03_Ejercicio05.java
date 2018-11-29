package Tema03_Parte03_Ejercicio05;

import java.util.Scanner;

public class Tema03_Parte03_Ejercicio05 {

    static String palabra = "";
    static char letras[];

    public static void cargar(){
        Scanner teclado = new Scanner(System.in);
        palabra = teclado.nextLine();
        letras = new char[palabra.length()];

        for(int z = 0; z < palabra.length(); z++){
            letras[z] = palabra.charAt(z);
        }
    }

    public static void ordenar(){
        for(int f = 0; f < letras.length -1 ; f++ ) {
            for (int k = 0; k < letras.length - 1 - f; k++) {
                String aux1 = letras[k] + "";
                String aux2 = letras[k + 1] + "";
                if (aux1.compareTo(aux2) > 0) {
                    letras[k] = letras[k + 1];
                    letras[k + 1] = aux1.charAt(0);
                }
            }
        }
    }

    public static void imprimir(){
        for(int f = 0; f < letras.length; f++){
            System.out.println(letras[f]+",");
        }
    }

    public static void main(String[]args){
        cargar();
        ordenar();
        imprimir();
    }
}
