import javax.xml.parsers.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class csvToxml {
    private static Document xmlDoc = null;
    private static ArrayList<String> paises = new ArrayList<String>();
    static long inicio;

    public csvToxml() {
        long fin = System.currentTimeMillis();
        System.out.println("tiempo de parse csv y creación del xml ");
        System.out.println(fin - inicio + " milisegundos");
    }

    //https:www.mkyong.com/java8/java-8-foreach-examples
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
        inicio = System.currentTimeMillis();
        String csvFile = "airports.dat";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = dbf.newDocumentBuilder();
            xmlDoc = builder.newDocument();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Element nodeRaiz = xmlDoc.createElement("aeropuertos");
        xmlDoc.appendChild(nodeRaiz);
        try {
            br = new BufferedReader(new FileReader(csvFile));
            System.out.println(csvFile);
            while ((line = br.readLine()) != null) {
                String[] linea = line.split(cvsSplitBy);
                Node node = xmlDoc.createElement("aeropuerto");
                ((Element) node).setAttribute("nombreLargo", linea[1].replace("\"", ""));
                ((Element) node).setAttribute("nombreCorto", linea[2].replace("\"", ""));
                ((Element) node).setAttribute("pais", linea[3].replace("\"", ""));
                ((Element) node).setAttribute("matricula", linea[4].replace("\"", ""));
                ((Element) node).setAttribute("area", linea[11].replace("\"", ""));
                ((Element) node).setAttribute("lat", linea[6].replace("\"", ""));
                ((Element) node).setAttribute("lon", linea[7].replace("\"", ""));
                nodeRaiz.appendChild(node);
            }
            try {
                Transformer tr = TransformerFactory.newInstance().newTransformer();
                tr.setOutputProperty(OutputKeys.INDENT, "yes");
                tr.setOutputProperty(OutputKeys.METHOD, "xml");
                tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
                tr.transform(new DOMSource(xmlDoc),
                        new StreamResult(new FileOutputStream("aeropuertos.xml")));

            } catch (TransformerException te) {
                System.out.println(te.getMessage());
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        csvToxml c = new csvToxml();
        c.getNodos();
    }
}
