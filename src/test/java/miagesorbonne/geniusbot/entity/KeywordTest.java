package miagesorbonne.geniusbot.entity;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit Test for Keyword Entity
 * 
 * @author Alexandre Le Boucher <alex.leboucher.inef@gmail.com>
 * @author Shinthujan Sivakumar <shinthujan.sivakumar@gmail.com>
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class KeywordTest {
    
    public KeywordTest() {
    }

    /**
     * Test of getId method, of class Keyword.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Keyword instance = new Keyword("2", null, null, null, null, null, 3, null);
        String expResult = "2";
        String result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Keyword.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        String id = "4";
        Keyword instance = new Keyword("2", null, null, null, null, null, 3, null);
        instance.setId(id);
        String result = instance.getId();
        assertEquals(id, result);
    }
    
}
