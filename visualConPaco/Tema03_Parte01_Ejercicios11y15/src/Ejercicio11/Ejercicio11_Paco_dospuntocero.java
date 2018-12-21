package Ejercicio11;

import java.util.Calendar;
import java.util.Date;

// Es el mismo ejercicio pero usando el objeto Calendar
public class Ejercicio11_Paco_dospuntocero {
    public static void main(String[]args){

        int dia = 23;
        int mes = 10;
        int anio = 2018;

        Calendar calendariofinanio = Calendar.getInstance();

        calendariofinanio.set(Calendar.DAY_OF_MONTH, 31);
        calendariofinanio.set(Calendar.MONTH, 12);
        calendariofinanio.set(Calendar.YEAR, 2018);


        Calendar calendarioactual = Calendar.getInstance();

        calendarioactual.set(Calendar.DAY_OF_MONTH,dia);
        calendarioactual.set(Calendar.MONTH,mes);
        calendarioactual.set(Calendar.YEAR,anio);



        Date datefinanio = calendariofinanio.getTime();
        Date dateactual = calendarioactual.getTime();

        long diferencia = datefinanio.getTime() - dateactual.getTime();

        System.out.println(diferencia/1000/60/60/24);
    }
}
