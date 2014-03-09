package helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Regex helper give some methods to help parsing variable in the XML
 * 
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class Regex {

    /**
     * Match a pattern in a keyword entry in the file config
     * @param pattern
     * @param keyword
     * @return The matched String
     */
    public static String match(String pattern, String keyword){
        Pattern p = Pattern.compile(pattern.toLowerCase());
        Matcher m = p.matcher(keyword.toLowerCase());
        if (m.matches()) {
            return m.group(1);
        }
        return "";
    }

    /**
     * Clear the matcher
     * 
     * @param text
     * @return String
     */
    public static String clear(String text){
        Pattern pattern = Pattern.compile("\\[.*\\]");

        // Replace all occurrences of pattern in input
        Matcher matcher = pattern.matcher(text);
        return matcher.replaceAll("");
    }
    
}
