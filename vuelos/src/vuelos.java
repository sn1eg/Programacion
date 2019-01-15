import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class vuelos {

    public static void main(String[]args){
        request peticiones[];
        try {
            File inputFile = new File("src" + File.separator + "request.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Elemento raíz :" + doc.getDocumentElement().getNodeName());
            NodeList nodos = doc.getElementsByTagName("item");
            System.out.println(nodos.getLength());
//            palabrasXML =
            peticiones = new request[nodos.getLength()];
            for (int i = 0; i < nodos.getLength(); i++) {
                Node nodo = nodos.item(i);
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element item = (Element) nodo;
                    peticiones[i] = new request(item.getAttribute("idZonaOrigen"),item.getAttribute("idZonaDestino"));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
