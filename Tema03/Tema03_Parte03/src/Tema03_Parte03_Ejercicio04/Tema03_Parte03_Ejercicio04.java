package Tema03_Parte03_Ejercicio04;

import java.util.Scanner;
import java.util.Random;

public class Tema03_Parte03_Ejercicio04 {
    public static void main(String[]args){
        Scanner teclado = new Scanner(System.in);
        Random random = new Random();

        String paises[] = new String[5];
        int habitantes[] = new int[5];

        for(int f = 0; f < paises.length;f++){
            System.out.println("Nombre del pais nº "+ f+1 + ":");
            paises[f] = teclado.nextLine();
            habitantes[f] = random.nextInt(500)+1;

            System.out.println(habitantes[f]);
        }

        for(int k = 0; k < paises.length-1;k++){
            for(int f = 0; f < paises.length-1-k;f++){
                if(paises[f].compareTo(paises[f+1])>0){
                    String aux1 = "";
                    aux1 = paises[f];
                    paises[f] = paises[f+1];
                    paises[f+1] = aux1;

                    int aux2 = 0;
                    aux2 = habitantes[f];
                    habitantes[f] = habitantes[f+1];
                    habitantes[f+1] = aux2;
                }
            }
        }

        System.out.println();



        for(int k=0;k< paises.length;k++) {
            System.out.println(paises[k]);
            System.out.println(habitantes[k]);
            System.out.println();
                }
            }



}
