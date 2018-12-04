import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;

public class apMundoDv2 {
    private JPanel panel_Izq;
    private JPanel panel_Drch;
    private JPanel panel_Main;
    private JComboBox combo_Pais;
    private JComboBox combo_Aeropuerto;
    private JLabel lbl_Pais;
    private JLabel lbl_Aeropuerto;
    private JComboBox combo_Pais2;
    private JComboBox combo_Aeropuerto2;
    private JLabel lbl_Pais2;
    private JLabel lbl_Aeropuerto2;
    private JPanel panel_inf;
    private JButton btn_Calcular;
    private JLabel lbl_Distancia;

    private static ArrayList<String> paises = new ArrayList<String>();
    private static ArrayList<String> resultados = new ArrayList<String>();
    private static ArrayList<String> resultados2 = new ArrayList<String>();

    // Creacion de los objetos aeropuerto
    aeropuerto airport1 = new aeropuerto();
    aeropuerto airport2 = new aeropuerto();

    public apMundoDv2() {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            File inputFile = new File("aeropuertos.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder;
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("get");
            XPath xPath = XPathFactory.newInstance().newXPath();
            XPathExpression expression = xPath.compile("//aeropuerto");
            NodeList nodeList = (NodeList) expression.evaluate(doc, XPathConstants.NODESET);
            System.out.println("nodos " + nodeList.getLength());
            for (int n = nodeList.getLength() - 1; n >= 0; n--) {
                Node nodo = nodeList.item(n);
                short nodeType = nodo.getNodeType();
                if (nodeType == Node.ELEMENT_NODE) {
                    paises.add(nodo.getAttributes().getNamedItem("pais").getNodeValue());
                }
            }
            System.out.println(paises.toString());
            Collections.sort(paises);


            //Eliminación de los duplicados en la ArrayList paises
            //https://javarevisited.blogspot.com/2012/12/how-to-remove-duplicates-elements-from-ArrayList-Java.html
            LinkedHashSet<String> listToSet = new LinkedHashSet<String>(paises);
            ArrayList<String> paises_limpio = new ArrayList<String>(listToSet);


            for(String aux : paises_limpio){
                combo_Pais.addItem(aux);
                combo_Pais2.addItem(aux);
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }





        combo_Pais.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                combo_Aeropuerto.removeAllItems();
                resultados.clear();
                String seleccion = (String) combo_Pais.getSelectedItem();

                XPath xPath = XPathFactory.newInstance().newXPath();
                try {
                    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder builder = factory.newDocumentBuilder();
                    File inputFile = new File("aeropuertos.xml");
                    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder dBuilder;
                    dBuilder = dbFactory.newDocumentBuilder();
                    Document doc = dBuilder.parse(inputFile);
                    doc.getDocumentElement().normalize();

                    XPathExpression expression = xPath.compile("//aeropuerto[@pais='"+seleccion+"']");
                    NodeList nodeList = (NodeList) expression.evaluate(doc, XPathConstants.NODESET);
                    System.out.println("nodos " + nodeList.getLength());
                    for (int n = nodeList.getLength() - 1; n >= 0; n--) {
                        Node nodo = nodeList.item(n);
                        short nodeType = nodo.getNodeType();
                        if (nodeType == Node.ELEMENT_NODE) {
                            resultados.add(nodo.getAttributes().getNamedItem("nombreLargo").getNodeValue());
                        }
                    }
                    System.out.println(resultados.toString());
                    Collections.sort(resultados);

                    resultados.forEach((pais) -> combo_Aeropuerto.addItem(pais));

                } catch (XPathExpressionException e) {
                    e.printStackTrace();
                } catch (ParserConfigurationException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (SAXException e) {
                    e.printStackTrace();
                }
            }
        });
        combo_Pais2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                combo_Aeropuerto2.removeAllItems();
                resultados2.clear();
                String seleccion = (String) combo_Pais2.getSelectedItem();

                XPath xPath = XPathFactory.newInstance().newXPath();
                try {
                    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder builder = factory.newDocumentBuilder();
                    File inputFile = new File("aeropuertos.xml");
                    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder dBuilder;
                    dBuilder = dbFactory.newDocumentBuilder();
                    Document doc = dBuilder.parse(inputFile);
                    doc.getDocumentElement().normalize();

                    XPathExpression expression = xPath.compile("//aeropuerto[@pais='"+seleccion+"']");
                    NodeList nodeList = (NodeList) expression.evaluate(doc, XPathConstants.NODESET);
                    System.out.println("nodos " + nodeList.getLength());
                    for (int n = nodeList.getLength() - 1; n >= 0; n--) {
                        Node nodo = nodeList.item(n);
                        short nodeType = nodo.getNodeType();
                        if (nodeType == Node.ELEMENT_NODE) {
                            resultados2.add(nodo.getAttributes().getNamedItem("nombreLargo").getNodeValue());
                        }
                    }
                    System.out.println(resultados2.toString());
                    Collections.sort(resultados2);

                    resultados2.forEach((pais) -> combo_Aeropuerto2.addItem(pais));

                } catch (XPathExpressionException e) {
                    e.printStackTrace();
                } catch (ParserConfigurationException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (SAXException e) {
                    e.printStackTrace();
                }
            }
        });
        btn_Calcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String seleccion = (String) combo_Aeropuerto.getSelectedItem();
                String seleccionado = (String) combo_Aeropuerto2.getSelectedItem();

                System.out.println(seleccion);
                System.out.println(seleccionado);

                XPath xPath = XPathFactory.newInstance().newXPath();
                try {
                    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder builder = factory.newDocumentBuilder();
                    File inputFile = new File("aeropuertos.xml");
                    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder dBuilder;
                    dBuilder = dbFactory.newDocumentBuilder();
                    Document doc = dBuilder.parse(inputFile);
                    doc.getDocumentElement().normalize();

                    XPathExpression expression = xPath.compile("//aeropuerto[@nombreLargo='"+seleccion+"']");
                    NodeList nodeList = (NodeList) expression.evaluate(doc, XPathConstants.NODESET);
//                    System.out.println("nodos " + nodeList.getLength());
                    for (int n = nodeList.getLength() - 1; n >= 0; n--) {
                        Node nodo = nodeList.item(n);
                        short nodeType = nodo.getNodeType();
                        if (nodeType == Node.ELEMENT_NODE) {
                            airport1.setLatitud(Double.parseDouble(nodo.getAttributes().getNamedItem("lat").getNodeValue()));
                            airport1.setLongitud(Double.parseDouble(nodo.getAttributes().getNamedItem("lon").getNodeValue()));
                        }
                    }

                    XPathExpression expresion = xPath.compile("//aeropuerto[@nombreLargo='"+seleccionado+"']");
                    NodeList listanodos = (NodeList) expresion.evaluate(doc, XPathConstants.NODESET);
//                    System.out.println("nodos " + nodeList.getLength());
                    for (int n = listanodos.getLength() - 1; n >= 0; n--) {
                        Node segundonodo = listanodos.item(n);
                        short nodeType = segundonodo.getNodeType();
                        if (nodeType == Node.ELEMENT_NODE) {
                            airport2.setLatitud(Double.parseDouble(segundonodo.getAttributes().getNamedItem("lat").getNodeValue()));
                            airport2.setLongitud(Double.parseDouble(segundonodo.getAttributes().getNamedItem("lon").getNodeValue()));
                        }
                    }

                    System.out.println("Coordenadas de A:"+"\n"+airport1.getLatitud() + "\n" + airport1.getLongitud() +"\n");
                    System.out.println("Coordenadas de B:"+"\n"+airport2.getLatitud() + "\n" + airport2.getLongitud()+"\n");

                    lbl_Distancia.setText("Distancia: "+ coordstodistance.distance(airport1.getLatitud(),airport1.getLongitud(),airport2.getLatitud(),airport2.getLongitud(),'K')+" Km   ");



                } catch (XPathExpressionException e) {
                    e.printStackTrace();
                } catch (ParserConfigurationException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (SAXException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void main(String[]args){

        JFrame frame = new JFrame("apMundoD");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new apMundoDv2().panel_Main);
        frame.setSize(450, 300);
//        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}