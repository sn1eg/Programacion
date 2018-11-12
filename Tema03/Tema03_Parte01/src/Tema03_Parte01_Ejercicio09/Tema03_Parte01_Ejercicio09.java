package Tema03_Parte01_Ejercicio09;
// por terminar
import java.util.Scanner;

public class Tema03_Parte01_Ejercicio09 {
    static char num[];
    static String numero = "";

    static void cargar(){
        Scanner teclado = new Scanner(System.in);
        numero = teclado.nextLine();
        num = new char[numero.length()];

        for(int f = 0; f < num.length; f++){
            num[f] = numero.charAt(f);
        }
    }

    static void calcular(){
        String aux1 = "";
        String aux2 = "";
        int aux3 = 0;
        int aux4 = 0;

        for(int f = 0; f < numero.length();f++){
            aux1 = num[f]+"";
            aux2 = num[f+2]+"";

            aux3 = Integer.parseInt(aux1);
            aux4 = Integer.parseInt(aux2);
        }
    }

    public static void main(String[]args){
        cargar();
        calcular();
    }
}
