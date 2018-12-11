package Examen_Primer_Trimestre;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio02_RobertoJMunozdeLeonMarfil_S11AW {
    //Ejercicio 2

    static int tabla [][] = new int[6][3];
    static String pilotos [] = new String[6];

    static void cargarNombres(){
        Scanner teclado = new Scanner(System.in);

        //Entrada de texto por teclado con control de que unicamente sean caracteres alfabeticos
        for(int f = 0; f < pilotos.length; f++){
            System.out.println("Introduce el nombre del piloto nº "+f+":");
            while (!teclado.hasNext("[A-Za-z]+")) {
                System.out.println("¡¡Solo se admiten letras mayúsculas y minúsculas!!");
                teclado.next();
            }
            pilotos[f] = teclado.next();
        }

    }

    static void cargarTabla(){

        System.out.println("//Control para ver quienes han sido los ganadores de cada una de las carreras");
        for(int f = 0; f < tabla.length; f++){
            for(int c = 0; c < tabla[f].length; c++){
                tabla[f][c] = 0;
            }
        }


        Random aleatorio = new Random();

        int carrera = 0;
        while(carrera != 3){
            int numero1 = aleatorio.nextInt(6);
            int numero2 = aleatorio.nextInt(6);
            int numero3 = aleatorio.nextInt(6);

            while(numero2 == numero1){
                numero2 = aleatorio.nextInt(6);
            }
            while(numero3 == numero1 || numero3 == numero2){
                numero3 = aleatorio.nextInt(6);
            }

            carrera++;
            System.out.println("Carrera nº"+carrera+" "+numero1);
            System.out.println("Carrera nº"+carrera+" "+numero2);
            System.out.println("Carrera nº"+carrera+" "+numero3);
            System.out.println();
            carrera--;



            tabla[numero1][carrera] = 10;
            tabla[numero2][carrera] = 8;
            tabla[numero3][carrera] = 6;



            carrera++;
        }

    }

    static void imprimirTabla(){

        System.out.println("//Tabla para controlar la puntuacion de cada piloto en cada carrera");
        for(int f = 0; f < tabla.length; f++){
            System.out.print("Corredor "+f+"  ");
            for(int c = 0; c < tabla[f].length; c++){
                System.out.print("["+tabla[f][c]+"]");
            }
            System.out.println();
        }

    }

    static void puntuaciones(){

        int total = 0;

        int puntuaciones[] = new int[6];

        System.out.println();
        System.out.println("//Control de los totales de cada piloto:");
        for(int f = 0; f < tabla.length; f++){
            total = 0;

            for(int c = 0; c < tabla[f].length; c++){
                total = total + tabla[f][c];
            }

            puntuaciones[f] = total;

            System.out.println(f+"   "+total);

        }

        System.out.println();
        System.out.println();

        //Esto lo puse para poder probar el programa rapidamente
//        pilotos[0] = "Marcos";
//        pilotos[1] = "Peter";
//        pilotos[2] = "Roberto";
//        pilotos[3] = "Adela";
//        pilotos[4] = "Pepe";
//        pilotos[5] = "Pipo";


        //Ordenamos el vector de puntuaciones y reordenamos el de pilotos para que no pierda coherencia
        for(int k=0;k<puntuaciones.length-1;k++) {
            for(int f=0;f< puntuaciones.length-1-k;f++) {
                if (puntuaciones[f]>puntuaciones[f+1]) {
                    int aux;
                    String auxnom;
                    aux=puntuaciones[f];
                    puntuaciones[f]=puntuaciones[f+1];
                    puntuaciones[f+1]=aux;

                    auxnom=pilotos[f];
                    pilotos[f]=pilotos[f+1];
                    pilotos[f+1]=auxnom;
                }
            }
        }

        System.out.println("//Control de cuantos puntos tiene cada piloto CON NOMBRE y ORDENADO");
        for(int f = 0; f < puntuaciones.length; f++){
            System.out.println(pilotos[f]+" tiene estos puntos "+puntuaciones[f]);
        }


        for(int z = 0; z < 5; z++){
            System.out.println();
        }

        System.out.println("Los ganadores de está competición son...");
        System.out.println("El ganador del primer puesto ha sido "+pilotos[5]+" con "+puntuaciones[5]+" puntos!");
        System.out.println("El ganador del segundo puesto ha sido "+pilotos[4]+" con "+puntuaciones[4]+" puntos!");
        System.out.println("El ganador del tercer puesto ha sido "+pilotos[3]+" con "+puntuaciones[3]+" puntos!");

        System.out.println();

        int count = 0;
        for(int f = 0; f < puntuaciones.length;f++){
            if(puntuaciones[f] == 0){
                System.out.println("El piloto "+pilotos[f]+" ha sacado 0 puntos!!");
                count++;
            }
        }
        if(count == 0){
            System.out.println("No hay pilotos con 0 puntos!!");
        }

    }



    public static void main(String[]args){
        cargarNombres();
        cargarTabla();
        imprimirTabla();
        puntuaciones();
    }
}
