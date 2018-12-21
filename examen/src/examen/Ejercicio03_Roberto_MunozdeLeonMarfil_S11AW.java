package examen;

import java.util.Scanner;

public class Ejercicio03_Roberto_MunozdeLeonMarfil_S11AW {
    static String nombres[] = new String[]{"Ana", "Carlos", "Eduardo", "Felipe", "Isabel", "Juana", "Manuel", "1", "1", "1"};

    static void cargar(){
        Scanner teclado = new Scanner(System.in);

        for(int f = 9; f >= 0; f--){
            if(nombres[f].equals("1")){
                System.out.println("Introduce un nombre:");
                nombres[f] = teclado.nextLine();
            }
            ordenar();
        }

    }

    static void ordenar(){
        for(int k = 0; k < nombres.length-1; k++){
            for(int f = 0; f < nombres.length-1-k;f++){
                if(nombres[f].compareTo(nombres[f+1])>0){
                    String aux;
                    aux = nombres[f];
                    nombres[f] = nombres[f+1];
                    nombres[f+1] = aux;
                }
            }
        }
    }

    static void imprimir(){
        for(int f = 0; f < nombres.length; f++){
            System.out.println(nombres[f]);
        }
    }

    public static void main(String[]args){
        cargar();
        imprimir();
    }
}