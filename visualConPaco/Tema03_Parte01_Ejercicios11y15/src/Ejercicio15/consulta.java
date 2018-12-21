package Ejercicio15;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class consulta {
    public JPanel panelMain;
    private JTextField txt_cromoaconsultar;
    private JLabel lbl_cromoaconsultar;
    private JButton btn_consultarcromo;
    private JTextArea txtarea_cromoconsulta;

    public consulta() {
        btn_consultarcromo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String recogercromo = "";
                int cromoaconsultar = 0;
                int cromoveces = 0;

                recogercromo = txt_cromoaconsultar.getText();
                cromoaconsultar = Integer.parseInt(recogercromo);

                cromoveces = ColCromos.album[cromoaconsultar];

                txtarea_cromoconsulta.setText("El cromo " + cromoaconsultar + " lo tienes " + cromoveces + " veces.");
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
