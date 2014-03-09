package miagesorbonne.geniusbot.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import miagesorbonne.geniusbot.entity.Keyword;
import miagesorbonne.geniusbot.entity.Step;
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
    private HashMap<String, Step> steps = new HashMap<String, Step>();
    private ArrayList<String> invalidMessages = new ArrayList();
    private int invalidMessageIndex = 0;
    public  int stepCounter = 1000;

    /**
     * Load the XML file and Parsing it
     */
    public Parser() {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();

            // Parse the config file to get the DOM of the XML
            dom = db.parse("./src/main/java/config.xml");
            
            // Load steps from the XML config file
            loadConfiguration();
            loadSteps();
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
     * @return invalid message
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
        NodeList node = docEle.getElementsByTagName("MessagesInvalid");
        NodeList nl = ((Element) node.item(0)).getElementsByTagName("message");

        // If node is not null and not empty
        if (nl != null && nl.getLength() > 0) {
            // Loop through children
            for (int i = 0; i < nl.getLength(); i++) {
                // Get the message
                Element el = (Element) nl.item(i);

                // Get message and add it to invalid messages array
                String message = el.getFirstChild().getNodeValue();
                invalidMessages.add(message);
            }
        }
    }
    
    /**
     * Load the steps from the configuration file
     */
    private void loadSteps() {

        // Get document element object
        Element docEle = dom.getDocumentElement();

        // Get the Step names nodes
        NodeList nl = docEle.getElementsByTagName("Step");

        // If node is not null and has children
        if (nl != null && nl.getLength() > 0) {

            // Loop through all children
            for (int i = 0; i < nl.getLength(); i++) {

                // Getting step element
                Element el = (Element) nl.item(i);

                // Getting step id
                String id = el.getAttribute("id");

                // Getting all step messages
                ArrayList messages = new ArrayList();
                NodeList messagesNodeList = el.getElementsByTagName("message");

                // If messages node is not null and has children
                if (messagesNodeList != null && messagesNodeList.getLength() > 0) {

                    // Loop through all children
                    for (int j = 0; j < messagesNodeList.getLength(); j++) {

                        // Getting current message element
                        Element elmsg = (Element) messagesNodeList.item(j);

                        // Appending the message node value to the messages arraylist
                        messages.add(elmsg.getFirstChild().getNodeValue());
                    }
                }

                // Getting keywords in the current state
                ArrayList keywords = getKeywords(el);

                // construct a new State object
                Step state = new Step(id, keywords, messages);

                stepCounter ++;

                // add the state to the states hashmap
                steps.put(id, state);
            }
        }
    }
    
    /**
     * Get all keywords in a Step Tag
     * @param ele
     * @return List of keywords
     */
    public ArrayList getKeywords(Element ele) {

        // Construct an arraylist of keywords
        ArrayList keywords = new ArrayList();

        // Getting all nodes by keyword tag name
        NodeList nl = ele.getElementsByTagName("keyword");

        // If the tag is not null and has children
        if (nl != null && nl.getLength() > 0) {

            // Loop through all the children
            for (int i = 0; i < nl.getLength(); i++) {

                // Getting the keyword element
                Element el = (Element) nl.item(i);

                // Find the keyword target, classname and argument attributes
                String wordTag = el.getFirstChild().getNodeValue();
                String target = el.getAttribute("target");
                String className = el.getAttribute("className");
                String arg = el.getAttribute("arg");
                String variable = el.getAttribute("variable");
                int points = 0;
                try{
                     points = Integer.valueOf(el.getAttribute("points"));
                }catch (Exception e){
                    
                }

                //String learn = el.getAttribute("learn");
                // Separating keyword with comma
                String[] words = wordTag.split(",");

                // Loop through all words
                for (String word : words) {

                    // Removing spaces
                    word = word.trim();
                    
                    // Building a new keyword
                    Keyword keyword = new Keyword(word, target, className, arg, variable);//, points, learn );

                    // Adding the keyword to keywords array list
                    keywords.add(keyword);
                }
            }
        }

        // Returning all the keywords in the given node
        return keywords;
    }
    
    /**
     * Get step object by id
     * @param id
     * @return Step
     */
    public Step getStep(String id) {
        return steps.get(id);
    }
}
