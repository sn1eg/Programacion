import java.util.Scanner;
import java.util.Random;

public class Orco {

    private static Scanner teclado = new Scanner(System.in);
    private static Random random = new Random();


    public static String nombre;
    public static int nivel = 1;
    public static int vidamax;
    public static int vida;

    public static void levelup(){
        if (nivel >= 5){
            vidamax = 75;
            vida = vidamax;
        }
        else if(nivel >= 3){
            vidamax = 50;
            vida = vidamax;
        }
        else if(nivel >= 1){
            vidamax = 25;
            vida = vidamax;
        }


    }

    public static void crear(){
        main.clear();
        System.out.println("Introduce un nombre para el orco:");
        nombre = teclado.nextLine();

        System.out.println("Introduce el nivel inicial que tendrá el Orco:");
        nivel = teclado.nextInt();

        levelup();

        System.out.println("El orco ha sido creado.");

    }

    public static void estadisticas(){
        main.clear();
        System.out.println("Nombre: "+nombre);
        System.out.println("Nivel: "+nivel);
        System.out.println("Vida máxima: " +vidamax);
        System.out.println("Vida actual: "+ vida);
        //System.out.println();
    }



}
