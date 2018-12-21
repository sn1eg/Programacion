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

public class apMundo {
    private JPanel panel_Main;
    private JLabel lbl_Pais;
    JComboBox combo_Pais;
    private JButton btn_Buscar;
    private JTextArea area_Resultados;

    private static ArrayList<String> paises = new ArrayList<String>();
    private static ArrayList<String> resultados = new ArrayList<String>();

//    https://www.tutorialspoint.com/java_xml/java_xpath_parse_document.htm
//    http://chuwiki.chuidiang.org/index.php?title=Ejemplo_sencillo_de_JComboBox
//    https://stackoverflow.com/questions/16695903/using-xml-to-populate-a-jcombobox-something-missing
//    https://stackoverflow.com/questions/33196567/adding-java-variable-to-xpath#

    public apMundo() {

        //Añadir los paises al combobox
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


        btn_Buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
//  Buscar
                area_Resultados.setText("");
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

                    resultados.forEach((pais) -> area_Resultados.setText(area_Resultados.getText() + pais + "\n"));
                    resultados.clear();



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


    public static void main(String[] args){
        JFrame frame = new JFrame("XML palabras");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new apMundo().panel_Main);
        frame.setSize(550, 300);
        //frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);



    }
}