package Tema03_Parte10_Ejercicio2;

import java.util.Scanner;

public class Socio {
    private String nombre, apellidos;
    private int antiguedad, cuota;

    Scanner teclado = new Scanner(System.in);


    boolean isempty(){
        if(nombre != "") {
            return false;
        }
        return true;
    }

    void setCuota(int m){
        this.cuota = m;
    }

    String getNombre(){
        return nombre;
    }

    Socio(){
        System.out.println("Nombre:");
        nombre = teclado.nextLine();
        System.out.println("Apellidos:");
        apellidos = teclado.nextLine();
        System.out.println("Antiguedad:");
        antiguedad = teclado.nextInt();
        System.out.println("Cuota:");
        cuota = teclado.nextInt();
    }
}
