package Tema03_Parte04_Ejercicio11;

import java.util.Scanner;
import java.util.Random;

public class Tema03_Parte04_Ejercicio11 {

    static int V[][] = new int[10][3];
    static String nombresvend[] = new String[10];
    static String nombresproduct[] = new String[3];

    public static void cargar(){
        Random random = new Random();

        for(int f = 0; f < V.length; f++){
            for(int c = 0; c < V[0].length; c++){
                V[f][c] = random.nextInt(5);
                System.out.print(V[f][c] + " ");
            }
            System.out.println();
        }


        nombresvend[0] = "Roberto";
        nombresvend[1] = "Manolo";
        nombresvend[2] = "Zacarias";
        nombresvend[3] = "Alvaro";
        nombresvend[4] = "Juan";
        nombresvend[5] = "Baltasar";
        nombresvend[6] = "Pepe";
        nombresvend[7] = "Pepe";
        nombresvend[8] = "Pepe";
        nombresvend[9] = "Pepe";

        for(int f = 0; f < nombresproduct.length; f++){
            nombresproduct[f] = "Producto" + f;
            System.out.println(nombresvend[f]);
        }
    }

    public static void ganaciaporvendedor(){
        int total = 0;
        int totalproductos = 0;
        int ganancia[] = new int[10];
        int mejorvendedor = 0;

        for(int f = 0; f < V.length; f++){
            total = 0;

            total = total + (6 * V[f][0]);
            total = total + (9 * V[f][1]);
            total = total + (15 * V[f][2]);



            for(int c = 0; c < V[0].length; c++){
                totalproductos = totalproductos + V[f][c];
            }

            if (totalproductos > mejorvendedor){
                mejorvendedor = f;
            }

            if(f == mejorvendedor){
                ganancia[f] = (50*total)/100;
            }
            else if(total < 60){
                ganancia[f] = (37*total)/100;
            }
            else{
                ganancia[f] = (40*total)/100;
            }

        }

        for(int k = 0; k < nombresvend.length-1;k++){
            for(int f = 0; f < nombresvend.length-1-k;f++){
                if(nombresvend[f].compareTo(nombresvend[f+1])>0){
                    String auxvend = nombresvend[f];
                    nombresvend[f] = nombresvend[f+1];
                    nombresvend[f+1] = auxvend;

                    int auxganancia = ganancia[f];
                    ganancia[f] = ganancia[f+1];
                    ganancia[f+1] = auxganancia;
                }
            }
        }

        for(int f = 0; f < nombresvend.length; f++){
            System.out.println("El total del vendedor " + nombresvend[f] + " es " + ganancia[f]);
        }


        /*total = 0;

        for(int f = 0; f < V.length; f++){
            for(int c = 0; c < V[0].length; c++){
                total = total + V[f][c];
            }
        }
        System.out.println("Las ventas del vendedor "  + " son de " + total);



        for(int f = 0; f < nombresvend.length; f++){
            System.out.println("El total del vendedor " + nombresvend[f] + " es " + ganancia[f]);
        }*/
    }

    public static void gananciaporproducto(){
        int total = 0;

        for(int c = 0; c < V[0].length; c++){
            total = 0;
            for(int f = 0; f < V.length; f++){
                total = total + V[f][c];
            }
            System.out.println("Del producto " + c + " ha habido " + total + " ventas");
        }
    }

    public static void mayorventa(){
        int total = 0;
        int mayor = 0;
        int prodcuto = 0;

        for(int c = 0; c < V[0].length; c++){
            total = 0;
            for(int f = 0; f < V.length; f++){
                total = total + V[f][c];
            }
            if(total > mayor){
                mayor = total;
                prodcuto = c;
            }
        }
        System.out.println("El producto más vendido es el " + prodcuto + " con " + mayor + " ventas");
    }

    public static void ventasdelvendedorx(int num){
        int total = 0;

        for(int c = 0; c < V[0].length; c++){
            total = total + V[num][c];
        }
        System.out.println("Las ventas del vendedor " + num + " son de " + total);
    }

    public static void main(String[]args){
        Scanner teclado = new Scanner(System.in);
        cargar();

        int op1 = 0;

        do {
            op1 = teclado.nextInt();
            switch (op1) {
                case 1:
                    ganaciaporvendedor();
                    break;
                case 2:
                    gananciaporproducto();
                    break;
                /*case 3:
                    mayorventa();
                    break;
                case 4:
                    int numvend = teclado.nextInt();
                    ventasdelvendedorx(numvend);
                    break;*/
                case 0:
                    System.exit(0);
                    break;
            }
        }while(op1 != 0);
    }
}


