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
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class apMundo {
    private JPanel panel_Main;
    private JLabel lbl_Pais;
    private JComboBox combo_Pais;
    private JButton btn_Buscar;

    private static ArrayList<String> paises = new ArrayList<String>();
    private static Document xmlDoc = null;


    private void getNodos() {
        System.out.println("get");
        XPath xPath = XPathFactory.newInstance().newXPath();
        try {
            XPathExpression expression = xPath.compile("//aeropuerto[@pais='Spain']");
            NodeList nodeList = (NodeList) expression.evaluate(xmlDoc, XPathConstants.NODESET);
            System.out.println("nodos " + nodeList.getLength());
            for (int n = nodeList.getLength() - 1; n >= 0; n--) {
                Node nodo = nodeList.item(n);
                short nodeType = nodo.getNodeType();
                if (nodeType == Node.ELEMENT_NODE) {
                    paises.add(nodo.getAttributes().getNamedItem("nombreCorto").getNodeValue());
                }
            }
            System.out.println(paises.toString());
            Collections.sort(paises);
            paises.forEach((pais) -> System.out.println(pais));
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {



        /*String[] palabrasXML = new String[0];

        try {
            final String dir = System.getProperty("user.dir");
            File inputFile = new File(dir + File.separator + "src" + File.separator + "aeropuertos.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = null;
            try {
                dBuilder = dbFactory.newDocumentBuilder();
            } catch (ParserConfigurationException e1) {
                e1.printStackTrace();
            }
            Document doc = null;
            try {
                doc = dBuilder.parse(inputFile);
            } catch (SAXException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            doc.getDocumentElement().normalize();
            System.out.println("Elemento rastaticíz :" + doc.getDocumentElement().getNodeName());
            NodeList nodos = doc.getElementsByTagName("ROW");
            System.out.println(nodos.getLength());
            palabrasXML = new String[nodos.getLength()];
            for (int i = 0; i < nodos.getLength(); i++) {
                Node nodo = nodos.item(i);
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element palabra = (Element) nodo;
                    palabrasXML[i] = palabra.getAttribute("aeuropuerto");
                }
            }

        } catch (
                Exception e) {
            e.printStackTrace();
        }*/
    }
}