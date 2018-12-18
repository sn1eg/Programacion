import org.w3c.dom.*;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.StringWriter;
import java.io.Writer;
import javax.swing.Timer;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.events.Attribute;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Formatter;

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
    private JPanel panelNombre;
    private JLabel lblNombre;
    public JTextField txtNombre;
    private JButton butNombre;
    public static String usuario;
    private String resultado;
    private String dir = System.getProperty("user.dir");
    /* https://examples.javacodegeeks.com/core-java/xml/dom/add-node-to-dom-document/*/



    public parseXML() {
        String[] palabrasXML = new String[0];
        try {
            File inputFile = new File(dir + File.separator + "src" + File.separator + "PALABRAS.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Elemento raíz :" + doc.getDocumentElement().getNodeName());
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
                //Si el campo del usuario está vacío, obviamente no se creará uno nuevo.
                if (!txtNombre.getText().isEmpty()) {
                    usuario = txtNombre.getText();
                    usuario = usuario.trim();
                    File jugador = new File(dir + File.separator + "src" + File.separator + usuario + ".xml");
                    //Si el usuario ya existe, no se creará un nuevo fichero y se actualizará el existente.
                    if (!jugador.exists()) {
                        try {
                            //Para crear un nuevo fichero XML a partir de un nuevo nombre de usuario.
                            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
                            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
                            Document document = documentBuilder.newDocument();
                            Element pala = document.createElement("palabras");
                            document.appendChild(pala);
                            TransformerFactory transformerFactory = TransformerFactory.newInstance();
                            Transformer crear = transformerFactory.newTransformer();
                            DOMSource domSource = new DOMSource(document);
                            StreamResult streamResult = new StreamResult(new File(dir + File.separator + "src" + File.separator + usuario + ".xml"));
                            crear.transform(domSource, streamResult);
                        } catch (ParserConfigurationException g) {
                            g.printStackTrace();
                        } catch (TransformerException f) {
                            f.printStackTrace();
                        }
                    }

                }
                reloj.start();
                lblPalabra.setVisible(true);
                ButJugar.setVisible(false);
                panelNombre.setVisible(false);
                int n = (int) (Math.random() * finalPalabrasXML.length);
                lblPalabra.setText(finalPalabrasXML[n]);
                lblPalabra.setFont(new Font("Serif", Font.PLAIN, 65));
            }
        });
        txtPalabra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButAgain.setVisible(true);
                butNombre.setVisible(true);
                if (lblPalabra.getText().equals(txtPalabra.getText())) {
                    lblResultado.setVisible(true);
                    lblResultado.setText("Has acertado la palabra!");
                    resultado="S";
                } else {
                    lblResultado.setVisible(true);
                    lblResultado.setText("No has acertado la palabra.");
                    resultado="N";
                }
                //Si no se ha escrito nombre, el juego se iniciará en modo anónimo y no guardará ningún dato en ningún fichero.
                if (!txtNombre.getText().isEmpty()) {
                    try {
                        //Actualiza el XML del usuario por cada palabra acertada o no.
                        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                        dbf.setValidating(false);
                        DocumentBuilder db = dbf.newDocumentBuilder();
                        Document doc = db.parse(new FileInputStream(new File(dir + File.separator + "src" + File.separator + usuario + ".xml")));
                        Element element = doc.getDocumentElement();
                        Node node = doc.createElement("palabra");
                        ((Element) node).setAttribute("fecha", now());
                        ((Element) node).setAttribute("generada", lblPalabra.getText());
                        ((Element) node).setAttribute("contestada", txtPalabra.getText());
                        ((Element) node).setAttribute("acierto", resultado);
                        element.appendChild(node);
                        prettyPrint(doc);
                    } catch (Exception f) {
                        f.printStackTrace();
                    }
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
                butNombre.setVisible(false);
                int n = (int) (Math.random() * finalPalabrasXML.length);
                lblPalabra.setText(finalPalabrasXML[n]);
                lblPalabra.setFont(new Font("Serif", Font.PLAIN, 65));
            }
        });
        //El nuevo botón para cambiar de usuario si así se desea.
        butNombre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelNombre.setVisible(true);
                butNombre.setVisible(false);
                panelJuego.setVisible(false);
                ButAgain.setVisible(false);
                reloj.stop();
                ButJugar.setVisible(true);
                lblResultado.setVisible(false);
                txtPalabra.setText("");
            }
        });
    }
    //Para actualizar y GUARDAR el fichero XML con los nuevos datos.
    public static final void prettyPrint(Document xml) {
        try {
            String dir = System.getProperty("user.dir");
            Transformer tf = TransformerFactory.newInstance().newTransformer();
            tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            tf.setOutputProperty(OutputKeys.INDENT, "yes");
            Writer out = new StringWriter();
            tf.transform(new DOMSource(xml), new StreamResult(out));
            System.out.println(out.toString());
            Result output = new StreamResult(new File(dir + File.separator + "src" + File.separator + usuario+".xml"));
            Source input = new DOMSource(xml);
            tf.transform(input, output);
        }catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
    //Para saber la hora actual del sistema.
    public static String now() {
        String Date_format_now = "yyy-MM-dd HH:mm:ss";
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(Date_format_now);
        return sdf.format(cal.getTime());
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
