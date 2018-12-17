package Tema03_Parte04_Ejercicio10;

import java.util.Scanner;
import java.util.Random;

public class Tema03_Parte04_Ejercicio10 {

    static int V[][] = new int[10][3];

    public static void cargar(){
        Random random = new Random();

        for(int f = 0; f < V.length; f++){
            for(int c = 0; c < V[0].length; c++){
                V[f][c] = random.nextInt(5);
                System.out.print(V[f][c] + " ");
            }
            System.out.println();
        }
    }

    public static void ganaciaporvendedor(){
        int total = 0;

        for(int f = 0; f < V.length; f++){
            total = 0;
            total = total + (6 * V[f][0]);
            total = total + (9 * V[f][1]);
            total = total + (15 * V[f][2]);

            System.out.println("El total del vendedor " + f + " es " + total);
        }
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
                case 3:
                    mayorventa();
                    break;
                case 4:
                    int numvend = teclado.nextInt();
                    ventasdelvendedorx(numvend);
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        }while(op1 != 0);
    }
}


