package miagesorbonne.geniusbot.plugins;

import java.util.ArrayList;
import java.util.Calendar;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit Test for Calendar Entity
 *
 * @author Alexandre Le Boucher <alex.leboucher.inef@gmail.com>
 * @author Shinthujan Sivakumar <shinthujan.sivakumar@gmail.com>
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class CalendarsTest {
    
    public CalendarsTest() {
    }

    /**
     * Test of toString method, of class Calendars.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Calendars instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTitre method, of class Calendars.
     */
    @Test
    public void testGetTitre() {
        System.out.println("getTitre");
        Calendars instance = null;
        String expResult = "";
        String result = instance.getTitre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getParticipants method, of class Calendars.
     */
    @Test
    public void testGetParticipants() {
        System.out.println("getParticipants");
        Calendars instance = null;
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getParticipants();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLieu method, of class Calendars.
     */
    @Test
    public void testGetLieu() {
        System.out.println("getLieu");
        Calendars instance = null;
        String expResult = "";
        String result = instance.getLieu();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDebut method, of class Calendars.
     */
    @Test
    public void testGetDebut() {
        System.out.println("getDebut");
        Calendars instance = null;
        Calendar expResult = null;
        Calendar result = instance.getDebut();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFin method, of class Calendars.
     */
    @Test
    public void testGetFin() {
        System.out.println("getFin");
        Calendars instance = null;
        Calendar expResult = null;
        Calendar result = instance.getFin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDate method, of class Calendars.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        Calendars instance = null;
        String expResult = "";
        String result = instance.getDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHeureDeb method, of class Calendars.
     */
    @Test
    public void testGetHeureDeb() {
        System.out.println("getHeureDeb");
        Calendars instance = null;
        String expResult = "";
        String result = instance.getHeureDeb();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHeureFin method, of class Calendars.
     */
    @Test
    public void testGetHeureFin() {
        System.out.println("getHeureFin");
        Calendars instance = null;
        String expResult = "";
        String result = instance.getHeureFin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hours method, of class Calendars.
     */
    @Test
    public void testHours() {
        System.out.println("hours");
        Calendar cal = null;
        Calendars instance = null;
        String expResult = "";
        String result = instance.hours(cal);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of days method, of class Calendars.
     */
    @Test
    public void testDays() {
        System.out.println("days");
        Calendar cal = null;
        Calendars instance = null;
        String expResult = "";
        String result = instance.days(cal);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
