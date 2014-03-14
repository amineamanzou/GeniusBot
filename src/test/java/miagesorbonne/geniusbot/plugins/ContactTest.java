package miagesorbonne.geniusbot.plugins;

import java.util.ArrayList;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit Test for Contact Entity
 *
 * @author Alexandre Le Boucher <alex.leboucher.inef@gmail.com>
 * @author Shinthujan Sivakumar <shinthujan.sivakumar@gmail.com>
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class ContactTest {
    
    public ContactTest() {
    }

    /**
     * Test of toString method, of class Contact.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Contact instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNom method, of class Contact.
     */
    @Test
    public void testGetNom() {
        System.out.println("getNom");
        Contact instance = null;
        String expResult = "";
        String result = instance.getNom();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSurnom method, of class Contact.
     */
    @Test
    public void testGetSurnom() {
        System.out.println("getSurnom");
        Contact instance = null;
        String expResult = "";
        String result = instance.getSurnom();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAdresse method, of class Contact.
     */
    @Test
    public void testGetAdresse() {
        System.out.println("getAdresse");
        Contact instance = null;
        String expResult = "";
        String result = instance.getAdresse();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNaissance method, of class Contact.
     */
    @Test
    public void testGetNaissance() {
        System.out.println("getNaissance");
        Contact instance = null;
        Date expResult = null;
        Date result = instance.getNaissance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSexe method, of class Contact.
     */
    @Test
    public void testGetSexe() {
        System.out.println("getSexe");
        Contact instance = null;
        String expResult = "";
        String result = instance.getSexe();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMails method, of class Contact.
     */
    @Test
    public void testGetMails() {
        System.out.println("getMails");
        Contact instance = null;
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getMails();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTelephone method, of class Contact.
     */
    @Test
    public void testGetTelephone() {
        System.out.println("getTelephone");
        Contact instance = null;
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getTelephone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
