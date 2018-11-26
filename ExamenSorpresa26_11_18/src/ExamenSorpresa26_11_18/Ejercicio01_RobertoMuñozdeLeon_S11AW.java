package ExamenSorpresa26_11_18;

import java.util.Scanner;

public class Ejercicio01_RobertoMuñozdeLeon_S11AW {
    static String cadena = "";
    static String cadenaarray[];

    static void leer(){
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce una frase:");
        cadena = teclado.nextLine(); //entrada de texto tipica
    }

    static void descomponer(){
        cadenaarray = cadena.split(" "); //Separa el string "cadena" en distintos strings mediante split(" "), teniendo espacio como separador, y las guarda en el array
    }

    static void imprimir(){
        for(int f = 0; f < cadenaarray.length; f++){
            String imprimimeme = cadenaarray[f].substring(0,1).toUpperCase() + cadenaarray[f].substring(1); // Se coge la palabra guardada en el array y por medio de substring la primera letra se coloca en mayuscula
            System.out.println(imprimimeme + " :" + cadenaarray[f].length() +" caracteres");
        }
        System.out.println();
    }

    public static void main(String[]args){
        while(!cadena.equals("fin")){ //Esto falta por pulir para que sean las tres primeras letras
            leer();
            descomponer();
            imprimir();
//            leer();
        }
    }
}
