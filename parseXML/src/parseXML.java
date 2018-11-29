import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.Timer;

public class parseXML {
    private JPanel panelMain;
    private JTextArea txtAPalabra;
    private JLabel lblTexto;
    private JTextField txtPalabra;
    private JPanel panelJuego;
    private JButton ButAgain;
    private JButton ButJugar;
    private JLabel lblPalabra;
    private JLabel lblResultado;
    private JTextField textField1;
    private JLabel lblNombre;

    /* https://examples.javacodegeeks.com/core-java/xml/dom/add-node-to-dom-document/*/

/*

DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
dbf.setValidating(false);
DocumentBuilder db = dbf.newDocumentBuilder();
Document doc = db.parse(new FileInputStream(new File("david.xml")));
Element element = doc.getDocumentElement();
Node node = doc.createElement("palabra");
((Element)node).setAttribute("fecha","?????????");
((Element)node).setAttribute("generada","??????");
((Element)node).setAttribute("contestada","???????");
((Element)node).setAttribute("acertada","S");
element.appendChild(node);
prettyPrint(doc);

*/

    public void xmlcreate() throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setValidating(false);
        DocumentBuilder db = dbf.newDocumentBuilder();

        Document doc = db.parse(new FileInputStream(new File("david.xml")));

        Element element = doc.getDocumentElement();
        Node node = doc.createElement("palabra");
        ((Element) node).setAttribute("fecha", "oy");
        ((Element) node).setAttribute("generada", "oy");
        ((Element) node).setAttribute("contestada", "oy");
        ((Element) node).setAttribute("acertada", "oy");
        element.appendChild(node);
//        prettyview(doc);
    }



    public parseXML() {
		String[] palabrasXML = new String[0];
		try {
		    final String dir = System.getProperty("user.dir");
		    File inputFile = new File(dir + File.separator + "src" + File.separator + "PALABRAS.xml");
		    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		    Document doc = dBuilder.parse(inputFile);
		    doc.getDocumentElement().normalize();
		    System.out.println("Elemento rastaticíz :" + doc.getDocumentElement().getNodeName());
		    NodeList nodos = doc.getElementsByTagName("ROW");
		    System.out.println(nodos.getLength());
		    palabrasXML = new String[nodos.getLength()];
		    for (int i = 0; i < nodos.getLength(); i++) {
		        Node nodo = nodos.item(i);
		        if (nodo.getNodeType() == Node.ELEMENT_NODE) {
		            Element palabra = (Element) nodo;
		            palabrasXML[i] = palabra.getAttribute("PALABRA");
		        }
		    }

		} catch (Exception e) {
		    e.printStackTrace();
		}
        String[] finalPalabrasXML = palabrasXML;
        ActionListener Ocultar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblPalabra.setVisible(false);
                panelJuego.setVisible(true);
            }
        };
        Timer reloj = new Timer(1500, Ocultar);
        ButJugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reloj.start();
                ButJugar.setVisible(false);
                int n = (int) (Math.random() * finalPalabrasXML.length);
                lblPalabra.setText(finalPalabrasXML[n]);
                lblPalabra.setFont(new Font("Serif", Font.PLAIN, 65));
            }
        });
        txtPalabra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (lblPalabra.getText().equals(txtPalabra.getText())) {
                    lblResultado.setVisible(true);
                    lblResultado.setText("Has acertado la palabra!");
                    ButAgain.setVisible(true);
                } else {
                    lblResultado.setVisible(true);
                    lblResultado.setText("No has acertado la palabra.");
                    ButAgain.setVisible(true);
                }
            }
        });

        ButAgain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reloj.restart();
                reloj.start();
                ButAgain.setVisible(false);
                lblPalabra.setVisible(true);
                lblResultado.setVisible(false);
                panelJuego.setVisible(false);
                txtPalabra.setText("");
                int n = (int) (Math.random() * finalPalabrasXML.length);
                lblPalabra.setText(finalPalabrasXML[n]);
                lblPalabra.setFont(new Font("Serif", Font.PLAIN, 65));
            }
        });
    }

    /*https://www.tutorialspoint.com/java_xml/java_dom_parse_document.htm*/

    public static void main(String[] args) {
        JFrame frame = new JFrame("XML palabras");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new parseXML().panelMain);
        frame.setSize(550, 300);
        //frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
