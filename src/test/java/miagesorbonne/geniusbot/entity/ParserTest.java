/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package miagesorbonne.geniusbot.entity;

import miagesorbonne.geniusbot.controller.Parser;
import junit.framework.TestCase;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 * JUnit Test for the Parser
 * 
 * @author Alexandre Le Boucher <alex.leboucher.inef@gmail.com>
 * @author Shinthujan Sivakumar <shinthujan.sivakumar@gmail.com>
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class ParserTest extends TestCase {
    
    public ParserTest(String testName) {
        super(testName);
    }

    /**
     * Test of getInvalidAnswer method, of class Parser.
     */
    @Test
    public void testGetInvalidAnswer() {
        System.out.println("getInvalidAnswer");
        Parser instance = new Parser();
        String expResult = "Oups, je n'ai pas compris.";
        String result = instance.getInvalidAnswer();
        //System.out.println(result);
        assertEquals(expResult, result);
    }
      
    /**
     * Test of getStep method, of class Parser.
     */
    @Test
    public void testGetStep() {
        System.out.println("getStep");
        Parser instance = new Parser();
        assertEquals("0", instance.getStep("0").getId());
    } 
    
}
