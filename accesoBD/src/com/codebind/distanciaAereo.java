package com.codebind;

import com.codebind.coordstodistance;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

public class distanciaAereo {
    private JLabel lbl_Destino;
    private JLabel lbl_Origen;
    private JPanel panel_Main;
    private JComboBox combo_Destino;
    private JComboBox combo_Origen;
    private JButton btn_buscar;
    private JTextArea txtArea_resultado;

    private static ArrayList<String> Aeropuertos = new ArrayList<String>();
    String aeropuerto1 = "";
    String aeropuerto2 = "";


    private static double latitudA = 0;
    private static double longitudA = 0;
    private static double latitudB = 0;
    private static double longitudB = 0;


    distanciaAereo() {
        combo_Origen.addItem("");
        combo_Destino.addItem("");

        //Llenar los comboBox
        Connection oConni = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            String url = "jdbc:mysql://vps456458.ovh.net:3306/VUELOSdaw";
            Class.forName("com.mysql.jdbc.Driver");
            oConni = DriverManager.getConnection(url, "remoto", "malagaesdeprimera");
            System.out.println("Database connection established");
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                stmt = oConni.createStatement();
                rs = stmt.executeQuery("SELECT Name FROM AIRPORTS;");
                // Hacer algo con los resultados...
                while (rs.next()) {

                    combo_Destino.addItem(rs.getString("Name"));
                    combo_Origen.addItem(rs.getString("Name"));

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

        //Aprovechamos y elimnamos el aeropuerto que este seleccionado por el otro combox

        combo_Destino.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                combo_Origen.removeItem(combo_Destino.getSelectedItem());
            }
        });
        combo_Origen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                combo_Destino.removeItem(combo_Origen.getSelectedItem());
            }
        });
        btn_buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //Buscamos ambos aeropuertos y cogemos sus latitudes y longitudes
                System.out.println();
                System.out.println();
                aeropuerto1 = combo_Destino.getSelectedItem().toString();
                aeropuerto2 = combo_Origen.getSelectedItem().toString();

                Connection oConni = null;
                Statement stmt = null;
                ResultSet rs = null;
                try {
                    String url = "jdbc:mysql://vps456458.ovh.net:3306/VUELOSdaw";
                    Class.forName("com.mysql.jdbc.Driver");
                    oConni = DriverManager.getConnection(url, "remoto", "malagaesdeprimera");
                    System.out.println("Database connection established");
                } catch (Exception e) {
                    e.printStackTrace();

                } finally {
                    try {
                        stmt = oConni.createStatement();
                        rs = stmt.executeQuery("SELECT Latitude,Longitude FROM AIRPORTS WHERE Name = '" + aeropuerto2 + "';");
                        // Hacer algo con los resultados...
                        while (rs.next()) {

                            latitudB = rs.getDouble("Latitude");
                            longitudB = rs.getDouble("Longitude");

                            System.out.println("latitudB " + latitudB);
                            System.out.println("longitudB " + longitudB);
                            System.out.println();
//                            combo_Destino.addItem(rs.getString("Name"));
//                            combo_Origen.addItem(rs.getString("Name"));

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


                try {
                    String url = "jdbc:mysql://vps456458.ovh.net:3306/VUELOSdaw";
                    Class.forName("com.mysql.jdbc.Driver");
                    oConni = DriverManager.getConnection(url, "remoto", "malagaesdeprimera");
                    System.out.println("Database connection established");
                } catch (Exception e) {
                    e.printStackTrace();

                } finally {
                    try {
                        stmt = oConni.createStatement();
                        //http://lineadecodigo.com/java/consultas-sql-con-parametros-en-java-jdbc/
                        rs = stmt.executeQuery("SELECT Latitude,Longitude FROM AIRPORTS WHERE Name = '" + aeropuerto1 + "';");
                        // Hacer algo con los resultados...
                        while (rs.next()) {

                            latitudA = rs.getDouble("Latitude");
                            longitudA = rs.getDouble("Longitude");

                            System.out.println("latitudA " + latitudA);
                            System.out.println("longitudA " + longitudA);
//                            combo_Destino.addItem(rs.getString("Name"));
//                            combo_Origen.addItem(rs.getString("Name"));

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


                txtArea_resultado.setText(coordstodistance.distance(latitudA,longitudA,latitudB,longitudB,'K')+" Km");
            }


            });
        }


        public static void main (String[]args){

            JFrame frame = new JFrame("distanciaAereo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(new distanciaAereo().panel_Main);
            frame.setSize(450, 300);
//        frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

        }
    }
