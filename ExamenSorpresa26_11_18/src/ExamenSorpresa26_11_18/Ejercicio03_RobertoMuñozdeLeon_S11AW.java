package ExamenSorpresa26_11_18;

import java.util.Random;

public class Ejercicio03_RobertoMuñozdeLeon_S11AW {

    static void rellenar(int matriz[][], int nprimo[][]){
        Random aleatorio = new Random();

        for(int f = 0; f < matriz.length;f++){
            for(int c = 0; c < matriz[f].length;c++){
                matriz[f][c] = aleatorio.nextInt(100)+1;
                nprimo[f][c] = 1;
            }
        }
    }

    static void comprobar(int matriz [][], int nprimo[][]){
        for(int f = 0; f < matriz.length;f++){
            for(int c = 0; c < matriz[f].length;c++){
                int count = 2;
                boolean primo=true;
                while ((primo) && (count!=matriz[f][c])){
                    if (matriz[f][c] % count == 0){
                        nprimo[f][c] = 0;
                        primo = false;
                    }
                    count++;
                }
            }
        }


    }

    static void imprimir(int matriz[][], int nprimo[][]){
        for(int f = 0; f < matriz.length;f++){
            for(int c = 0; c < matriz[f].length;c++){
                System.out.print(matriz[f][c]+" ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();
        System.out.println();

        for(int f = 0; f < matriz.length;f++){
            for(int c = 0; c < matriz[f].length;c++){
                System.out.print(nprimo[f][c]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[]args){
        int matriz[][] = new int[5][5];
        int nprimo[][] = new int[5][5];

        rellenar(matriz, nprimo);
        comprobar(matriz, nprimo);
        imprimir(matriz,nprimo);
    }

}
