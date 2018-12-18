import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;

public class calcu {
    private JPanel panel_Main;
    private JPanel panel_left;
    private JPanel panel_right;
    private JButton btn_buscar;
    private JTextArea txta_resultados;
    private JScrollPane scroll_right;

    private static ArrayList<String> sintomas = new ArrayList<String>();

    public calcu(){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            File inputFile = new File("claves.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder;
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("get");
            XPath xPath = XPathFactory.newInstance().newXPath();
            XPathExpression expression = xPath.compile("//clave");
            NodeList nodeList = (NodeList) expression.evaluate(doc, XPathConstants.NODESET);
            System.out.println("nodos " + nodeList.getLength());
            for (int n = nodeList.getLength() - 1; n >= 0; n--) {
                Node nodo = nodeList.item(n);
                short nodeType = nodo.getNodeType();
                if (nodeType == Node.ELEMENT_NODE) {
                    sintomas.add(nodo.getAttributes().getNamedItem("valor").getNodeValue());
                }
            }
            System.out.println(sintomas.toString());


            //Eliminación de los duplicados en la ArrayList paises
            //https://javarevisited.blogspot.com/2012/12/how-to-remove-duplicates-elements-from-ArrayList-Java.html
//            LinkedHashSet<String> listToSet = new LinkedHashSet<String>(paises);
//            ArrayList<String> paises_limpio = new ArrayList<String>(listToSet);


//            GridBagConstraints lblConstraints = new GridBagConstraints();
//            int z = 0;
//            int x = 0;

            panel_left.setLayout(new BoxLayout(panel_left, BoxLayout.Y_AXIS));
            for(String aux : sintomas){
//                lblConstraints.gridx = 0;
//                lblConstraints.gridy = z;
//                z++;
//                System.out.println(z);
//                x++;
                JRadioButton radio_opcion = new JRadioButton();
                JLabel lbl_radio = new JLabel();
                lbl_radio.setText(aux);
//                radio_opcion.
                panel_left.add(lbl_radio);
//                panel_left.revalidate();
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


    public static void main(String[] args){
        JFrame frame = new JFrame("Calculadora componentes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new calcu().panel_Main);
        frame.setSize(550, 300);
        //frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
