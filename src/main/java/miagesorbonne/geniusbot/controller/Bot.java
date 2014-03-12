package miagesorbonne.geniusbot.controller;

/**
 * Entity Class that will manage Bot actions
 * 
 * @author Alexandre Le Boucher <alex.leboucher.inef@gmail.com>
 * @author Shinthujan Sivakumar <shinthujan.sivakumar@gmail.com>
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class Bot {
    
    // Default Bot Situation
    Integer id;
    String step = "0";
    
    /**
     * Default constructor
     * 
     * @param step
     */
    public Bot(String step){
        this.step = step;
    }

    /**
     * Get ths of the bot
     * @return id
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
     * @return step
     */
    public String getStep() {
        return step;
    }
    
    /**
     * Set current step of the bot
     * @param step 
     */
    public void setStep(String step) {
        this.step = step;
    }
      
}
