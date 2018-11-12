package Tema02_Parte06_Ejercicio04;

import java.util.Scanner;

public class Tema02_Parte06_Ejercicio04 {

    public static void main(String[]args){
        Scanner teclado = new Scanner(System.in);

        int valor = 0;
        int impares = 0;
        int pares = 0;
        int count = 0;
        int count2 = 0;

        while(valor > -1){
            count = count + 1;
            if(valor % 2 == 1){
                impares = impares + valor;
                count2++;
            }
            else{
                if(valor > pares)
                    pares = valor;
            }


            valor = teclado.nextInt();
        }

        impares = impares / count2;

        System.out.println(impares);
        System.out.println(pares);
        System.out.println(count - 1);
    }
}
