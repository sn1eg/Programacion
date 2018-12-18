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

public class calcu {
    private JPanel panel_Main;
    private JPanel panel_left;
    private JPanel panel_right;
    private JButton btn_buscar;
    private JTextArea txta_resultados;
    private JScrollPane scroll_right;

    private static ArrayList<String> valores_claves = new ArrayList<String>();
    private static ArrayList<String> valores_nombres = new ArrayList<String>();


    // https://docs.oracle.com/javase/tutorial/uiswing/components/button.html
    ButtonGroup buttongroup_nombres = new ButtonGroup();



//    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder builder = factory.newDocumentBuilder();
//        File inputFile = new File("aeropuertos.xml");
//        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder dBuilder;
//        dBuilder = dbFactory.newDocumentBuilder();
//        Document doc = dBuilder.parse(inputFile);
//        doc.getDocumentElement().normalize();





    public calcu(){
        //Creamos el documento e introducimos el xml en el
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
                    valores_claves.add(nodo.getAttributes().getNamedItem("valor").getNodeValue());
                    valores_nombres.add(nodo.getFirstChild().getNodeValue());
                }
            }
            System.out.println(valores_claves.toString());
            System.out.println(valores_nombres.toString());




            // Usamos BoxLayout para que los radiobuttons se añadan de forma dinamica en el.
            // https://stackoverflow.com/questions/1534889/how-to-make-jlabels-start-on-the-next-line
            panel_left.setLayout(new BoxLayout(panel_left, BoxLayout.Y_AXIS));

            for(int f = 0; f < nodeList.getLength(); f++){
                JRadioButton radio_opcion = new JRadioButton(valores_nombres.get(f));
                //Le establecemos un comando al  botón para poder obtener luego su nombre
                radio_opcion.setActionCommand(valores_nombres.get(f));

                //Añadimos el boton al grupo de botones y lo añadimos al panel.
                buttongroup_nombres.add(radio_opcion);
                panel_left.add(radio_opcion);
                System.out.println(radio_opcion.getText());
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


        btn_buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String sintoma = buttongroup_nombres.getSelection().getActionCommand();
                System.out.println("Sintoma seleccionado "+sintoma);
            }
        });
    }


    public static void main(String[] args){
        JFrame frame = new JFrame("Calculadora componentes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new calcu().panel_Main);
        frame.setSize(550, 550);
        //frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
