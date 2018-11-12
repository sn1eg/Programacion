package Tema03_Parte01_Ejercicio08;

public class Tema03_Parte_01_Ejercicio08 {
    public static void main(String[] args) {

        int vector[] = new int[20];
        int num = 0;
        int par = 0;

        for (int f = 0; f < 20; f++) {
            if(num % 2 == 0){
                vector[f] = num;
            }
            else{
                num++;
                vector[f] = num;
            }

            num++;

            do{
                num++;
            }while(num % 2 != 0);
                vector[f] = num;


            System.out.println(vector[f]);
        }
    }
}