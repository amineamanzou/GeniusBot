package miagesorbonne.geniusbot.entity;

/**
 * A keyword is a possible answer from the user to be parsed
 * 
 * @author Alexandre Le Boucher <alex.leboucher.inef@gmail.com>
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
    // If there is a className we need a method to call
    public String method = "";
    // If there is the a variable : [name]
    public String variable = "";
    // The value if the name of the variable is set
    public String variableValue = " ";
    // If the method doesn't need a variable but a static string defined in the XML
    public String defaultArg = "empty";
    // If the Step could learn something to the automate
    public String learn = "";
    
    // Setting point to define the best match
    public int points;
    
    /**
     * Default constructor
     * 
     * @param keyword
     * @param target
     * @param className
     * @param method
     * @param points
     * @param learn
     * @param variable
     * @param defaultArg
     */
    public Keyword(String keyword, String target, String className, String variable, String method, int points, String learn, String defaultArg) {
        this.id = keyword;
        this.keyword = keyword;
        this.target = target;
        this.className = className;
        this.variable = variable;
        this.method = method;
        this.learn = learn;
        this.points = points;
        this.defaultArg = defaultArg;
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
