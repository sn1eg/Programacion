package com.codebind;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;

public class vuelos {
    public static void main(String[] args) {

        Connection oConni = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            oConni = Conecta.conectar();
            stmt = oConni.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }

        request peticiones[] = new request[0];
        try {
            File inputFile = new File("src" + File.separator + "com/codebind/request.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Elemento raíz :" + doc.getDocumentElement().getNodeName());
            NodeList nodos = doc.getElementsByTagName("item");
            System.out.println(nodos.getLength());

            //Creo un array de peticiones para guardar en el cada petición que se vaya a hacer
            peticiones = new request[nodos.getLength()];
            System.out.println(peticiones.length);
            for (int i = 0; i < nodos.getLength(); i++) {
                Node nodo = nodos.item(i);
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element item = (Element) nodo;
                    peticiones[i] = new request(item.getAttribute("idZonaOrigen"), item.getAttribute("idZonaDestino"));
                    /* x */
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        //Creamos el XML

        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = null;
            document = documentBuilder.parse("src" + File.separator + "com/codebind/request.xml");
            Element root = document.getDocumentElement();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        //Actualiza el XML del usuario por cada palabra acertada o no.
//        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//        dbf.setValidating(false);
//        DocumentBuilder db = null;
//        try {
//            db = dbf.newDocumentBuilder();
//        } catch (ParserConfigurationException e) {
//            e.printStackTrace();
//        }
//        Document doc = null;
//        try {
//            doc = db.parse(new FileInputStream(new File("src" + File.separator + "com/codebind/misputasmuelas.xml")));
//        } catch (SAXException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Element element = doc.getDocumentElement();
//        Node node = doc.createElement("palabra");
////            ((Element) node).setAttribute("fecha", now());
////            ((Element) node).setAttribute("generada", lblPalabra.getText());
////            ((Element) node).setAttribute("contestada", txtPalabra.getText());
////            ((Element) node).setAttribute("acierto", resultado);
//        element.appendChild(node);
////            prettyPrint(doc);

        System.out.println(peticiones[0].zonaorigen);

        try {
//            rs = stmt.executeQuery("WHERE BINARY  AIRPORTS.Name LIKE '%" + patron + "%' ORDER BY AIRPORTS.Name");
            rs = stmt.executeQuery("SELECT Name,DestinyID FROM ZONASDESTINO WHERE DestinyID = '" + peticiones[0].zonaorigen + "';");
            while (rs.next()) {
                System.out.println(rs.getString("Name"));
//                String name = rs.getString("Name");
//                String country = rs.getString("CodeA");
////                txtResultados.append(name + " " + country + "\n");
            }
        } catch (SQLException ex) {                     // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

    }
}
