import org.jdatepicker.JDatePicker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class calcFechas {
    private JPanel panelMain;
    private JDatePicker datePicker;
    private JButton butCalcular;
    private JLabel lbl_diasrestantes;


    public calcFechas() {
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calF = Calendar.getInstance();
        calF.set(Calendar.DAY_OF_MONTH, 31);
        calF.set(Calendar.MONTH, 11);
        calF.set(Calendar.YEAR, 2018);
        Date finAño= calF.getTime();
        butCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Calendar calU = (Calendar) datePicker.getModel().getValue();
                if (calU != null) {
                    Date fechaU=calU.getTime();
                    long diff = finAño.getTime() - fechaU.getTime();
                    lbl_diasrestantes.setText("Días hasta fin de año: " + diff / 1000 / 60 / 60 / 24);
                    //En lugar de en consola, mostrarlo en un cuadro de texto
                };
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("calcFechas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new calcFechas().panelMain);
        frame.setSize(550, 300);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
