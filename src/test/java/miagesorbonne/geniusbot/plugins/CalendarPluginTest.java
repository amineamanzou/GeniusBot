package miagesorbonne.geniusbot.plugins;

import java.util.Calendar;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit Test for Calendar Plugin
 *
 * @author Alexandre Le Boucher <alex.leboucher.inef@gmail.com>
 * @author Shinthujan Sivakumar <shinthujan.sivakumar@gmail.com>
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class CalendarPluginTest {
    
    public CalendarPluginTest() {
    }

    /**
     * Test of listCal method, of class CalendarPlugin.
     */
    @Test
    public void testListCal() {
        System.out.println("listCal");
        CalendarPlugin instance = new CalendarPlugin();
        instance.listCal();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of read method, of class CalendarPlugin.
     */
    @Test
    public void testRead() {
        System.out.println("read");
        CalendarPlugin instance = new CalendarPlugin();
        instance.read();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAnswer method, of class CalendarPlugin.
     */
    @Test
    public void testGetAnswer() {
        System.out.println("getAnswer");
        String question = "";
        CalendarPlugin instance = new CalendarPlugin();
        String expResult = "";
        String result = instance.getAnswer(question);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDateWithoutTime method, of class CalendarPlugin.
     */
    @Test
    public void testGetDateWithoutTime() {
        System.out.println("getDateWithoutTime");
        Date date = null;
        Date expResult = null;
        Date result = CalendarPlugin.getDateWithoutTime(date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProgrammeJournee method, of class CalendarPlugin.
     */
    @Test
    public void testGetProgrammeJournee() {
        System.out.println("getProgrammeJournee");
        String empty = " ";
        CalendarPlugin instance = new CalendarPlugin();
        String expResult = "";
        String result = instance.getProgrammeJournee(empty);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProgrammeSemaine method, of class CalendarPlugin.
     */
    @Test
    public void testGetProgrammeSemaine() {
        System.out.println("getProgrammeSemaine");
        String empty = " ";
        CalendarPlugin instance = new CalendarPlugin();
        String expResult = "";
        String result = instance.getProgrammeSemaine(empty);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nextWeek method, of class CalendarPlugin.
     */
    @Test
    public void testNextWeek() {
        System.out.println("nextWeek");
        CalendarPlugin instance = new CalendarPlugin();
        Calendar expResult = null;
        Calendar result = instance.nextWeek();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNextMeeting method, of class CalendarPlugin.
     */
    @Test
    public void testGetNextMeeting() {
        System.out.println("getNextMeeting");
        String name = "";
        CalendarPlugin instance = new CalendarPlugin();
        String expResult = "";
        String result = instance.getNextMeeting(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRDV method, of class CalendarPlugin.
     */
    @Test
    public void testSetRDV() {
        System.out.println("setRDV");
        String message = "";
        CalendarPlugin instance = new CalendarPlugin();
        String expResult = "";
        String result = instance.setRDV(message);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHours method, of class CalendarPlugin.
     */
    @Test
    public void testGetHours() {
        System.out.println("getHours");
        String empty = " ";
        CalendarPlugin instance = new CalendarPlugin();
        String expResult = "";
        String result = instance.getHours(empty);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNextRDV method, of class CalendarPlugin.
     */
    @Test
    public void testGetNextRDV() {
        System.out.println("getNextRDV");
        String empty = " ";
        CalendarPlugin instance = new CalendarPlugin();
        String expResult = "";
        String result = instance.getNextRDV(empty);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
