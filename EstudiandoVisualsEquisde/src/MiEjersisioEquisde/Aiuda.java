package MiEjersisioEquisde;

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

public class Aiuda {
    private JPanel panelMain;
    private JComboBox cmb_aeropuerto;
    private JLabel lbl_aeuropuerto;
    private JLabel lbl_matricula;
    private JLabel lbl_paises;
    private JComboBox cmb_paises;
    private JPanel panel_left;
    private JPanel panel_right;



    private static ArrayList<String> paises = new ArrayList<String>();
    private static ArrayList<String> resultados = new ArrayList<String>();



    public Aiuda(){


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
                cmb_paises.addItem(aux);
            }

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }



        cmb_paises.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println(cmb_paises.getSelectedItem());
            }
        });
    }






    public static void main(String[] args){
        JFrame frame = new JFrame("Matriculas Aeropuertes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Aiuda().panelMain);
        frame.setSize(550, 300);
        //frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
