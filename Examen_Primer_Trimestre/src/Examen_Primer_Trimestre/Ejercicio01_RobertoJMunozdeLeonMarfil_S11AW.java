package Examen_Primer_Trimestre;

public class Ejercicio01_RobertoJMunozdeLeonMarfil_S11AW {
    //Ejercicio 1

    static int[] SubArray(int array[], int posicion1, int posicion2){

        //Calculamos la longitud que tendrá el array
        int longitud = posicion2-posicion1+1;
        System.out.println("longitud: "+longitud);

        int resultado[] = new int[longitud];

        //Vamos metiendo los numeros comprendidos entre posicion1 y posicion2 en el nuevo array, incluyendo ambas posiciones
        for(int f = posicion1; f <= posicion2; f++){
            resultado[f-posicion1] = array[f];
            System.out.println("X- "+array[f]);
        }

        return resultado;
    }

    public static void main(String[]args){

        //Esto es por tener un ejemplo
        int miarray[] = new int[5];

        miarray[0] = 3;
        miarray[1] = 6;
        miarray[2] = 2;
        miarray[3] = 8;
        miarray[4] = 9;

        int miresultado[] = SubArray(miarray,1,3);
        System.out.println();


        //Imprimimos para ver que va bien
        for(int f = 0; f < miresultado.length; f++){
            System.out.println("Resultado: "+miresultado[f]);
        }
    }
}
