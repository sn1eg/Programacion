import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class parseXML {
    private JPanel panelMain;
    private JLabel lbl_palabra;
    private JButton button1;




    public parseXML() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                    String[] palabrasXML = new String[0];
                Random random = new Random();

                    try {
                        final String dir = System.getProperty("user.dir");
                        File inputFile = new File(dir + "/src/" + "PALABRAS.xml");
                        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                        Document doc = dBuilder.parse(inputFile);
                        doc.getDocumentElement().normalize();
//                        System.out.println("Elemento raíz :" + doc.getDocumentElement().getNodeName());
                        NodeList nodos = doc.getElementsByTagName("ROW");
//                        System.out.println(nodos.getLength());
                        palabrasXML = new String[nodos.getLength()];
                        for (int i = 0; i < nodos.getLength(); i++) {
                            Node nodo = nodos.item(i);
                            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                                Element palabra = (Element) nodo;
                                palabrasXML[i]=palabra.getAttribute("PALABRA");
                            }
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    String palabras[];
                    palabras = palabrasXML;

                     String palabro = palabras[random.nextInt(55092) + 1];

                     boolean flag = true;
//                     if(z>70){
                    Timer timer = new Timer();

                TimerTask tarea = new TimerTask() {
                    int z = 0;
                    @Override
                    public void run() {
                        lbl_palabra.setText(palabro);
                        System.out.println(palabro);
                        z++;
                    }
                };

                timer.schedule(tarea, 1, 100);

                try
                {
                    Thread.sleep(1000);
                }
                catch (Exception e)
                {
                }
                tarea.cancel();
            }

//                lbl_palabra.setText("Woola");
//            }
        });
    }

    /*https://www.tutorialspoint.com/java_xml/java_dom_parse_document.htm*/
    private static String[] getXML() {
        String[] palabrasXML = new String[0];
        try {
            final String dir = System.getProperty("user.dir");
            File inputFile = new File(dir + "/src/" + "PALABRAS.xml");
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
                    palabrasXML[i]=palabra.getAttribute("PALABRA");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return palabrasXML;
    }

    public static void main(String[] args) {
        String[] palabras;
        JFrame frame = new JFrame("XML palabras");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new parseXML().panelMain);
        frame.setSize(550, 200);
        //frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        palabras = getXML();
        System.out.println("a "+palabras.length);
        System.out.println(palabras[54]);
    }
}
