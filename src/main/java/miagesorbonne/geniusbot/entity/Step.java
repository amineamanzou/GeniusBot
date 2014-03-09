package miagesorbonne.geniusbot.entity;

import java.util.ArrayList;
import java.util.Random;

/**
 * A step is a state where the automate will be 
 * depending on configs. 
 * It's a situation or a part of a situation 
 * (use case)
 * 
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class Step implements Entity {
    
    private String id = "";
    private ArrayList keywords;
    private ArrayList<String> messages;
    
    /**
     * Default Constructor
     * 
     * @param id
     * @param keywords
     * @param messages 
     */
    public Step(String id, ArrayList keywords, ArrayList messages){
        this.id = id;
        this.keywords = keywords;
        this.messages = messages;
    }

    /**
     * Get the id of the step
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Set the id
     * @param id 
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get the keywords to match in this step
     * @return 
     */
    public ArrayList getKeywords() {
        return keywords;
    }

    /**
     * Set the keywords to match in this step
     * @param keywords 
     */
    public void setKeywords(ArrayList keywords) {
        this.keywords = keywords;
    }

    /**
     * Get the messages to answer in this step
     * @return 
     */
    public ArrayList<String> getMessages() {
        return messages;
    }
    
    /**
     * Get a Random message of the current step
     * @return message
     */
    public String getMessage() {
        Random gen = new Random();
        return "Bonjour Bonjour ... Je suis encore en cour de construction";//messages.get(gen.nextInt(messages.size()));
    }
    
    /**
     * Set the messages to answer in this step
     * @param messages 
     */
    public void setMessages(ArrayList<String> messages) {
        this.messages = messages;
    }
    
}
