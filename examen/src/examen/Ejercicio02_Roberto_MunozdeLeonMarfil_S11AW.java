package examen;

import java.util.Scanner;
import java.util.Random;

public class Ejercicio02_Roberto_MunozdeLeonMarfil_S11AW {
    static int[] premio = new int[6];
    static int complementario = 0;

    static void ganadora() {
        Random aleatorio = new Random();
        for(int f = 0; f < premio.length; f++){
            premio[f] = aleatorio.nextInt(10)+1;
        }
        boolean encendido = true;

        /*while(encendido){
            complementario = aleatorio.nextInt(49)+1;
            for(int f = 0; f < premio.length; f++){
                if(premio[f] != complementario){
                    encendido = false;
                }
            }
        }*/
        complementario = aleatorio.nextInt(10)+1;
        for(int z = 0; z < 2; z++){
            for(int f = 0; f < premio.length; f++) {
                if (complementario == premio[f]) {
                    complementario = aleatorio.nextInt(10) + 1;
                }
            }
        }

    }


    static void ver_ganadora() {
        System.out.println("El boleto ganador es:");
        for(int f = 0; f < premio.length; f++){
            System.out.print(premio[f]+" ");
        }
        System.out.println();
        System.out.println("Complementario: "+complementario);
    }

    static int comprobar(int[] boleto) {
        int aciertos = 0;
        for(int f = 0; f < boleto.length; f++){
            for(int z = 0; z <boleto.length; z++){
                if(boleto[z] == premio[f]){
                    aciertos++;
                }
            }
        }
        return aciertos;
    }

    static boolean comprobar_comple(int[] boleto) {
        boolean complementarioesta = false;

        for(int f = 0; f < boleto.length; f++){
            if(boleto[f] == complementario){
                complementarioesta = true;
            }
        }
        return complementarioesta;
    }

    public static void main(String[] args) {
        ganadora();
        ver_ganadora();

        int[] boleto = new int[6];
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce los números de uno en uno:");


        for (int f = 0; f < boleto.length; f++) {
            do {
                boleto[f] = teclado.nextInt();
            } while (!(boleto[f] > 0 && boleto[f] < 50));
        }

        System.out.println("Tu voleto es el: ");
        for(int f = 0; f < boleto.length; f++){
            System.out.print(boleto[f] +" ");
        }

        //ganadora();
        //ver_ganadora();
        int aciertos = comprobar(boleto);
        boolean complemen = comprobar_comple(boleto);

        System.out.println(aciertos);

        if(aciertos == 6 || aciertos == 5 && complemen || aciertos == 5 || aciertos == 4 || aciertos == 3){
            System.out.println("Ganaste! Has tenido "+aciertos+" aciertos.");
            if(complemen){
                System.out.println("Has sacado el numero complementario!");
            }
        }
    }
}
