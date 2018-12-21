package Ejercicio15;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ColCromos {
    private JPanel mainPanel;
    private JPanel menuPanel;
    private JMenuBar MenuBar1;
    private JMenu Menu1;
    private JMenuItem Menu1op1;
    private JMenuItem Menu1op2;
    private JMenuItem Menu1op3;
    private JMenuItem Menu1op4;
    private JMenuItem Menu1op5;
    private JMenuItem Menu1op6;
    private JTextField txt_0_9;
    private JLabel lbl_0_9;
    private JLabel lbl_10_19;
    private JTextField txt_10_19;
    private JLabel lbl_20_29;
    private JTextField txt_20_29;
    private JLabel lbl_40_49;
    private JLabel lbl_30_39;
    private JTextField txt_30_39;
    private JTextField txt_40_49;
    private JLabel lbl_50_59;
    private JTextField txt_50_59;
    private JLabel lbl_60_69;
    private JTextField txt_60_69;
    private JLabel lbl_70_79;
    private JTextField txt_70_79;
    private JLabel lbl_80_89;
    private JTextField txt_80_89;
    private JLabel lbl_90_99;
    private JTextField txt_90_99;
    private JButton iniciarButton;
    private JLabel lblTotalSobres;
    private JLabel lblCromo1;
    private JLabel lblCromo2;
    private JLabel lblCromo3;
    public JList list_repe;
    private JScrollPane list_scrollpanell;
    private JList list_repe_pen;
    private JMenu Menu;
    private JMenu MenuArchivo;
    private JMenuItem ArchivoSalir;

    public static Random random = new Random();
    public static int album[] = new int[100];
    public static int cromo = 0;
    public static int cromo1 = 0;
    public static int cromo2 = 0;
    public static int cromo3 = 0;
    public  int sobre = 0;

    private String fila1 = "";
    private String fila2 = "";
    private String fila3 = "";
    private String fila4 = "";
    private String fila5 = "";
    private String fila6 = "";
    private String fila7 = "";
    private String fila8 = "";
    private String fila9 = "";
    private String fila10 = "";


    public static JFrame intercambio = new JFrame("Intercambio de cromos");
    public static JFrame consulta = new JFrame("Consulta de cromos");
    public static JFrame listrepe = new JFrame("");


    private void clean(){
        fila1 = "";
        fila2 = "";
        fila3 = "";
        fila4 = "";
        fila5 = "";
        fila6 = "";
        fila7 = "";
        fila8 = "";
        fila9 = "";
        fila10 = "";
    }

    public void ganar(){

    }

    public void actualizarlista(){
        clean();

        for(int f = 0; f < 10; f++){
            fila1 = fila1 + (album[f] + " ");
        }
        for(int f = 10; f < 20; f++){
            fila2 = fila2 + (album[f] + " ");
        }
        for(int f = 20; f < 30; f++){
            fila3 = fila3 + (album[f] + " ");
        }
        for(int f = 30; f < 40; f++){
            fila4 = fila4 + (album[f] + " ");
        }
        for(int f = 40; f < 50; f++){
            fila5 = fila5 + (album[f] + " ");
        }
        for(int f = 50; f < 60; f++){
            fila6 = fila6 + (album[f] + " ");
        }
        for(int f = 60; f < 70; f++){
            fila7 = fila7 + (album[f] + " ");
        }
        for(int f = 70; f < 80; f++){
            fila8 = fila8 + (album[f] + " ");
        }
        for(int f = 80; f < 90; f++){
            fila9 = fila9 + (album[f] + " ");
        }
        for(int f = 90; f < 100; f++){
            fila10 = fila10 + (album[f] + " ");
        }

        txt_0_9.setText(fila1);
        txt_10_19.setText(fila2);
        txt_20_29.setText(fila3);
        txt_30_39.setText(fila4);
        txt_40_49.setText(fila5);
        txt_50_59.setText(fila6);
        txt_60_69.setText(fila7);
        txt_70_79.setText(fila8);
        txt_80_89.setText(fila9);
        txt_90_99.setText(fila10);
    }



    public ColCromos() {
        Menu1op6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        Menu1op1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int counter = 0;
                cromo = 0;
                cromo1 = 0;
                cromo2 = 0;
                cromo3 = 0;

                for(int f = 1; f <= 3; f++){
                    cromo = random.nextInt(100);
                    album[cromo]++;

                    if(cromo1 == 0){
                        cromo1 = cromo;
                    }
                    else if(cromo2 == 0){
                        cromo2 = cromo;
                    }
                    else if(cromo3 == 0){
                        cromo3 = cromo;
                    }
                }
                actualizarlista();

                sobre++;
                lblTotalSobres.setText("Sobres: "+sobre);

                lblCromo1.setText("Cromos: "+cromo1);
                lblCromo2.setText(""+cromo2);
                lblCromo3.setText(""+cromo3);

                for(int f = 0; f < 100; f++){
                    if(album[f] >= 1){
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
        iniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String aux = "";
                for(int f = 0; f < 10; f++){
                    aux = aux + (album[f] + " ");
                }
                txt_0_9.setText(aux);
                txt_10_19.setText(aux);
                txt_20_29.setText(aux);
                txt_30_39.setText(aux);
                txt_40_49.setText(aux);
                txt_50_59.setText(aux);
                txt_60_69.setText(aux);
                txt_70_79.setText(aux);
                txt_80_89.setText(aux);
                txt_90_99.setText(aux);
                iniciarButton.setEnabled(false);
            }
        });
        Menu1op2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //Consultar Cromo
                consulta.setContentPane(new consulta().panelMain);
                consulta.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                consulta.pack();
                consulta.setLocationRelativeTo(null);
                consulta.setVisible(true);
            }
        });
        Menu1op5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //Intercambiar cromos
                intercambio.setContentPane(new intercambio().panelMain);
                intercambio.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                intercambio.pack();
                intercambio.setLocationRelativeTo(null);
                intercambio.setVisible(true);
            }
        });
        Menu1op3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //Listar cromos repetidos

                list_repe_pen.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
                DefaultListModel listModelRep = new DefaultListModel();
                list_repe_pen.setModel(listModelRep);

                listModelRep.addElement("Cromos repetidos:");
                listModelRep.addElement("");

                for(int f = 0; f < 100; f++){
                    if(album[f] >= 2){
                        listModelRep.addElement("Cromo " + f + " - " + album[f]);
                    }
                }
                actualizarlista();
            }
        });
        Menu1op4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //Cromos pendientes

                list_repe_pen.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
                DefaultListModel listModelRep = new DefaultListModel();
                list_repe_pen.setModel(listModelRep);

                listModelRep.addElement("Cromos pendientes:");
                listModelRep.addElement("");

                for(int f = 0; f < 100; f++){
                    if(album[f] == 0){
                        listModelRep.addElement("Cromo " + f);
                    }
                }
                actualizarlista();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Colección de cromos");
        frame.setContentPane(new ColCromos().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}