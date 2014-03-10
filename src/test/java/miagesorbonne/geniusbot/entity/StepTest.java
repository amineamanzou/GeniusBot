/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package miagesorbonne.geniusbot.entity;

import java.util.ArrayList;
import junit.framework.TestCase;

/**
 * Unit Test for Step class
 * 
 * @author Shinthujan Sivakumar <shinthujan.sivakumar@gmail.com>
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class StepTest extends TestCase {
    
    public StepTest(String testName) {
        super(testName);
    }

    /**
     * Test of getId method, of class Step.
     */
    public void testGetId() {
        System.out.println("getId");
        Step instance = null;
        String expResult = "";
        String result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Step.
     */
    public void testSetId() {
        System.out.println("setId");
        String id = "";
        Step instance = null;
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getKeywords method, of class Step.
     */
    public void testGetKeywords() {
        System.out.println("getKeywords");
        Step instance = null;
        ArrayList expResult = null;
        ArrayList result = instance.getKeywords();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setKeywords method, of class Step.
     */
    public void testSetKeywords() {
        System.out.println("setKeywords");
        ArrayList keywords = null;
        Step instance = null;
        instance.setKeywords(keywords);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMessages method, of class Step.
     */
    public void testGetMessages() {
        System.out.println("getMessages");
        Step instance = null;
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getMessages();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMessages method, of class Step.
     */
    public void testSetMessages() {
        System.out.println("setMessages");
        ArrayList<String> messages = null;
        Step instance = null;
        instance.setMessages(messages);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
