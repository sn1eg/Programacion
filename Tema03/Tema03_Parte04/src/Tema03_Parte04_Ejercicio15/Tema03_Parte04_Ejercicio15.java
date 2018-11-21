package Tema03_Parte04_Ejercicio15;

import java.util.Random;
import java.util.Scanner;

public class Tema03_Parte04_Ejercicio15 {
    static char tablero1[][] = new char[5][5];
    static char tablero2[][] = new char[5][5];
    static int jugador1[] = new int[2];
    static int jugador2[] = new int[2];
    static int vidas1 = 3;
    static int vidas2 = 3;

    static void iniciartableros(){
        for(int f = 0; f < tablero1.length; f++){
            for(int c = 0; c < tablero1[f].length;c++){
                tablero1[f][c] = 'L';
                tablero2[f][c] = 'L';
            }
        }
    }

    static void colocarjugadores(char Jugador){
        Random random = new Random();
        int posicionx = random.nextInt(5);
        int posiciony = random.nextInt(5);

        if(Jugador == 'O'){
            tablero1[posiciony][posicionx] = Jugador;
            jugador1[0] = posiciony;
            jugador1[1] = posicionx;
        }
        else if(Jugador == 'X'){
            tablero2[posiciony][posicionx] = Jugador;
            jugador2[0] = posiciony;
            jugador2[1] = posicionx;
        }
    }

    static void imprimirtablero(){
        for(int f = 0; f < tablero1.length; f++){
            for(int c = 0; c < tablero1[f].length;c++){
                System.out.print(tablero1[f][c]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println(vidas1);

//        for(int f = 0; f < tablero1.length; f++){
//            for(int c = 0; c < tablero1[f].length;c++){
//                System.out.print(tablero2[f][c]);
//            }
//            System.out.println();
//        }
    }

    static void colocarzombies(){
        Random random = new Random();

        int posx[] = new int[5];
        int posy[] = new int[5];
        int posicionx = 0;
        int posiciony = 0;

        for(int q = 0; q < 10; q++){

            for(int z = 0; z < 5; z++) {
                while (posicionx == posx[z]) {
                    posicionx = random.nextInt(5);
                }

                while (posiciony == posy[z]) {
                    posiciony = random.nextInt(5);
                }
            }

            if(q < 5){
                tablero1[posiciony][posicionx] = 'Z';
            }
            else if(q >= 5){
                tablero2[posiciony][posicionx] = 'Z';
            }

        }
    }

    static void mover(){
        Scanner teclado = new Scanner(System.in);

        char movimiento = teclado.nextLine().charAt(0);

        if(movimiento == 'W'){
            tablero1[jugador1[0]][jugador1[1]] = 'L';
            jugador1[0] = jugador1[0]-1;
        }
        else if(movimiento == 'S'){
            tablero1[jugador1[0]][jugador1[1]] = 'L';
            jugador1[0] = jugador1[0]+1;
        }
        else if(movimiento == 'A'){
            tablero1[jugador1[0]][jugador1[1]] = 'L';
            jugador1[1] = jugador1[1]-1;
        }
        else if(movimiento == 'D'){
            tablero1[jugador1[0]][jugador1[1]] = 'L';
            jugador1[1] = jugador1[1]+1;
        }

        if(tablero1[jugador1[0]][jugador1[1]] == 'Z'){
            vidas1--;
        }

        if(tablero1[jugador1[0]][jugador1[1]] == 'P'){
            vidas1++;
        }

        tablero1[jugador1[0]][jugador1[1]] = 'O';

    }

    static void colocarpociones(){
        Random random = new Random();

        int posx[] = new int[3];
        int posy[] = new int[3];
        int posicionx = 0;
        int posiciony = 0;

        for(int q = 0; q < 6; q++){

            for(int p = 0; p < 3; p++) {
                do {
                    while (posicionx == posx[p]) {
                        posicionx = random.nextInt(5);
                    }

                    while (posiciony == posy[p]) {
                        posiciony = random.nextInt(5);
                    }
                }while(tablero1[posicionx][posiciony] == 'Z' || tablero1[posicionx][posiciony] == 'O' || tablero1[posicionx][posiciony] == 'X');
            }

            if(q < 3){
                tablero1[posiciony][posicionx] = 'P';
            }
            else if(q >= 3){
                tablero2[posiciony][posicionx] = 'P';
            }
        }
    }

    public static void main(String[]args){
        iniciartableros();
        colocarjugadores('O');
        colocarjugadores('X');
        for(int x = 0; x < 5; x++) {
            colocarzombies();
            colocarpociones();
        }
        imprimirtablero();
//        perdervida();
        while (vidas1 != 0){
            mover();
            imprimirtablero();
        }
    }
}
