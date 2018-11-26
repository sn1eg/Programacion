package ExamenSorpresa26_11_18;

import java.util.Random;

public class Ejercicio02_RobertoMuñozdeLeon_S11AW {

    static void rellenar(int matriz[][], int columna[]){
        Random aleatorio = new Random();

        for(int f = 0; f < matriz.length;f++){
            for(int c = 0; c < matriz[f].length; c++){
                matriz[f][c] = aleatorio.nextInt(4);
                columna[c] = aleatorio.nextInt(4);
            }
        }
    }

    static int comproColumna(int matriz[][], int columna[]){
        int count = 0;

        for(int f = 0; f < matriz.length; f++){
            count = 0;
            for(int c = 0; c < matriz[f].length;c++) {
                System.out.print(matriz[f][c]);
                if (matriz[f][c] == columna[c]) {
                    count++;
//                    System.out.println(count);
                    if(count == matriz[0].length){
                        return f;
                    }
                }
            }
            System.out.println();
        }

        System.out.println();
        for(int f = 0; f < columna.length; f++){
            System.out.print(columna[f]);
        }

        return -1;
    }

    public static void main(String[]args){
        Random aleatorio = new Random();

        int m = aleatorio.nextInt(4)+2;
        int n = aleatorio.nextInt(4)+2;

        int matriz [][] = new int[n][m];
        int columna [] = new int[m];


        rellenar(matriz, columna);

        matriz[1][0] = 0;
        matriz[1][1] = 1;
        columna[0]= 0;
        columna[1] = 1;

        int aux = comproColumna(matriz, columna);

        if(aux == -1){
            System.out.println("No hay ninguna coincidencia");
        }
        else{
            System.out.println("Se ha encontrado una coincidencia en la columna " +aux+"!");
        }
    }
}