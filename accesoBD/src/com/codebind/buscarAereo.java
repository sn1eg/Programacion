package com.codebind;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;

public class buscarAereo {
    private JLabel lbl_buscar;
    private JTextField txt_Buscar;
    private JPanel panel_Main;
    private JTextArea area_resultados;

    public buscarAereo() {

//        Connection oConni = null;
//        try {
//            String url = "jdbc:mysql://vps456458.ovh.net:3306/VUELOSdaw";
//            Class.forName("com.mysql.jdbc.Driver");
//            oConni = DriverManager.getConnection(url, "remoto", "malagaesdeprimera");
//            System.out.println("Database connection established");
//        } catch (Exception a) {
//            a.printStackTrace();
//
//        }


//        Connection finalOConni = oConni;
        txt_Buscar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);

                area_resultados.setText("");

                Connection oConni = null;
                Statement stmt = null;
                ResultSet rs = null;
                try {
                    String url = "jdbc:mysql://vps456458.ovh.net:3306/VUELOSdaw";
                    Class.forName("com.mysql.jdbc.Driver");
                    oConni = DriverManager.getConnection(url, "remoto", "malagaesdeprimera");
                    System.out.println("Database connection established");
                } catch (Exception d) {
                    d.printStackTrace();

                } finally {
                    try {
                        stmt = oConni.createStatement();
                        rs = stmt.executeQuery("SELECT Name,Alias,IATA,Country FROM AIRLINES WHERE Name LIKE '%"+txt_Buscar.getText().trim()+"%';");
                        // Hacer algo con los resultados...
                        while (rs.next()) {

                            area_resultados.append(rs.getString("Name")+", " + rs.getString("Alias")+", "+ rs.getString("IATA")+", "+ rs.getString("Country")+'\n' );
                            System.out.println("HOLA");

                    /*
                    String nombre = rs.getString("Name");
                    System.out.println(nombre);
                    */
                        }
                    } catch (SQLException ex) {
                        // handle any errors
                        System.out.println("SQLException: " + ex.getMessage());
                        System.out.println("SQLState: " + ex.getSQLState());
                        System.out.println("VendorError: " + ex.getErrorCode());
                    } finally {
                        if (rs != null) {
                            try {
                                rs.close();
                            } catch (SQLException sqlEx) {
                            } // ignore
                            rs = null;
                        }
                        if (stmt != null) {
                            try {
                                stmt.close();
                            } catch (SQLException sqlEx) {
                            } // ignore
                            stmt = null;
                        }
                    }
                }
            }


        });
    }


    public static void main(String[] args) {

        JFrame frame = new JFrame("buscarAereo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new buscarAereo().panel_Main);
        frame.setSize(450, 300);
//        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
