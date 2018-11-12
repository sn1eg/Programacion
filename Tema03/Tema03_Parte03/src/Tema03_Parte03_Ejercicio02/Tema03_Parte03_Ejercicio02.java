package Tema03_Parte03_Ejercicio02;

import java.util.Random;

public class Tema03_Parte03_Ejercicio02 {

    static int vec1[] = new int[4];
    static int vec2[] = new int[4];
    static int vec3[] = new int[4];

    static Random random = new Random();

    public static void carga(){
        for(int f = 0; f < vec1.length; f++){
            vec1[f] = random.nextInt(25)+1;
            vec2[f] = random.nextInt(25)+1;
            System.out.println("Vec1 " + vec1[f]);
            System.out.println("Vec2 " + vec2[f]);
        }
    }

    public static void suma(){
        for(int f = 0; f < vec1.length;f++){
            vec3[f] = vec1[f] + vec2[f];
            System.out.println("Resultado " + vec3[f]);
        }
    }

    public static void main(String[]args){
        carga();
        suma();
    }
}
