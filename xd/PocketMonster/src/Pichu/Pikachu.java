package Pichu;

import java.util.Scanner;
import java.util.Random;

public class Pikachu {

    Scanner teclado = new Scanner(System.in);
    Random random = new Random();

    public String name, EO;
    String specie = "Pikachu";

    public int level, hp, attack, defense, speed;

    public void showStats(){
        System.out.println("Name: "+name);
        System.out.println("Level: "+level);
        System.out.println("Specimen: "+specie+'\n');

        System.out.println("HP: "+hp);
        System.out.println("Attack: "+attack);
        System.out.println("Defense: "+defense);
        System.out.println("Speed : "+speed);
    }

    void levelup(){
        level++;
        hp++;
        attack++;
        defense++;
        speed++;
    }


}
