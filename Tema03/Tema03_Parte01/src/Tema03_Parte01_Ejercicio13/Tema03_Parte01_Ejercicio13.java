package Tema03_Parte01_Ejercicio13;

import java.util.Random;
import java.util.Scanner;

public class Tema03_Parte01_Ejercicio13 {
    static String valores[] = new String[100];

    static void cargar(){
        Random random = new Random();
        for(int f = 0; f < valores.length;f++){
            valores[f] = "" + random.nextInt(21);
        }
    }

    static void imprimir(){
        for(int f = 0; f < valores.length;f++){
            System.out.print(valores[f] + " ");
        }
    }

    static void cambiar(String num, String num2){
        for(int f = 0; f < valores.length; f++){
            if(valores[f].equals(num)){
                valores[f] = "'" +num2+"'";
            }
        }
    }
    public static void main(String[]args){
        Scanner teclado = new Scanner(System.in);
        String num = "";
        String num2 = "";

        cargar();
        imprimir();
        System.out.println();
        num = teclado.nextLine();
        num2 = teclado.nextLine();
        cambiar(num, num2);
        imprimir();
    }
}
