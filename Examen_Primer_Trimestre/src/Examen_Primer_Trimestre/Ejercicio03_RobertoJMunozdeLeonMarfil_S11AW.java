package Examen_Primer_Trimestre;

import java.util.Random;

public class Ejercicio03_RobertoJMunozdeLeonMarfil_S11AW {
    // Ejercicio 3

    // La unica parte salvable de este es lo del número primo, no me ha dado tiempo y me he empezado a liar

    static void llenarArray(int array[], int tablero[][]){
        Random aleatorio = new Random();

        for(int f = 0; f < array.length; f++){
            array[f] = aleatorio.nextInt(10)+1;
        }

//        for(int c = 0; c < tablero[0].length; c++){
//            tablero[0][c] = c;
//        }
//
//        for(int c = 0; c < tablero[1].length; c++){
//            tablero[1][c] = array[c];
//        }


    }

//    static void imprimirArray(int tablero[][]){
//
//        System.out.print("Indice ");
//        for(int c = 0; c < tablero[0].length; c++){
//            System.out.print(tablero[0][c]+" ");
//        }
//
//        System.out.println();
//        System.out.print("Valor  ");
//        for(int c = 0; c < tablero[1].length; c++){
//            System.out.print(tablero[1][c]+" ");
//        }
//
//
//    }

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
        int miarray[] = new int[10];
        int tabla[][] = new int[2][10];
        int arrayaux[] = new int[10];

        llenarArray(miarray,tabla);
//        imprimirArray(tabla);



        int aux2 = 0;
        for(int j = 0; j < miarray.length; j++){
            if(comprobarPrimo(miarray[j])){
                aux2 = miarray[j];
                miarray[j] = 50;
            }
        }

        //LLenar la array auxiliar
        for(int f = 0; f < miarray.length; f++){
            arrayaux[f] = miarray[f];
        }


        //Ordenar la array
        for(int j = 0; j < miarray.length; j++) {
            if (comprobarPrimo(miarray[j])) {
                aux2 = miarray[j];
                miarray[j] = 50;
            }
            for (int k = 0; k < tabla.length - 1; k++) {
                for (int f = 0; f < miarray.length - 1 - k; f++) {
                    if (miarray[f] > miarray[f + 1]) {
                        miarray[f] = aux2;
                        int aux;
                        aux = miarray[f];
                        miarray[f] = miarray[f + 1];
                        miarray[f + 1] = aux;
                    }
                }
            }
        }

        for(int f = 0; f < miarray.length; f++){
            System.out.println(miarray[f]);
        }

        System.out.println();
        System.out.println();
//        imprimirArray(tabla);
    }

}
