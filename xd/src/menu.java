import java.util.Scanner;

public class menu {

    public static void menu_interno(){
        Scanner teclado = new Scanner(System.in);

        int menu_option = -1;

        do {
            while(menu_option <0 || menu_option > 1) {
                main.clear();
                System.out.println("Selecciona una de las distintas opciones:");

                System.out.println("1.- Empezar");
                System.out.println("0.- Salir");

                try {
                    menu_option = teclado.nextInt();
                }catch(java.util.InputMismatchException e){
                    menu_option = -1;
                    teclado = new Scanner(System.in);
                }
            }

            switch (menu_option) {
                case 0:
                    System.exit(0);
                    break;
            }

        }while(menu_option != 1);
    }

    public static void menu(){
        menu_interno();

        Scanner teclado = new Scanner(System.in);

        int menu_option = -1;

        do {
            while(menu_option <0 || menu_option > 2) {
                System.out.println();
                System.out.println("Selecciona una de las distintas opciones:");

                System.out.println("1.- Crear Orco");
                //System.out.println(".- Modificar Orco");
                System.out.println("2.- Mostrar estadísticas del Orco");
                System.out.println("0.- Salir");

                try {
                    menu_option = teclado.nextInt();
                }catch(java.util.InputMismatchException e){
                    menu_option = -1;
                    teclado = new Scanner(System.in);
                }
            }

            Orco Orco01 = new Orco();
            switch (menu_option) {
                case 1:
                    Orco01.crear();
                    menu_option = -1;
                    break;
                case 2:
                    Orco01.estadisticas();
                    menu_option = -1;
                    break;
            }

        }while(menu_option != 0);






    }
}
