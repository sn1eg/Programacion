package Tema03_Parte04_Ejercicio01;

public class Tema03_Parte04_Ejercicio01 {
    public static void main(String[]args){
        String matriz[][] = new String[4][4];

        for(int f = 0; f < matriz.length; f++){
            for(int c = 0; c < matriz.length; c++){
                matriz[f][c] = "-";
//                System.out.print(matriz[f][c]);
            }
//            System.out.println();
        }

        for(int f = 0; f < matriz.length; f++){
            matriz[f][f] = "X";
        }

        for(int f = 0; f < matriz.length; f++){
            for(int c = 0; c < matriz.length; c++){
                System.out.print(matriz[f][c]);
            }
            System.out.println();
        }
    }
}
