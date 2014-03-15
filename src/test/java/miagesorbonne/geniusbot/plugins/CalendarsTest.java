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
     * Test of getTitre method, of class Calendars.
     */
    @Test
    public void testGetTitre() {
        System.out.println("getTitre");
        Calendars instance = new Calendars();
        instance.setTitre("testTitre");
        String expResult = "testTitre";
        String result = instance.getTitre();
        assertEquals(expResult, result);
    }

    /**
     * Test of getParticipants method, of class Calendars.
     */
    @Test
    public void testGetParticipants() {
        System.out.println("getParticipants");
        Calendars instance = new Calendars();
        ArrayList<String> expResult = new ArrayList<String>();
        expResult.add("p1");
        expResult.add("p2");
        instance.setParticipants(expResult);
        ArrayList<String> result = instance.getParticipants();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLieu method, of class Calendars.
     */
    @Test
    public void testGetLieu() {
        System.out.println("getLieu");
        Calendars instance = new Calendars();
        instance.setLieu("testPlace");
        String expResult = "testPlace";
        String result = instance.getLieu();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDebut method, of class Calendars.
     */
    @Test
    public void testGetDebut() {
        System.out.println("getDebut");
        Calendars instance = new Calendars();
        Calendar expResult = Calendar.getInstance();
        instance.setDebut(expResult);
        Calendar result = instance.getDebut();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFin method, of class Calendars.
     */
    @Test
    public void testGetFin() {
        System.out.println("getFin");
        Calendars instance = new Calendars();
        Calendar expResult = Calendar.getInstance();
        instance.setFin(expResult);
        Calendar result = instance.getFin();
        assertEquals(expResult, result);
    }
}
