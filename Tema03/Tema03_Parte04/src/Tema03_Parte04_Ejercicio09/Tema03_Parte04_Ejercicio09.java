package Tema03_Parte04_Ejercicio09;

import java.util.Random;

public class Tema03_Parte04_Ejercicio09 {
    public static void main(String[]args){
        Random random = new Random();

        String empleados[] = new String[3];
        empleados[0] = "Manolo";
        empleados[1] = "Paco";
        empleados[2] = "Pepe";
//        int menor = 3;

        int dias[][] = new int[3][];

        for(int f = 0; f< dias.length;f++){
            dias[f] = new int[random.nextInt(31)+1];
        }

        for(int f = 0; f < dias.length; f++){
            System.out.println(empleados[f]+" falto " + dias[f].length + " dias");
        }

    //        for(int f = 0; f < dias.length; f++){
    //            if(dias[f].length < menor){
    //                menor = f;
    //            }
    //        }
    //
    //        System.out.println("El que menos ha faltado es "+empleados[menor]+" habiendo faltado "+dias[menor].length);
    }
}
