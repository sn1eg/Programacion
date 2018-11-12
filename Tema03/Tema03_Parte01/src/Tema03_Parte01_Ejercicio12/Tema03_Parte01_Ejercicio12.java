package Tema03_Parte01_Ejercicio12;

import java.util.Scanner;

public class Tema03_Parte01_Ejercicio12 {
    static int examenes[] = new int[11];

    static void cargar(){
        Scanner teclado = new Scanner(System.in);
        int nota = 0;
        while(nota >= 0){
            nota = teclado.nextInt();
            if(nota >= 0 && nota <= 10){
                examenes[nota]++;
            }
        }
    }

    static void imprimir(){
        for(int f = 0; f < examenes.length; f++){
            System.out.println("Examenes con nota "+ f+": "+examenes[f]);
        }
    }

    public static void main(String[]ags){
        cargar();
        imprimir();
    }
}
