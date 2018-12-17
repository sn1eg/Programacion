package Tema03_Parte01_Ejercicio11;

import java.util.Scanner;

public class Tema03_Parte01_Ejercicio11 {
    public static void main(String[]args){
        Scanner teclado = new Scanner(System.in);

        int anio[] = new int[12];
        String fecha = "";

        int dias = 0;
        String diasaux = "";
        int meses = 0;
        String mesesaux = "";
        int totaldiaspormes = 0;
        int restomes = 0;
        int diashastafinaldeaño = 0;

        anio[0] = 31;
        anio[1] = 28;
        anio[2] = 31;
        anio[3] = 30;
        anio[4] = 31;
        anio[5] = 30;
        anio[6] = 31;
        anio[7] = 31;
        anio[8] = 30;
        anio[9] = 31;
        anio[10] = 30;
        anio[11] = 31;

        fecha = teclado.nextLine();

        diasaux = ""+fecha.charAt(0)+fecha.charAt(1);
        dias = Integer.parseInt(diasaux);

        mesesaux = ""+fecha.charAt(3)+fecha.charAt(4);
        meses = Integer.parseInt(mesesaux);

        for(int f = meses + 1; f < 12; f++){
            totaldiaspormes = totaldiaspormes + anio[f];
        }

        restomes = anio[meses] - dias;

        diashastafinaldeaño = totaldiaspormes + restomes;

        System.out.println(restomes);
        System.out.println(totaldiaspormes);

        System.out.println(diashastafinaldeaño);



    }
}
