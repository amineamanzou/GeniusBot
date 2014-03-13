package miagesorbonne.geniusbot.controller;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit Test for Bot Class
 * 
 * @author Alexandre Le Boucher <alex.leboucher.inef@gmail.com>
 * @author Shinthujan Sivakumar <shinthujan.sivakumar@gmail.com>
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class BotTest {
    
    public BotTest() {
    }

    /**
     * Test of getStep method, of class Bot.
     */
    @Test
    public void testGetStep() {
        System.out.println("getStep");
        Bot instance = new Bot("0");
        String expResult = "0";
        String result = instance.getStep();
        assertEquals(expResult, result);
    }

    /**
     * Test of setStep method, of class Bot.
     */
    @Test
    public void testSetStep() {
        System.out.println("setStep");
        String step = "3";
        Bot instance = new Bot("0");
        instance.setStep(step);
        assertEquals(step, instance.step);
    }
    
}
