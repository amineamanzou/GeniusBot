/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miagesorbonne.geniusbot.controller;

import helpers.Regex;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import miagesorbonne.geniusbot.entity.Keyword;
import miagesorbonne.geniusbot.entity.Step;
import miagesorbonne.geniusbot.plugins.CalendarPlugin;

/**
 * Controlle the Entity and handle the software intelligence between model and
 * view layer of the application
 *
 * @author Alexandre Le Boucher <alex.leboucher.inef@gmail.com>
 * @author Shinthujan Sivakumar <shinthujan.sivakumar@gmail.com>
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class BotController {

    // Store all regular expression matches
    private HashMap<String, String> regex;

    // The used parser to read config.xml
    Bot bot;
    Parser parser;

    /**
     * Default constructor
     *
     * @param bot
     * @param parser
     */
    public BotController(Bot bot, Parser parser) {
        this.bot = bot;
        this.parser = parser;
        regex = new HashMap<String, String>();
    }

    /**
     * Get current Step message
     *
     * @return Messages
     */
    public String getMessage() {
        Step step = parser.getStep(bot.getStep());
        return replaceMatches(step.getMessage()).trim();
    }

    /**
     * Get the associated parser to fetch data
     *
     * @return
     */
    public Parser getParser() {
        return parser;
    }

    /**
     * Set the parser that will fetch data
     *
     * @param parser
     */
    public void setParser(Parser parser) {
        this.parser = parser;
    }

    /**
     * Method that replace a given text with variables in regex
     *
     * @param text
     * @return
     */
    public String replaceMatches(String text) {
        // Replacing variables by dictionary in the text
        for (Map.Entry<String, String> entry : regex.entrySet()) {
            text = text.replaceAll("\\[" + entry.getKey() + "\\]", entry.getValue());
        }

        // Removing non used tags variables
        return Regex.clear(text);
    }

    /**
     * Method which get the answer with the user message
     *
     * @param message
     * @return
     */
    public String send(String message) {

        String answer = "";
        Step step = parser.getStep(bot.step);

        if (step.getKeywords().isEmpty()) {
            bot.step = "1";
        }

        // Assciate the keyword with the given message
        Keyword match = parse(message, step.getKeywords());

        // If no one was matched : give invalid answer
        if (match == null) {
            answer = parser.getInvalidAnswer();
        } else {
           
            if (match.className.length() > 0) {
                if (match.className.equals("Calendar")) {
                    CalendarPlugin calendarPlugin = new CalendarPlugin();
                    answer = calendarPlugin.getAnswer(match.arg);
                    bot.step = "1";
                }
            } else {
                // Getting the new step and return the new answer
                if (answer.length() == 0) {
                    bot.step = match.target;
                    step = parser.getStep(bot.step);

                    // If it's the last step of a situation
                    if (step.getKeywords().isEmpty()) {
                        answer = this.getMessage();
                        bot.step = "1";
                    }
                }
            }

        }
        return answer;
    }

    /**
     * Method which parse a message to find match in the keywords
     *
     * @param message
     * @param keywordList
     * @return
     */
    private Keyword parse(String message, ArrayList<Keyword> keywordList) {
        int bestMatch = -1;
        Keyword match = null;

        for (int i = 0; i < keywordList.size(); i++) {
            int matches = getMatch(message, keywordList.get(i));

            if (matches > -1 && matches > bestMatch) {
                match = keywordList.get(i);
                bestMatch = matches;
            }
        }

        if (match != null) {
            if (match.variableValue.length() > 0) {
                regex.put(match.variable, match.variableValue);
            }

        }

        return match;
    }

    /**
     * Method which give the number of match
     *
     * @param text
     * @param keyword
     * @return
     */
    private int getMatch(String text, Keyword keyword) {
        int result = -1;

        if (keyword.keyword.equals("*")) {
            return keyword.points;
        }

        if (keyword.variable.length() > 0) {
            String match = Regex.match(keyword.keyword, text);
            if (match.length() > 0) {
                keyword.variableValue = match;
                return keyword.points;
            }
        }

        String[] word = keyword.keyword.split(" ");

        for (String key : word) {
            if (text.toLowerCase().indexOf(key.toLowerCase()) >= 0) {
                result = result + keyword.points + 1;
            } else {
                return -1;
            }
        }
        return result;
    }
}
