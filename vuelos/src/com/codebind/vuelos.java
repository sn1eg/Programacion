package com.codebind;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.sql.*;

public class vuelos {

    public static final void prettyPrint(Document xml) {
        try {
            Transformer tf = TransformerFactory.newInstance().newTransformer();
            tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            tf.setOutputProperty(OutputKeys.INDENT, "yes");
            Writer out = new StringWriter();
            tf.transform(new DOMSource(xml), new StreamResult(out));
            System.out.println(out.toString());
            Result output = new StreamResult(new File("src" + File.separator + "com/codebind/request.xml"));
            Source input = new DOMSource(xml);
            tf.transform(input, output);
        }catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

        String origen = null;
        String destino = null;


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

        File inputFile = new File("src" + File.separator + "com/codebind/request.xml");
        try {
//            File inputFile = new File("src" + File.separator + "com/codebind/request.xml");
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




        System.out.println(peticiones[0].zonaorigen);


        // Realizamos las consultas SQL
        try {
//            rs = stmt.executeQuery("WHERE BINARY  AIRPORTS.Name LIKE '%" + patron + "%' ORDER BY AIRPORTS.Name");
            rs = stmt.executeQuery("SELECT Name,DestinyID FROM ZONASDESTINO WHERE DestinyID = '" + peticiones[0].zonaorigen + "';");
            while (rs.next()) {
                System.out.println("Origen: "+ rs.getString("Name"));
                origen = rs.getString("Name");
            }

            rs = stmt.executeQuery("SELECT Name,DestinyID FROM ZONASDESTINO WHERE DestinyID = '" + peticiones[0].zonadestino + "';");
            while (rs.next()) {
                System.out.println("Destino: "+rs.getString("Name"));
                destino = rs.getString("Name");
            }

        } catch (SQLException ex) {                     // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }




        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setValidating(false);
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new FileInputStream(new File("src" + File.separator + "com/codebind/request.xml")));
            NodeList misnodos = doc.getElementsByTagName("item");
            Element elemental = (Element) misnodos.item(0);


            Node nodoorigen = doc.createElement("Origen");
            Node nodotexto = doc.createTextNode(origen);
            nodoorigen.appendChild(nodotexto);
            elemental.appendChild(nodoorigen);

            Node nododestino = doc.createElement("Destino");
            nodotexto = doc.createTextNode(destino);
            nododestino.appendChild(nodotexto);
            elemental.appendChild(nododestino);

            prettyPrint(doc);
        } catch (Exception f) {
            f.printStackTrace();
        }

    }
}
