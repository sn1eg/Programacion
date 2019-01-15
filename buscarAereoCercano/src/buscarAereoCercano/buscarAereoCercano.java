package buscarAereoCercano;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Timer;

public class buscarAereoCercano {
    private JPanel panel_Main;
    private JLabel lbl_zona;
    private JTextField txt_zona;
    private JList list_zonas;
    private JTextArea area_resultados;
    private JPanel panel_mid;
    private JList lista_uno;


    public buscarAereoCercano() {


        ActionListener Empezar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("yolo");
            }
        };

        String array[] = {"Uno","Dos"};


        lista_uno = new JList(array);

        JavaSetTimeOut.setTimeout(100);


        txt_zona.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);



            }
        });
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("Buscar Aeropuertos Cercanos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new buscarAereoCercano().panel_Main);
        frame.setSize(550, 300);
        //frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

}
