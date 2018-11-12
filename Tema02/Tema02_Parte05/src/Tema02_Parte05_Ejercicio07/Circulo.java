package Tema02_Parte05_Ejercicio07;

public class Circulo {
    double numeroPi = 3.1416;
    double radio = 0;

    public double area() {
        double resultado = numeroPi*(radio*radio);
        return resultado;
    }

    public double longitud() {
        double resultado = 2*numeroPi*radio;
        return resultado;
    }
}
