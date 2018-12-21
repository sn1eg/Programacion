package com.codebind;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class eje02 {
    private JPanel mainPanel;
    private JTextField txtAltura;
    private JButton btAnadir;
    private JLabel lblAlturas;
    private JLabel lblAltura;
    private JTextField txtAlturas;
    private JLabel lblMedia;
    private JTextField txtMedia;

    static float alturas[] = new float[5];
    static float promedio;
    private int k = 0;


    public eje02() {
        btAnadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(!txtAltura.getText().equals((""))){
                    if(k < alturas.length){
                        alturas[k] = Float.parseFloat(txtAltura.getText());
                        k++;
                        showAltura();

                        txtMedia.setText(String.valueOf(calcularMedia()));
                        txtAltura.setText("");
                        txtAltura.grabFocus(); //Junto a la linea anterior, sirve para que una vez que el usuario añada un numero, el campo de texto se ponga en blanco

                        if (k == alturas.length) {
                            btAnadir.setEnabled(false);
                        }
                    }
                }
            }
        });
    }

    private void showAltura(){

    }

    private float calcularMedia(){
        float mediaAlturas = 0;
        for(int i = 0;i<alturas.length;i++){
            mediaAlturas+= alturas[i];
        }
        return mediaAlturas/alturas.length;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Alturas");
        frame.setContentPane(new eje02().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
