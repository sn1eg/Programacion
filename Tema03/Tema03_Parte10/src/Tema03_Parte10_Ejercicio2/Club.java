package Tema03_Parte10_Ejercicio2;


import java.util.Scanner;

public class Club {
    Socio socios[] = new Socio[10];

    Scanner teclado = new Scanner(System.in);


    void alta() {
        int count = 0;

        for (int f = 0; f < socios.length; f++) {
            if (!(socios[f] == null)) {
                count++;
            }
        }

        if (count == 10) {
            System.out.println("La lista de socios está completa, no se podrá añadir más socios hasta que haya algún hueco libre");
        } else {
            for (int f = 0; f < socios.length; f++) {
                if (socios[f] == null) {
                    socios[f] = new Socio();
                    break;
                }
            }
        }
    }

    void baja() {
        String buscar = teclado.nextLine();

        for (int f = 0; f < socios.length; f++) {
            if (socios[f].getNombre().equalsIgnoreCase(buscar)) {

            }
        }
    }


    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int eleccion = 0;

        Club club1 = new Club();

        System.out.println();
        do {
            System.out.println("Elige una opción");
            eleccion  = teclado.nextInt();
            switch (eleccion) {
                case 1:
                    club1.alta();
                    break;
                case 2:
                    club1.baja();
            }
        }while(eleccion != 0);
    }
}
