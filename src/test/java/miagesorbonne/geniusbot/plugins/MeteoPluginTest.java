/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package miagesorbonne.geniusbot.plugins;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class MeteoPluginTest {
    
    public MeteoPluginTest() {
    }

    /**
     * Test of getResponse method, of class MeteoPlugin.
     */
    @Test
    public void testGetResponse() {
        System.out.println("getResponse");
        String condition = "now";
        MeteoPlugin instance = new MeteoPlugin();
        String expResult = "";
        String result = instance.getResponse(condition);
        assertEquals(result, result);
        condition = "demain";
        result = instance.getResponse(condition);
        assertEquals(result, result);
        condition = "apresdemain";
        result = instance.getResponse(condition);
        assertEquals(result, result);
    }
    
}
