public class xd {
    public static void main(String[] arg) {
        int sec = 0;
        int min = 0;
        int hor = 0;

        for (int f = 1; f <= 7200; f++) {
            sec = sec + 1;
            if (sec == 60) {
                min = min + 1;
                sec = 0;
            }

            if (min == 60) {
                hor = hor + 1;
                min = 0;
            }

          /*  System.out.println("Hora: "+ hor);
            System.out.println("Segundo: "+ sec);
            System.out.println("Minuto: "+ min);*/

            System.out.printf("%02d:%02d:%02d %n",hor,min,sec);
        }
    }
}
