package examen;

import java.util.Random;

public class Ejercicio01_1 {
    static Random random = new Random();

    public static int mayor(int array[]){
        int count[] = new int[10];
        int mayor = 0;
        int dev = 0;

        for(int f = 0; f < array.length; f++){
            count[array[f]]++;
        }

        for(int f = 0; f < count.length; f++){
            if(count[f] > mayor) {
                mayor = count[f];
                dev = f;
            }

//            System.out.println(count[array[f]]);
        }
        return dev;
    }

    public static void cargar(int vector[]){
        for(int f = 0; f < vector.length; f++){
            vector[f] = random.nextInt(10);
        }
    }

    public static void imprimir(int vector[]){
        for(int f = 0; f < vector.length; f++){
            System.out.print(vector[f]+" ");
        }
    }

    public static void main(String[]args){
        int vector[] = new int[random.nextInt(6)+10];

        cargar(vector);
        imprimir(vector);
        System.out.println();
        System.out.println(mayor(vector) +" Es el número que más se repite");

    }
}
