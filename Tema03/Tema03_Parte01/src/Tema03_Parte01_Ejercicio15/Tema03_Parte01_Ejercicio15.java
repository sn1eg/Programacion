package Tema03_Parte01_Ejercicio15;

import java.util.Scanner;
import java.util.Random;

public class Tema03_Parte01_Ejercicio15 {

    public static Scanner teclado = new Scanner(System.in);
    public static Random random = new Random();

    public static int dia = 1;
    public static int cromo = 0;
    public static int cromocambio = 0;
    public static int album[] = new int[100];

    static void nuevo(){
        cromo = 0;
        for(int f = 1; f <= 15; f++){
            cromo = random.nextInt(100);
            album[cromo]++;
        }
        ganar();
    }

    static void consulta(){
        cromo = 0;

        System.out.println("Introduce el número del cromo que quieres consultar:");
        cromo = teclado.nextInt();

        if(album[cromo] >= 1){
            System.out.println("Ya tienes este cromo, concretamente tienes este cromo " + album[cromo]+ " veces");
        }
        else{
            System.out.println("Aún no tienes este cromo");
        }
    }

    static void listarepe(){
        cromo = 0;

        System.out.println();
        System.out.println("Esta es la lista de los cromos que tienes repetidos:");
        for(int f = 0; f < 100; f++){
            if(album[f] > 1){
                System.out.println(f);
            }
        }
    }

    static void listapend(){
        cromo = 0;

        System.out.println();
        System.out.println("Esta es la lista de los cromos que te faltan:");
        for(int f = 0; f < 100; f++){
            if(album[f] == 0){
                System.out.println(f);
            }
        }
    }

    static void cambio(){
        cromo = 0;
        cromocambio = 0;
        do{
            cromo = random.nextInt(100);
        }while(album[cromo] < 2);

        do{
            cromocambio = random.nextInt(100);
        }while(album[cromocambio] != 0);

        boolean op2 = false;
      //  do{
            System.out.println("¿Quieres cambiar tu cromo "+cromo+" (el cual tienes repetido) por el cromo "+cromocambio+"? (s/n)");

     //   try{
            op2 = teclado.nextBoolean();
      //  }catch (java.util.InputMismatchException e){
         //   teclado = new Scanner(System.in);
      //  }
      //  }while(op2 != true || op2 != false);

        if(op2){
            album[cromo]--;
            album[cromocambio]++;
            System.out.println("¡Cromos intercambiados!");
        }
        ganar();
    }

    public static void ganar(){
       int count = 0;
        for(int f = 0; f < 100; f++){
            if(album[f] >= 1){
                count++;
               // System.out.println(count);
            }
            if(count == 100){
                System.out.println("Has completado el album!!!");
                System.exit(0);
            }
        }
        count = 0;
    }

    public static void main(String[]args){
        nuevo();
        int op1 = -1;

        while(op1 == -1){
            System.out.println();
            System.out.println();
            System.out.println("Día "+dia);
            System.out.println();
            System.out.println("Introduce una de las siguientes opciones: ");
            System.out.println("1.- Entrada de cromo nuevo");
            System.out.println("2.- Consulta de un cromo");
            System.out.println("3.- Lista de cromos repetidos");
            System.out.println("4.- Lista de cromos pendientes");
            System.out.println("5.- Intercambio de cromos");
            System.out.println("0.- Salir");
            try{
                op1 = teclado.nextInt();
            }catch(java.util.InputMismatchException e){
                teclado = new Scanner(System.in);
            }
            switch(op1){
                case 1:
                    nuevo();
                    dia++;
                    break;
                case 2:
                    consulta();
                    break;
                case 3:
                    listarepe();
                    break;
                case 4:
                    listapend();
                    break;
                case 5:
                    cambio();
                    break;
                case 0:
                    System.exit(0);
                    break;
        }

        op1 = -1;
        }

    }
}
