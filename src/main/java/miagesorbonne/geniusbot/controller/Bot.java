package miagesorbonne.geniusbot.controller;

/**
 * Entity Class that will manage Bot actions
 * 
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class Bot {
    
    // Default Bot Situation
    Integer id;
    String Step = "0";
    Parser parser;
    
    /**
     * Default constructor
     */
    public Bot(String Step, Parser parser){
        this.Step = Step;
        this.parser = parser;
    }

    /**
     * Get ths of the bot
     * @return 
     */
    public Integer getId(){
        return this.id;
    }
    
    /**
     * Set current id of the bot
     * @param id 
     */
    public void setId(Integer id){
        this.id = id;
    }
    
    /**
     * Get current step of the bot
     * @return 
     */
    public String getStep() {
        return Step;
    }
    
    /**
     * Set current step of the bot
     * @param Step 
     */
    public void setStep(String Step) {
        this.Step = Step;
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
      
}
