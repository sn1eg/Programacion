package Tema03_Parte06.Tema03_Parte06_Ejercicios;

import java.util.ArrayList;

public class Tema03_Parte06_Ejercicios3 {

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
        int dir = 0;

        int devolver[] = new int[array.length-f+1];

        if(direccion.equals("nose")){
            dir = 0;
        }
        else if(direccion.equals("neso")){
            dir = 0;
        }

        ArrayList<Integer> aux = new ArrayList<>();

        return aux;
    }

    public static void main(String[]args){

        int miarray[][] = new int[6][6];

        for(int f = 0; f < miarray.length;f++){
            for(int c = 0; c < miarray[f].length;c++){
                miarray[f][c] = 2;
                System.out.print(miarray[f][c]);
            }
            System.out.println();
        }


        ArrayList<Integer> aux = new ArrayList<>();

        int g = 3;
        int v = 4;
        miarray[g-1][v-1] = 9;

        System.out.println();

        v--;
        for(int f = 0; g < miarray.length;g++){
            if(v > 0){
                v--;
            }
            else if (v==0){
                break;
            }
            miarray[g][v] = 9;
            aux.add(miarray[g][v]);
//            v--;
        }

//        for(int f = 0; g < miarray.length;g++){
//            miarray[g][v] = 9;
//            v++;
//        }



        for(int f = 0; f < miarray.length;f++){
            for(int c = 0; c < miarray[f].length;c++){
                System.out.print(miarray[f][c]);
            }
            System.out.println();
        }


        diagonal(3,2,"neso",miarray);

        for (int x : aux) {
            System.out.print(x+", ");
        }

//        System.out.println(miarray.length-g+1);
    }

}
