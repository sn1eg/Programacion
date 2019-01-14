package com.codebind;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conecta {
    private static String url = "jdbc:mysql://vps456458.ovh.net:3306/VUELOSdaw?useUnicode=yes&characterEncoding=UTF-8";
    private static String driverName="com.mysql.cj.jdbc.Driver";
    private static String userName="remoto";
    private static String password="malagaesdeprimera";
    private static Connection oConexion;

    public static Connection conectar() {
        try {
            Class.forName(driverName);
            oConexion = DriverManager.getConnection(url, userName, password);
            System.out.println("Database connection established");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return oConexion;
    }
}
