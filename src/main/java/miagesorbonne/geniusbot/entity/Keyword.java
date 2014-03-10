package miagesorbonne.geniusbot.entity;

/**
 * A keyword is a possible answer from the user to be parsed
 * 
 * @author Shinthujan Sivakumar <shinthujan.sivakumar@gmail.com>
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class Keyword implements Entity {

    public String id = "";
    public String keyword = "";
    // The target step on the config xml
    public String target = "";
   
    // If it's with a plugin the classname to load
    public String className = "";
    // If there is an argument with this class
    public String arg = "";
    // If there is the a variable : [name]
    public String variable = "";
    // The value if the name of the variable is set
    public String variableValue = "";
    // If the Step could learn something to the automate
    public String learn = "";
    
    public int points = 0;

    /**
     * Default constructor
     * 
     * @param keyword
     * @param target
     * @param className
     * @param arg
     * @param variable
     */
    public Keyword(String keyword, String target, String className, String arg, String variable, int points, String learn) {
        this.id = keyword;
        this.keyword = keyword;
        this.target = target;
        this.className = className;
        this.arg = arg;
        this.variable = variable;
        this.points = points;
        this.learn = learn;
    }

    /**
     * Get the id of the keyword
     * @return id 
     */
    public String getId() {
        return id;
    }

    /**
     * Set the id of the current keyword
     * @param id 
     */
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return keyword ;
    }
    
}
