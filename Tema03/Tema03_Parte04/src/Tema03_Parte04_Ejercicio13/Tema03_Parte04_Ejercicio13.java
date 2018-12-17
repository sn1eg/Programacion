package Tema03_Parte04_Ejercicio13;

import java.util.ArrayList;

public class Tema03_Parte04_Ejercicio13 {

    static boolean compruebaSudoku(ArrayList lista){

        return false;
    }

    static boolean compruebaArray(int array[][]){
        int aciertos= 0;

        int numeros[] = new int[9];

        for(int f = 0; f < array.length; f++){
            for(int c = 0; c < array[f].length; c++){
                for(int g = 1; g < numeros.length+1; g++){
                    if(array[f][c] == g){
                        numeros[g-1] = 10;
                    }
                }
            }
        }

        for(int x : numeros){
            if(x == 10){
                aciertos = aciertos + x;
            }
        }

        if(aciertos == 90){
            return true;
        }
        else{
            return false;
        }
    }


    public static void main(String[]args){

        int a1[][] = new int[3][3];
        int a2[][] = new int[3][3];
        int a3[][] = new int[3][3];

        int b1[][] = new int[3][3];
        int b2[][] = new int[3][3];
        int b3[][] = new int[3][3];

        int c1[][] = new int[3][3];
        int c2[][] = new int[3][3];
        int c3[][] = new int[3][3];


        a1[0][0] = 1;
        a1[0][1] = 2;
        a1[0][2] = 4;
        a1[1][0] = 3;
        a1[1][1] = 5;
        a1[1][2] = 7;
        a1[2][0] = 6;
        a1[2][1] = 8;
        a1[2][2] = 9;

        ArrayList lista = new ArrayList();

        lista.add(a1);
        lista.add(a2);
        lista.add(a3);

        lista.add(b1);
        lista.add(b2);
        lista.add(b3);

        lista.add(c1);
        lista.add(c2);
        lista.add(c3);

        int count = 0;
        for(int x = 0; x < 9; x++){
            System.out.println(compruebaArray((int[][]) lista.get(x)));
            if(compruebaArray((int[][]) lista.get(x))){
                count++;
            }
        }

        if(count == 9){
            compruebaSudoku(lista);
        }
    }
}