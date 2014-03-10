/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package miagesorbonne.geniusbot.entity;

import miagesorbonne.geniusbot.controller.Parser;
import junit.framework.TestCase;

/**
 * Unit Test for the Parser
 * 
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
    public void testGetInvalidAnswer() {
        System.out.println("getInvalidAnswer");
        Parser instance = new Parser();
        String expResult = "";
        String result = instance.getInvalidAnswer();
        System.out.println(result);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
