/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package miagesorbonne.geniusbot.controller;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit Test for the Bot Controller Class
 * 
 * @author Alexandre Le Boucher <alex.leboucher.inef@gmail.com>
 * @author Shinthujan Sivakumar <shinthujan.sivakumar@gmail.com>
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class BotControllerTest {
    Bot bot;
    Parser parser;
            
    public BotControllerTest() {
        bot = new Bot("0");
        parser = new Parser();
    }

    /**
     * Test of getMessage method, of class BotController.
     */
    @Test
    public void testGetMessage() {
        System.out.println("getMessage");
        BotController instance = new BotController(bot, parser);
        String expResult = "Salut, mon nom est Genius. Comment tu t'appelles ?";
        String result = instance.getMessage();
        assertEquals(expResult, result);
    }

    /**
     * Test of getParser method, of class BotController.
     */
    @Test
    public void testGetParser() {
        System.out.println("getParser");
        BotController instance = new BotController(bot, parser);
        Parser result = instance.getParser();
        assertEquals(parser, result);
    }

    /**
     * Test of setParser method, of class BotController.
     */
    @Test
    public void testSetParser() {
        System.out.println("setParser");
        BotController instance = new BotController(bot, null);
        instance.setParser(parser);
        assertEquals(parser, instance.parser);
    }

    /**
     * Test of send method, of class BotController.
     */
    @Test
    public void testSend() {
        System.out.println("send");
        String message = "Oups, je n'ai pas compris.";
        BotController instance = new BotController(new Bot("2"), parser);
        String result = instance.send(message);
        assertEquals(message, result);
    }
    
}
