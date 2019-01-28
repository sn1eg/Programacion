package com.codebind;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class demoAL {

    ArrayList<votos> todoslosvotos = new ArrayList();

    demoAL() {
//        int k = 0;
        String csvFile = "demoAL.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] linea = line.split(cvsSplitBy);

                votos votoX = new votos();
                votoX.setName(linea[0]);
                votoX.setVotos(Integer.parseInt(linea[1]));
                votoX.setUltvoto(Integer.parseInt(linea[2]));
                votoX.setDia(linea[3]);
                votoX.setHora(linea[4]);
                todoslosvotos.add(votoX);
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
//        verDatos();
//        System.out.println("El ganador de estas elecciones es.... "+ganador());
    }

    public String ganador(){


//        todoslosvotos.get(0).setVotos(todoslosvotos.get(0).getVotos()+4);


        int mayor = 0;
        String champion = "";

        for(int x = 0; x < todoslosvotos.size(); x++){
            if(todoslosvotos.get(x).getVotos() > mayor) {
                mayor = todoslosvotos.get(x).getVotos();
                champion = todoslosvotos.get(x).getName();
            }
        }

        return champion;
    }

    public void verDatos(){

                for(int x = 0; x < todoslosvotos.size(); x++){
                    System.out.println();
                        System.out.println("Nombre: " +todoslosvotos.get(x).getName());
                        System.out.println("Votos: "+todoslosvotos.get(x).getVotos());
                        System.out.println("Último voto: "+todoslosvotos.get(x).getUltvoto());
                        System.out.println("Día: "+todoslosvotos.get(x).getDia());
                        System.out.println("Hora: "+todoslosvotos.get(x).getHora());
                }
        }


    public static void main(String[] args) {
        demoAL Adrian = new demoAL();
    }
}
