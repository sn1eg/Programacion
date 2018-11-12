package Tema02_Parte06_Ejercicio03;

import java.util.Scanner;

public class Tema02_Parte06_Ejercicio03 {

    public static void rango(int v1, int v2){
        int mayor = 0;
        int menor = 0;

        if(v1 > v2) {
            mayor = v1;
            menor = v2;
        }
        else{
            mayor = v2;
            menor = v1;
        }

        while(menor <= mayor){
            System.out.println(menor);
            menor = menor + 7;
        }

    }

    public static void main(String[]args){
        Scanner teclado = new Scanner(System.in);

        int valor1 = 0;
        int valor2 = 0;

        do{
            System.out.println("Introduce un valor");
            valor1 = teclado.nextInt();
            System.out.println("Introduce otro valor");
            valor2 = teclado.nextInt();
        }while(valor1 == valor2);

        rango(valor1,valor2);
    }

}
