package com.codebind;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

public class main {

    votos todoslosvotos[];

    main() {
        int k = 0;
        String csvFile = "demoAL.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        int count = 0;

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] linea = line.split(cvsSplitBy);
                count++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        todoslosvotos = new votos[count];

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] linea = line.split(cvsSplitBy);
                // Chequo por consola de la lectura del fichero...
//                 String[] producto = new String[] {linea[0], linea[1], linea[2], linea[3], linea[4]};
//                System.out.println(Arrays.toString(producto));

                todoslosvotos[k] = new votos();
                todoslosvotos[k].setName(linea[0]);
                todoslosvotos[k].setVotos(Integer.parseInt(linea[1]));
                todoslosvotos[k].setUltvoto(Integer.parseInt(linea[2]));
                todoslosvotos[k].setDia(linea[3]);
                todoslosvotos[k].setHora(linea[4]);
                k++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //Continue here...
//        verDatos("Sergio");
//        System.out.println("El ganador de estas elecciones es.... "+ganador());
    }

    public String ganador(){

        int mayor = 0;
        String champion = "";

        for(int x = 0; x < todoslosvotos.length; x++){
            if(todoslosvotos[x].getVotos() > mayor) {
                mayor = todoslosvotos[x].getVotos();
                champion = todoslosvotos[x].getName();
            }
        }

        return champion;
    }

    public void verDatos(String player){
            String str = player;
            String result = "";
            String name = "";

                for(int x = 0; x < todoslosvotos.length; x++){
                    name = todoslosvotos[x].getName();
                    if(str.equalsIgnoreCase(name)){
                        System.out.println("Candidato encontrado!");
                        System.out.println("Nombre: " +todoslosvotos[x].getName());
                        System.out.println("Votos: "+todoslosvotos[x].getVotos());
                        System.out.println("Último voto: "+todoslosvotos[x].getUltvoto());
                        System.out.println("Día: "+todoslosvotos[x].getDia());
                        System.out.println("Hora: "+todoslosvotos[x].getHora());
                    }
                }
        }


    public static void main(String[] args) {
        main sample = new main();
    }
}
