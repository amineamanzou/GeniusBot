package miagesorbonne.geniusbot;

import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Parser that will analyze the message and math regex
 * 
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class Parser {
    
    private Document dom;
    private ArrayList<String> invalidMessages = new ArrayList();
    private int invalidMessageIndex = 0;
    
    /**
     * Load the XML file and Parsing it
     */
    public Parser() {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();

            // Parse the config file to get the DOM of the XML
            dom = db.parse("./src/main/java/config.xml");
            
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (SAXException se) {
            se.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    
    /**
     * Returns one of the invalid messages
     */
    public String getInvalidAnswer() {
        // Get the current answer
        String answer = invalidMessages.get(invalidMessageIndex);

        // Invalid message are sent one by one to avoid repetition
        invalidMessageIndex++;
        if (invalidMessageIndex >= invalidMessages.size()) {
            invalidMessageIndex = 0;
        }
        return answer;
    }
    
    /**
     * Loading Config tags from the XML file
     */
    private void loadConfiguration() {
        Element docEle = dom.getDocumentElement();
        NodeList node = docEle.getElementsByTagName("InvalidMessages");
        NodeList nl = ((Element) node.item(0)).getElementsByTagName("message");

        // if node is not null and not empty
        if (nl != null && nl.getLength() > 0) {
            // loop through children
            for (int i = 0; i < nl.getLength(); i++) {
                // get the message
                Element el = (Element) nl.item(i);

                // get message and add it to invalid messages array
                String message = el.getFirstChild().getNodeValue();
                invalidMessages.add(message);
            }
        }
    }
}
