/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alexandreleboucher
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
        String name = "alex";
        ContactPlugin instance = new ContactPlugin();
        String expResult = "ok";
        String result = instance.findByName(name);
        assertEquals(expResult, result);
        
    }
    
}
