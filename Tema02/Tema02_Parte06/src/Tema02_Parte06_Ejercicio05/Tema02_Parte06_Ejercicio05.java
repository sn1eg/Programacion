package Tema02_Parte06_Ejercicio05;

public class Tema02_Parte06_Ejercicio05 {

    public static void main(String[] args) {
        int valor = 2;
        int divisor = 2;
        int resultado = 70;

        for(valor = 22; valor <= 100; valor++) {
            if(valor % 2 != 0 || valor == 2) {
                for (divisor = 2; divisor < valor; divisor++) {
                    if (valor / divisor < divisor)
                        System.out.println("valor " + valor);
                    System.out.println("divisor " + divisor);
                    System.out.println("Es primo");
                    System.out.println("reusltado" + (valor / divisor));

                }
            }
            else
                System.out.println("No es Primo");
        }


    }
}
