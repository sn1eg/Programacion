package Tema02_Parte05_Ejercicio07;

import java.util.Scanner;

public class Tema02_Parte05_Ejercicio07 {
    public static void main(String[]args){
        Circulo circulo1 = new Circulo();
        Scanner teclado = new Scanner (System.in);

        System.out.println("Introduce el radio del circulo");
        ;circulo1.radio = teclado.nextDouble();

        System.out.println("El area del circulo es " + circulo1.area());
        System.out.println("La longitud del circulo es " + circulo1.longitud());
    }
}
