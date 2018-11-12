package Tema02_Parte06_Ejercicio14;

import java.util.Scanner;
import java.util.Random;

public class Tema02_Parte06_Ejercicio14 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Random random = new Random();

        int vectotales = 0;
        int vehiculosenal = 0;
        int bicicleta = 0;
        int moto = 0;
        int coche = 0;
        int camion = 0;
        int error = 0;
        int erroracum = 0;
        int cocheinter = 0;
        int maxinter = 0;
        int masveces = 0;

        System.out.println("Introduce cuantos vehículos han pasado por el radar:");
        vectotales = teclado.nextInt();

        for (int f = 1; f <= vectotales; f++) {
            vehiculosenal = random.nextInt(5) + 1;
            System.out.println(vehiculosenal);

            if (!(erroracum >= 3)) {
                switch (vehiculosenal) {
                    case 0:
                        bicicleta++;
                        erroracum = 0;
                        cocheinter++;
                        break;
                    case 1:
                        moto++;
                        erroracum = 0;
                        cocheinter++;
                        break;
                    case 2:
                        coche++;
                        cocheinter = 0;
                        erroracum = 0;
                        if (coche == 1) { //Este if sirve para que empiece a contar el intervalo DESDE EL PRIMER COCHE :)
                            cocheinter = 0;
                            maxinter = 0;
                        }
                        break;
                    case 3:
                        camion++;
                        cocheinter++;
                        erroracum = 0;
                        break;
                    case 4:
                        error++;
                        erroracum++;
                        cocheinter++;
                        break;
                    case 5:
                        error++;
                        erroracum++;
                        cocheinter++;
                        break;
                }

                if (maxinter < cocheinter) {
                    maxinter = cocheinter;
                }


                // Esto más que nada es para ir viendo como evoluciona cada variable
                System.out.println("COCHEINTER " + cocheinter);
                System.out.println("MAXINTER " + maxinter);
                System.out.println("ERRORACUM " + erroracum);
                System.out.println();


            }

        }


        System.out.println("El vehículo que más veces ha pasado es:");
        if (bicicleta > moto && bicicleta > coche && bicicleta > camion && bicicleta > error) {
            System.out.println("Bicicleta");
        } else if (moto > bicicleta && moto > coche && moto > camion && moto > error) {
            System.out.println("Motocicleta");
        } else if (coche > bicicleta && coche > moto && coche > camion && coche > error) {
            System.out.println("Coche");
        } else if (camion > bicicleta && camion > moto && camion > coche && camion > error) {
            System.out.println("Camion");
        } else {
            System.out.println("Error");
        }

        System.out.println();

        if (coche == 1 || coche == 0) {
            System.out.println("No han pasado suficientes coches para que exista un intervalo entre ellos");
        } else {
            System.out.println("El mayor intervalo entre coches ha sido:");
            System.out.println(maxinter);
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