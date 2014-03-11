/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package miagesorbonne.geniusbot.entity;

import java.util.ArrayList;
import junit.framework.TestCase;
import org.junit.Test;

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
    @Test
    public void testGetId() {
        System.out.println("getId");
        Step instance = new Step("1",null,null);
        String expResult = "1";
        String result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Step.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        String id = "2";
        Step instance = new Step("1",null,null);
        instance.setId(id);
        assertEquals(instance.getId(),id);
    }

    /**
     * Test of getKeywords method, of class Step.
     */
    @Test
    public void testGetKeywords() {
        System.out.println("getKeywords");
        String expResult = "Keyword";
        ArrayList<String> keywords = new ArrayList(1);
        keywords.add(expResult);
        Step instance = new Step("1",keywords,null);
        ArrayList<String> result = instance.getKeywords();
        assertEquals(expResult, result.get(0));
    }

    /**
     * Test of setKeywords method, of class Step.
     */
    @Test
    public void testSetKeywords() {
        System.out.println("setKeywords");
        String expResult = "Keyword";
        ArrayList<String> keywords = new ArrayList(1);
        keywords.add(expResult);
        Step instance = new Step("1",null,null);
        instance.setKeywords(keywords);
        assertEquals(expResult,instance.getKeywords().get(0));
    }

    /**
     * Test of getMessages method, of class Step.
     */
    @Test
    public void testGetMessages() {
        System.out.println("getMessages");
        String expResult = "Message";
        ArrayList<String> messages = new ArrayList(1);
        messages.add(expResult);
        Step instance = new Step("1",null,messages);
        ArrayList<String> result = instance.getMessages();
        assertEquals(expResult, result.get(0));
    }

    /**
     * Test of setMessages method, of class Step.
     */
    @Test
    public void testSetMessages() {
        System.out.println("setMessages");
        String expResult = "Message";
        ArrayList<String> messages = new ArrayList(1);
        messages.add(expResult);
        Step instance = new Step("1",null,null);
        instance.setMessages(messages);
        assertEquals(expResult,instance.getMessages().get(0));
    }
    
}
