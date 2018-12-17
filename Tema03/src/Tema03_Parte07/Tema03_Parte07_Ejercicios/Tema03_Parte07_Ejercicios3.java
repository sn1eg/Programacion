package Tema03_Parte07.Tema03_Parte07_Ejercicios;

import java.util.ArrayList;
import java.util.Random;

public class Tema03_Parte07_Ejercicios3 {

    public static int[][] generaArrayBiInt(int n, int m, int array[][]){
        array = new int[n][m];
        return array;
    }

    public static int[] filaDeArrayBiInt(int n, int array[][]){
        int aux[] = array[n];

        return aux;
    }

    public static int[] columnaDeArrayBiInt(int n, int array[][]){
        int aux[] = new int[array[0].length];

        for(int f = 0; f < array[0].length;f++){
            aux[f] = array[f][n];
        }

        return aux;
    }

    public static int[] coordenadasEnArrayBiInt(int numero, int array[][]){

        int coordenadas[] = new int[2];

        for(int f = 0; f < array.length;f++){
            for(int c = 0; c < array[f].length;c++){
                if(array[f][c] == numero){
                    coordenadas[0] = f;
                    coordenadas[1] = c;
                    return coordenadas;
                }
            }
        }
        coordenadas[0] = -1;
        coordenadas[1] = -1;
        return coordenadas;
    }

    public static ArrayList<Integer> diagonal(int f, int c, String direccion, int[][] array){
        ArrayList<Integer> aux = new ArrayList<>();

        int devolver[] = new int[array.length-f+1];

        if(direccion.equals("nose")){
            c--;
            while(f < array.length){
                if(c > 0){
                    c--;
                }
                else if (c==0){
                    break;
                }
                aux.add(array[f][c]);
                f++;
            }
        }
        else if(direccion.equals("neso")){
            while(f < array.length){
                aux.add(array[f][c]);
                if(c > array[f].length){
                    c++;
                }
                f++;
            }
        }


        return aux;
    }

    public static void main(String[]args){
        Random random = new Random();

        int miarray[][] = new int[6][6];

        for(int f = 0; f < miarray.length;f++){
            for(int c = 0; c < miarray[f].length;c++){
                miarray[f][c] = random.nextInt(10);
                System.out.print(miarray[f][c]+" ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println(diagonal(2,3,"neso",miarray));

        //casi terminado

    }

}
