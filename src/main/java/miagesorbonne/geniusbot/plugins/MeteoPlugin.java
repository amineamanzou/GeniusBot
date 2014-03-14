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
            weather = "Aujourd'hui il fait : " + now + " (Resultat fournis en anglais par Yahoo) ";
        }

        // Condition : demain weather information
        if (condition.equals("demain")) {
            weather = "Je suppose que demain il fera : " + tomorrow + " (Resultat fournis en anglais par Yahoo) ";
        }

        // Condition : apres demain weather information
        if (condition.equals("apresdemain")) {
            weather = "Après demain il fera : " + dayAfterTomorrow + " (Resultat fournis en anglais par Yahoo) ";
        }
        return weather;
    }

}
