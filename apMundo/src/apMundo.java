import org.w3c.dom.Document;
import org.w3c.dom.Element;
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
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;

public class apMundo {
    private JPanel panel_Main;
    private JLabel lbl_Pais;
    JComboBox combo_Pais;
    private JButton btn_Buscar;
    private JTextArea area_Resultados;
    private JButton iniciarButton;

    private static ArrayList<String> paises = new ArrayList<String>();
    private static ArrayList<String> resultados = new ArrayList<String>();


    public apMundo() {
        iniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
// Boton Iniciar




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

                    for(String aux : paises){
                        combo_Pais.addItem(aux);
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
            }
        });
        btn_Buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
//  Buscar
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
                            resultados.add(nodo.getAttributes().getNamedItem("nombreCorto").getNodeValue());
                        }
                    }
                    System.out.println(resultados.toString());
                    Collections.sort(resultados);
                    resultados.forEach((pais) -> area_Resultados.append(pais + "\n"));
//                    resultados.forEach((pais) -> area_Resultados.set);
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




    private void start() throws ParserConfigurationException, IOException, SAXException{

    }

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        JFrame frame = new JFrame("XML palabras");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new apMundo().panel_Main);
        frame.setSize(550, 300);
        //frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

//
//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder builder = factory.newDocumentBuilder();
//
//        File inputFile = new File("aeropuertos.xml");
//        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder dBuilder;
//
//        dBuilder = dbFactory.newDocumentBuilder();
//
//        Document doc = dBuilder.parse(inputFile);
//        doc.getDocumentElement().normalize();
//
//
//        System.out.println("get");
//        XPath xPath = XPathFactory.newInstance().newXPath();
//        try {
//            XPathExpression expression = xPath.compile("//aeropuerto[@pais]");
//            NodeList nodeList = (NodeList) expression.evaluate(doc, XPathConstants.NODESET);
//            System.out.println("nodos " + nodeList.getLength());
//            for (int n = nodeList.getLength() - 1; n >= 0; n--) {
//                Node nodo = nodeList.item(n);
//                short nodeType = nodo.getNodeType();
//                if (nodeType == Node.ELEMENT_NODE) {
//                    paises.add(nodo.getAttributes().getNamedItem("nombreCorto").getNodeValue());
//                }
//            }
//            System.out.println(paises.toString());
//            Collections.sort(paises);
//            paises.forEach((pais) -> System.out.println(pais));
//        } catch (XPathExpressionException e) {
//            e.printStackTrace();
//        }



    }
}