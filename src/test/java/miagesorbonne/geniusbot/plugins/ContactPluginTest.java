package miagesorbonne.geniusbot.plugins;

import miagesorbonne.geniusbot.plugins.ContactPlugin;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit Test for Contact Plugin
 *
 * @author Alexandre Le Boucher <alex.leboucher.inef@gmail.com>
 * @author Shinthujan Sivakumar <shinthujan.sivakumar@gmail.com>
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class ContactPluginTest {
    
    public ContactPluginTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
* Test of findByName method, of class ContactPlugin.
*/
    @Test
    public void testFindByName() {
        System.out.println("findByName");
        String name = "Amine";
        ContactPlugin instance = new ContactPlugin();
        String expResult = "";
        String result = instance.findByName(name);
        assertEquals(expResult, result);
        
    }
    
}