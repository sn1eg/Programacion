package Tema03_Parte04_Ejercicio02;

public class Tema03_Parte04_Ejercicio02 {
    static int matriz[][] = new int[2][5];

    public static void main(String[]args){
        for(int f = 0; f < matriz[0].length; f++){
            for(int c = 0; c < matriz.length; c++){
                matriz[c][f] = 15;
            }
        }

        for(int f = 0; f < matriz[0].length; f++){
            for(int c = 0; c < matriz.length; c++){
                System.out.print(matriz[c][f]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
