package Ejercicio15;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class intercambio {
    private JLabel samplelabel;
    public JPanel panelMain;
    private JButton btn_buscar;
    private JTextArea txta_intercambio;
    private JButton btn_si;
    private JButton btn_no;


    private int cromo = 0;
    private int cromocambio = 0;
    private String cuadrotexto = "";
    private Random random = new Random();

    //public static JFrame listrepe = new JFrame("");

    public intercambio() {
        btn_buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cromo = 0;
                cromocambio = 0;
                for (int z = 0; z < 100; z++) {
                    if (ColCromos.album[z] >= 2) {
                        cromo = 1;
                    }
                }
                if (cromo == 1) {
                    cromo = 0;
                    do {
                        cromo = random.nextInt(100);
                    } while (ColCromos.album[cromo] < 2);

                    do {
                        cromocambio = random.nextInt(100);
                    } while (ColCromos.album[cromocambio] != 0);

                    cuadrotexto = "¿Quieres cambiar tu cromo " + cromo + " por el cromo " + cromocambio + "?";
                    txta_intercambio.setText(cuadrotexto);

                    btn_si.setEnabled(true);
                    btn_no.setEnabled(true);
                }
                else{
                    txta_intercambio.setText("No hay cromos para intercambiar aún.");
                }
            }
        });
        btn_si.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int counter = 0;

                ColCromos.album[cromo]--;
                ColCromos.album[cromocambio]++;
                txta_intercambio.setText("¡Cromos intercambiados!");
                btn_si.setEnabled(false);
                btn_no.setEnabled(false);

                //ColCromos.actualizarlista();


                for(int f = 0; f < 100; f++){
                    if(ColCromos.album[f] >= 1){
                        counter++;
                    }
                }
                if (counter == 100) {
                    ColCromos.listrepe.setContentPane(new ganar().panelMain);
                    ColCromos.listrepe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    ColCromos.listrepe.pack();
                    ColCromos.listrepe.setLocationRelativeTo(null);
                    ColCromos.listrepe.setVisible(true);
                }
            }
        });
        btn_no.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //quiero cerrarlo equisde
                ColCromos.intercambio.dispose();
            }
        });
    }

    //ganar();
}
