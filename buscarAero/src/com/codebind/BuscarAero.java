package com.codebind;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;


public class BuscarAero {
    private JTextField txtAeropuerto;
    private JTextArea txtResultados;
    private JPanel panelMain;
    private Connection oConni = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    public BuscarAero() {
        try {
            oConni = Conecta.conectar();
            stmt = oConni.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
        txtAeropuerto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                String patron = txtAeropuerto.getText();
                try {
                    txtResultados.setText(null);
                    rs = stmt.executeQuery("SELECT  AIRPORTS.Name,COUNTRIES.CodeA FROM AIRPORTS \n" +
                            "INNER JOIN COUNTRIES ON (COUNTRIES.Name=AIRPORTS.Country)\n" +
                            "WHERE BINARY  AIRPORTS.Name LIKE '%" + patron + "%' ORDER BY AIRPORTS.Name");
                    while (rs.next()) {
                        String name = rs.getString("Name");
                        String country = rs.getString("CodeA");
                        txtResultados.append(name + " " + country + "\n");
                    }
                } catch (SQLException ex) {                     // handle any errors
                    System.out.println("SQLException: " + ex.getMessage());
                    System.out.println("SQLState: " + ex.getSQLState());
                    System.out.println("VendorError: " + ex.getErrorCode());
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Buscador de aeropuertos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new BuscarAero().panelMain);
        frame.setSize(550, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
