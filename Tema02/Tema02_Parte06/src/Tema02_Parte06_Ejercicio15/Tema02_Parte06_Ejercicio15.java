package Tema02_Parte06_Ejercicio15;

import java.util.Random;
public class Tema02_Parte06_Ejercicio15 {
    public static void main(String[]args){
        Random random = new Random();

        int bola = 0;
        int total = 0;
        int diferencia = 0;
        boolean mastrece = false;

        while(total != 13){
            bola = random.nextInt(3)+1;

            switch (bola){
                case 1:
                    total = total + 1;
                    break;
                case 2:
                    total = total + 2;
                    break;
                case 3:
                    total = total + 3;
                    break;
            }

            if(total > 13){
                diferencia = total - 13;
                total = 13;
                mastrece = true;
            }

            System.out.println("La bola que ha salido es la que vale: " +bola); //Esto es por ver como evoluciona

        }

        System.out.println();
        if (mastrece){
            System.out.println("Se ha salido con el valor exacto, pero ha habido una diferencia de " + diferencia);
        }
        else{
            System.out.println("Se ha salido con el valor exacto!!!");
        }
    }
}

/*
                 /\.
                /|_\`.
               /__|_\/`.
              /__|__|\/.`.
             /_|__|__|\/`/`.
            /|__|___|__\/`/
           /__|___|___|_\/   Roberto :)
 */