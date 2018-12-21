package examen;

import java.util.Random;

public class Ejercicio01_Roberto_MunozdeLeonMarfil_S11AW {
    static int vector [];
    static int count0 = 0;
    static int count1 = 0;
    static int count2 = 0;
    static int count3 = 0;
    static int count4 = 0;
    static int count5 = 0;
    static int count6 = 0;
    static int count7 = 0;
    static int count8 = 0;
    static int count9 = 0;

    static int mayor1 = 70;
    static int mayor2 = 70;
    static int mayor3 = 70;

    static void cargar(){
        Random aleatorio = new Random();

        vector = new int[40];//[aleatorio.nextInt(6)+10];

        for(int f = 0; f < vector.length; f++){
            vector[f] = aleatorio.nextInt(10);

            switch(vector[f]){
                case 0:
                    count0++;
                    break;
                case 1:
                    count1++;
                    break;
                case 2:
                    count2++;
                    break;
                case 3:
                    count3++;
                    break;
                case 4:
                    count4++;
                    break;
                case 5:
                    count5++;
                    break;
                case 6:
                    count6++;
                    break;
                case 7:
                    count7++;
                    break;
                case 8:
                    count8++;
                    break;
                case 9:
                    count9++;
                    break;
            }
        }

        for(int f = 0; f < vector.length;f++){
            System.out.println(vector[f]);
        }
    }

    static void imprimir(){

        if(count1 > count0 && count1 > count2 && count1 > count3 && count1 > count4 && count1 > count5 && count1 > count6 && count1 > count7 && count1 > count8 && count1 > count9) {
            if (mayor1 > 10) {
                mayor1 = 1;
            }
            else if(mayor2 > 10) {
                mayor2 = 1;
            }
            else if(mayor3 > 10){
                mayor3 = 1;
            }
        }

        else if(count2 > count0 && count2 > count1 && count2 > count3 && count2 > count4 && count2 > count5 && count2 > count6 && count2 > count7 && count2 > count8 && count2 > count9) {
            if (mayor1 > 10) {
                mayor1 = 2;
            } else if (mayor2 > 10) {
                mayor2 = 2;
            } else {
                mayor3 = 2;
            }
        }

        else if(count3 > count0 && count3 > count1 && count3 > count2 && count3 > count4 && count3 > count5 && count3 > count6 && count3 > count7 && count3 > count8 && count3 > count9){
            if(mayor1 > 10){
                mayor1 = 3;
            }
            else if(mayor2 > 10){
                mayor2 = 3;
            }
            else{
                mayor3 = 3;
            }
        }

        else if(count4 > count0 && count4 > count1 && count4 > count2 && count4 > count3 && count4 > count5 && count4 > count6 && count4 > count7 && count4 > count8 && count4 > count9){
            if(mayor1 > 10){
                mayor1 = 4;
            }
            else if(mayor2 > 10){
                mayor2 = 4;
            }
            else{
                mayor3 = 4;
            }
        }

        else if(count5 > count0 && count5 > count1 && count5 > count2 && count5 > count4 && count5 > count3 && count5 > count6 && count5 > count7 && count5 > count8 && count5 > count9){
            if(mayor1 > 10){
                mayor1 = 5;
            }
            else if(mayor2 > 10){
                mayor2 = 5;
            }
            else{
                mayor3 = 5;
            }
        }

        else if(count6 > count0 && count6 > count1 && count6 > count2 && count6 > count4 && count6 > count5 && count6 > count3 && count6 > count7 && count6 > count8 && count6 > count9){
            if(mayor1 > 10){
                mayor1 = 6;
            }
            else if(mayor2 > 10){
                mayor2 = 6;
            }
            else{
                mayor3 = 6;
            }
        }

        else if(count7 > count0 && count7 > count1 && count7 > count2 && count7 > count4 && count7 > count5 && count7 > count6 && count7 > count3 && count7 > count8 && count7 > count9){
            if(mayor1 > 10){
                mayor1 = 7;
            }
            else if(mayor2 > 10){
                mayor2 = 7;
            }
            else{
                mayor3 = 7;
            }
        }

        else if(count8 > count0 && count8 > count1 && count8 > count2 && count8 > count4 && count8 > count5 && count8 > count6 && count8 > count7 && count8 > count3 && count8 > count9){
            if(mayor1 > 10){
                mayor1 = 8;
            }
            else if(mayor2 > 10){
                mayor2 = 8;
            }
            else{
                mayor3 = 8;
            }
        }

        else if(count9 > count0 && count9 > count1 && count9 > count2 && count9 > count4 && count9 > count5 && count9 > count6 && count9 > count7 && count9 > count8 && count9 > count3){
            if(mayor1 > 10){
                mayor1 = 9;
            }
            else if(mayor2 > 10){
                mayor2 = 9;
            }
            else{
                mayor3 = 9;
            }
        }

        else if(count0 > count1 && count0 > count2 && count0 > count3 && count0 > count4 && count0 > count5 && count0 > count6 && count0 > count7 && count0 > count8 && count0 > count9){
            if(mayor1 > 10){
                mayor1 = 0;
            }
            else if(mayor2 > 10){
                mayor2 = 0;
            }
            else if(mayor3 > 10){
                mayor3 = 0;
            }
        }
        System.out.println();
        System.out.println(mayor1);
        System.out.println(mayor2);
        System.out.println(mayor3);
    }

    public static void main(String[]args){
        cargar();
        imprimir();
    }
}