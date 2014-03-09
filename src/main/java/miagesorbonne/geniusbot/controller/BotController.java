/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package miagesorbonne.geniusbot.controller;

import helpers.Regex;
import java.util.HashMap;
import java.util.Map;
import miagesorbonne.geniusbot.entity.Step;

/**
 *
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class BotController {
    
    // Store all regular expression matches
    private HashMap<String,String> regex;
    
    // The used parser to read config.xml
    Bot bot;
    Parser parser;
    
    /**
     * Default constructor
     * @param bot
     * @param parser
     */
    public BotController(Bot bot,Parser parser){
        this.bot = bot;
        this.parser = parser;
        regex = new HashMap<String,String>();
    }
    
    /**
     * Get current Step message
     * @return Messages
     */
    public String getMessage() {
        Step step = parser.getStep(bot.getStep());
        return replaceMatches(step.getMessage()).trim();
    }
    
    /**
     * Get the associated parser to fetch data
     * @return 
     */
    public Parser getParser() {
        return parser;
    }

    /**
     * Set the parser that will fetch data
     * @param parser 
     */
    public void setParser(Parser parser) {
        this.parser = parser;
    }
    
    /**
     * Method that replace a given text with variables in regex
     * @param text
     * @return 
     */
    public String replaceMatches(String text){
        // replace variables within dictionary in the text
        for (Map.Entry<String, String> entry : regex.entrySet()) {
            text = text.replaceAll("\\["+entry.getKey() + "\\]", entry.getValue());
        }

        // remove non used variables tags
        return Regex.clear(text);
    }
}
