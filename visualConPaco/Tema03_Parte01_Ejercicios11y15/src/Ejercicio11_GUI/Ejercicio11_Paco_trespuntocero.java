package Ejercicio11_GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicio11_Paco_trespuntocero {
    private JPanel panelMain;
    private JButton button1;

    public Ejercicio11_Paco_trespuntocero() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }

    public static void main(String[]args){
        JFrame frame = new JFrame("ap11");
        frame.setContentPane(new Ejercicio11_Paco_trespuntocero().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
