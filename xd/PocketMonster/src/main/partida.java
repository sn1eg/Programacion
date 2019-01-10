package main;

import Pichu.*;

import java.util.Scanner;

public class partida {

    Scanner teclado = new Scanner(System.in);

    public static void main(String[]args){
        Pichu foo = new Pichu();
        foo.showStats();

        foo.setLevel();
        foo.levelup();
        System.out.println();
        foo.showStats();
    }
}