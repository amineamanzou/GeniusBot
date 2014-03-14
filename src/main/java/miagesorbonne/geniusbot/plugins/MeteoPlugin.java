package miagesorbonne.geniusbot.plugins;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 * Weather Plugin that add weather info functionnality to the bot
 *
 * @author Alexandre Le Boucher <alex.leboucher.inef@gmail.com>
 * @author Shinthujan Sivakumar <shinthujan.sivakumar@gmail.com>
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class MeteoPlugin {
    
    // Weather condition variables
    public String now = "";
    public String tomorrow = "";
    public String dayAfterTomorrow = "";

    // Yahoo API URL for Paris
    private static String url = "http://weather.yahooapis.com/forecastrss?w=615702&u=c";

    /**
     * Main constructor
     */
    public MeteoPlugin() {
        HttpClient client = new HttpClient();
        GetMethod method = new GetMethod(url);

        try {
            // Executing the GET query
            int statusCode = client.executeMethod(method);

            // If method execution failed
            if (statusCode != HttpStatus.SC_OK) {
                System.err.println("Method failed: " + method.getStatusLine());
            }
            
            BufferedReader br = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream()));

            String xmlResponse = "";
            String readLine;
            while (((readLine = br.readLine()) != null)) {
                xmlResponse += readLine;
            }

            // Parse the xml
            parse(xmlResponse);
        } catch (HttpException e) {
            System.err.println("Violation de protocol: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Erreur de transport: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Release the connection.
            method.releaseConnection();
        }

    }

    /**
     * Parsing the XML sent by the API
     * @param xml 
     */
    private void parse(String xml) {
        DocumentBuilderFactory dbf =
                DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(xml));

            // Parsing dom
            Document dom = db.parse(is);

            // Getting current day node
            NodeList nodes = dom.getElementsByTagName("yweather:condition");

            // Storing Nod of tomorow and after tomorrow
            NodeList forcast = dom.getElementsByTagName("yweather:forecast");

            // Get now, tomorrow and day after tomorrow conditions from nodes
            now = ((Element) nodes.item(0)).getAttribute("text");
            tomorrow = ((Element) forcast.item(0)).getAttribute("text");
            dayAfterTomorrow = ((Element) forcast.item(1)).getAttribute("text");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Return the answer about weather
     * @param condition
     * @return answer
     */
    public String getResponse(String condition) {
        String weather = "";

        // If argument is now or empty, return now's weather
        if (condition.equals("now") || condition.length() == 0) {
            weather = "Aujourd'hui il fait : " + now + " à Paris (Resultat fournis en anglais par Yahoo) ";
        }

        // Condition : demain weather information
        if (condition.equals("demain")) {
            weather = "Je suppose que demain il fera : " + tomorrow + " à Paris (Resultat fournis en anglais par Yahoo) ";
        }

        // Condition : apres demain weather information
        if (condition.equals("apresdemain")) {
            weather = "Après demain il fera : " + dayAfterTomorrow + " à Paris (Resultat fournis en anglais par Yahoo) ";
        }
        return weather;
    }

}
