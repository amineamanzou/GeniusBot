package miagesorbonne.geniusbot.controller;

/**
 * Entity Class that will manage Bot actions
 * 
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class Bot {
    
    // Default Bot Situation
    Integer id;
    String step = "0";
    
    /**
     * Default constructor
     */
    public Bot(String step){
        this.step = step;
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
        return step;
    }
    
    /**
     * Set current step of the bot
     * @param Step 
     */
    public void setStep(String Step) {
        this.step = Step;
    }
      
}
