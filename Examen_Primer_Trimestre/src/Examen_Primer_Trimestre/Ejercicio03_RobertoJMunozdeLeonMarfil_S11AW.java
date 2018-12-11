package Examen_Primer_Trimestre;

public class Ejercicio03_RobertoJMunozdeLeonMarfil_S11AW {
    // Ejercicio 3

    static boolean comprobarPrimo(int numero){

        int count = 2;
        boolean primo=true;
        while ((primo) && (count!=numero)){
            if (numero % count == 0){
                primo = false;
            }
            count++;
        }

        return primo;
    }

    public static void main(String[]args){
        System.out.println(comprobarPrimo(7));
    }

}
