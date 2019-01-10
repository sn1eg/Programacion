package Pichu;

import java.util.Random;
import java.util.Scanner;

public class Pichu {

    Scanner teclado = new Scanner(System.in);
    Random random = new Random();

    public String name = "";
    public String specie = "Pichu";
    public String EO;

    public int level, hp, attack, defense, speed;

    public Pichu(){
        System.out.println("Name:");
        name = teclado.nextLine();
        System.out.println("Nivel:");
        level = teclado.nextInt();

        hp = random.nextInt(5)+1;
        attack = random.nextInt(5)+1;
        defense = random.nextInt(5)+1;
        speed = random.nextInt(5)+1;
    }

    public void showStats(){
        System.out.println("Name: "+name);
        System.out.println("Level: "+level);
        System.out.println("Specimen: "+specie+'\n');

        System.out.println("HP: "+hp);
        System.out.println("Attack: "+attack);
        System.out.println("Defense: "+defense);
        System.out.println("Speed : "+speed);
    }

    public void setLevel(){
        System.out.println("New level: ");
        level = teclado.nextInt();
    }

    public void levelup(){
        level++;
        if(level == 16){
            this.evolve();
        }
        hp++;
        attack++;
        defense++;
        speed++;


    }

    void evolve(){
        System.out.println("Your Pichu evolved to Pikachu!");
        specie = "Pikachu";
        hp = hp + 20;
        attack = attack+70;
    }
}
