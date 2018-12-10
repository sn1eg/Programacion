package Tema03_Parte04.src.Tema03_Parte04_Ejercicio14;

import java.util.Scanner;

public class Tema03_Parte04_Ejercicio14 {

    static char tablero[][] = new char[6][7];
    static int jugador = 0;

    static void iniciarJuego(){
        for (int f = 0; f < tablero.length; f++){
            for( int c = 0; c < tablero[f].length; c++){
                tablero[f][c] = 'L';
            }
        }
    }

    static void colocarFicha(){
        Scanner teclado = new Scanner(System.in);
        char Ficha = 'X';

        //Selector de jugador
        if(jugador == 0){
            Ficha = 'B';
            jugador++;
        }
        else if(jugador == 1){
            Ficha = 'R';
            jugador--;
        }

        System.out.println("Introduce una columna (1-7):");
        int columna = teclado.nextInt() - 1;

        for(int f = 5; f >= 0; f--){
            if(tablero[f][columna] == 'L'){
                tablero[f][columna] = Ficha;
                break;
            }
        }

    }

    static void presentarTablero(){
        for(int f = 0; f < tablero.length; f++){
            for( int c = 0; c < tablero[f].length; c++){
                System.out.print(tablero[f][c] +" ");
            }
            System.out.println();
        }
    }

    static void comprobarGanador(){
        Scanner teclado = new Scanner(System.in);
        int blanco = 0;
        int rojo = 0;


        for(int f = 0; f < tablero.length; f++){
            for(int c = 0; c < tablero[f].length; c++){
                if(tablero[f][c] == 'B'){
                    rojo = 0;
                    blanco++;
                    if(blanco == 4){
                        System.out.println("Blanco ha ganado!");;
                        System.exit(0);
                    }
                }
                else if(tablero[f][c] == 'R'){
                    blanco = 0;
                    rojo++;
                    if(rojo == 4){
                        System.out.println("Rojo ha ganado!");;
                        System.exit(0);
                    }
                }
                else{
                    blanco = 0;
                    rojo = 0;
                }
            }
        }
    }

    public static void main(String[]args){
        iniciarJuego();
        presentarTablero();

        int count = 0;
        while(count != 42){
            colocarFicha();
            presentarTablero();
            comprobarGanador();
            count++;
        }
        System.out.println("Todos perdeis!");
    }
}
