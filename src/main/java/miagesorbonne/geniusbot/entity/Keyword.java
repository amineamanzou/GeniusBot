/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package miagesorbonne.geniusbot.entity;

/**
 *
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class Keyword implements Entity {

    public String id;
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

    /**
     * Default constructor
     * 
     * @param keyword
     * @param target
     * @param className
     * @param arg
     * @param variable
     * @param points 
     */
    public Keyword(String keyword, String target, String className, String arg, String variable) {
        this.keyword = keyword;
        this.target = target;
        this.className = className;
        this.arg = arg;
        this.variable = variable;
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
    
}
