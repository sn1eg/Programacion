package Tema03_Parte06_Ejercicio1_14;

import com.sun.source.doctree.SinceTree;

public class Tema03_Parte06_Ejercicio1_14 {

    public static boolean esCapicua(int num){

        int faltante = 0;
        int numeroInvertido = 0;
        int restante = 0;

        faltante=num;
        numeroInvertido=0;
        restante=0;

        while(faltante!=0) {

            restante=faltante%10;
            numeroInvertido=numeroInvertido*10+restante;
            faltante=faltante/10;

        }

        if(numeroInvertido==num){
            return true;
        }else{
            return false;

        }
    }


    public static boolean esPrimo(int num){

        boolean primo = true;
        for(int i = 2; i < num; i++) {
            if (num % i == 0) {
                primo = false;
                break;
            }
        }
        if (primo){
            return true;
        }
        else{
            return false;
        }
    }

    public static int siguientePrimo(int num){

        return 0;
    }

    public static int potencia(int num){

        return 0;
    }

    public static int digitos(int num){
        String aux = "num";
        num = aux.length();
        return num;
    }

    public static int voltea(int num){
        int cifra, inverso = 0;
        while(num!=0){
            cifra = num%10;
            inverso = (inverso * 10) + cifra;
            num/=10;
        }
        return inverso;
    }

    public static int digitoN(int n, int num){
        String aux = "num";

        num = aux.charAt(n);
        return num;
    }

    public static int posicionDeDigito(String caracter, int num){
        String aux = "num";
        num = aux.indexOf(caracter);
        return num;
    }

    public static int quitaPorDetras(int n, int num){
        String aux = "num";
        int longitud = aux.length();
        String aux2 = "";

        longitud = longitud-n;

        for(int f = 0; f < longitud; f++){
            //Por aqui me quede
        }

        return 0;
    }
}
