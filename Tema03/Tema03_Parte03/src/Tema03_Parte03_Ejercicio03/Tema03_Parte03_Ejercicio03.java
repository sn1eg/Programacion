package Tema03_Parte03_Ejercicio03;

import java.util.Random;

public class Tema03_Parte03_Ejercicio03 {
    public static void main(String[]args){
        Random random = new Random();

        int a[] = new int[5];
        int b[] = new int[5];
        int totala = 0;
        int totalb = 0;

        for(int f = 0; f < a.length;f++){
            a[f] = random.nextInt(10)+1;
            b[f] = random.nextInt(10)+1;

            totala = totala + a[f];
            totalb = totalb + b[f];
        }
        totala = totala / a.length;
        totalb = totalb / b.length;

        if(totala > totalb){
            System.out.print("El curso A tiene una mayor nota media");
        }
        else{
            System.out.print("El curso B tiene una mayor nota media");
        }
    }
}
