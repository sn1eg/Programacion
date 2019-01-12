package com.codebind;

import java.sql.*;

/*https://dev.mysql.com/doc/connector-j/5.1/en/connector-j-usagenotes-connect-drivermanager.html
  https://dev.mysql.com/doc/connector-j/8.0/en/connector-j-usagenotes-statements.html*/
public class showDatas {
    public static void main(String[] args) {
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
                rs = stmt.executeQuery("SELECT Name,Alias FROM AIRLINES WHERE Name LIKE '%IB%';");
                // Hacer algo con los resultados...
                while (rs.next()) {
                    String nombre = rs.getString("Name");
                    System.out.println(nombre);
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
}