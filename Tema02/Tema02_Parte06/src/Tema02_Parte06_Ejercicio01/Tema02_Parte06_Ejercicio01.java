package Tema02_Parte06_Ejercicio01;

import java.util.Scanner;

public class Tema02_Parte06_Ejercicio01 {

    public static int notaMedia(int v1, int veces){
        v1 = v1/veces;
        return v1;
    }

    /*private static int notaAlta(int v1, int masAlta){
        if(v1 > masAlta)
            masAlta = v1;
        return masAlta;
    }

    private static int notaBaja(int v1, int masBaja){
        if(v1 < masBaja)
            masBaja = v1;
        return masBaja;
    }*/

    public static void main(String[]args){
        Scanner teclado = new Scanner(System.in);

        int valor = 1000000;
        int total = 0;
        int count = 0;
        int alta = 0;
        int baja = 0;

        int masAlta = 0;
        int masBaja = 0;


        while(valor > -1){
            count++;
            if(valor > masAlta)
                masAlta = valor;
            if(valor < masBaja)
                masBaja = valor;
            total = total + valor;
            valor = teclado.nextInt();
        }

        int media = notaMedia(total,count);



        System.out.println(media);
        System.out.println(alta);
        System.out.println(baja);
    }


}
