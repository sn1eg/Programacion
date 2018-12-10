package Tema03_Parte06.Tema03_Parte06_Ejercicios;

public class Tema03_Parte06_Ejercicios {

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
        num++;
        for(int f = 0; num < 1000; num++){
            if(esPrimo(num)){
                return num;
            }
        }
        return -1;
    }

    public static int potencia(int n, int num){
        num = num^n;
        return num;
    }

    public static int digitos(int num){
        String aux = num+"";
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
        String aux = ""+num;

        num = aux.charAt(n);
        return num;
    }

    public static int posicionDeDigito(String caracter, int num){
        String aux = ""+num;
        num = aux.indexOf(caracter);
        return num;
    }

    public static int quitaPorDetras(int n, int num){
        String aux = ""+num;
        int longitud = aux.length();
        String aux2 = "";

        longitud = longitud-n;

        for(int f = 0; f < longitud; f++){
            aux2 = aux2 + String.valueOf(aux.charAt(f));
        }

        num = Integer.parseInt(aux2);

        return num;
    }

    public static int quitaPorDelante(int n, int num){
        String aux = ""+num;
        String aux2 = "";


        for(int f = 0; n < aux.length(); n++){
            aux2 = aux2 + String.valueOf(aux.charAt(n));
        }

        num = Integer.parseInt(aux2);

        return num;
    }

    public static int pegaPorDetras(int n, int num){
        String aux = num+n+"";
        num = Integer.parseInt(aux);
        return num;
    }

    public static int pegaPorDelante(int n, int num){
        String aux = n+num+"";
        num = Integer.parseInt(aux);
        return num;
    }

    public static int trozoDeNumero(int x, int z, int num){
        String aux = ""+num;
        num = Integer.parseInt(aux.substring(x,z));
        return num;
    }

    public static int juntaNumeros(int num1, int num2){
        String aux1 = num1+"";
        String aux2 = num2+"";
        num1 = Integer.parseInt(aux1.concat(aux2));
        return num1;
    }


    public static void main(String[]args){


        System.out.println(siguientePrimo(14));

        //15
        for(int f = 1; f <= 1000; f++){
            boolean flag = esPrimo(f);
            if(flag){
                System.out.println(f+" es primo");
            }
        }

        //16
        for(int f = 1; f <= 1000; f++){
            boolean flag = esCapicua(f);
            if(flag){
                System.out.println(f+" es capicua");
            }
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(quitaPorDetras(2,512));
        System.out.println(quitaPorDelante(2,1024));


        System.out.println();
        System.out.println(voltea(155));

        //17

        //18

        //19
    }
}
