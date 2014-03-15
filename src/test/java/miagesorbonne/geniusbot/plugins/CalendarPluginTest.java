package miagesorbonne.geniusbot.plugins;

import java.text.SimpleDateFormat;
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
     * Test of getAnswer method, of class CalendarPlugin.
     */
    @Test
    public void testGetAnswer() {
        System.out.println("getAnswer");
        String question = "journee";
        CalendarPlugin instance = new CalendarPlugin();
        String expResult = "Test";
        String result = instance.getAnswer(question);
        assertEquals(expResult, result);
    }

    /**
     * Test of getProgrammeJournee method, of class CalendarPlugin.
     */
    @Test
    public void testGetProgrammeJournee() {
        System.out.println("getProgrammeJournee");
        String msg = "";
        CalendarPlugin instance = new CalendarPlugin();
        String expResult = "Vous n'avez pas de programme aujourd'hui !";
        String result = instance.getProgrammeJournee(msg);
        assertEquals(expResult, result);
    }

    /**
     * Test of getNextMeeting method, of class CalendarPlugin.
     */
    @Test
    public void testGetNextMeeting() {
        System.out.println("getNextMeeting");
        String name = "";
        CalendarPlugin instance = new CalendarPlugin();
        String expResult = "Vous n'avez pas de rendez-vous avec  !";
        String result = instance.getNextMeeting(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of getHours method, of class CalendarPlugin.
     */
    @Test
    public void testGetHours() {
        System.out.println("getHours");
        String msg = "";
        CalendarPlugin instance = new CalendarPlugin();
        String expResult = "";
        SimpleDateFormat date = new SimpleDateFormat("HH:mm:ss");
        expResult = date.format(new Date());
        String result = instance.getHours(msg);
        assertEquals(expResult, result);
    }

    /**
     * Test of getNextRDV method, of class CalendarPlugin.
     */
    @Test
    public void testGetNextRDV() {
        System.out.println("getNextRDV");
        String msg = "";
        CalendarPlugin instance = new CalendarPlugin();
        String expResult = "Votre prochain rendez vous aura lieu le 16/3/2014 de 14:00 à 16:00";
        String result = instance.getNextRDV(msg);
        assertEquals(expResult, result);
    }

    /**
     * Test of setRDVTitre method, of class CalendarPlugin.
     */
    @Test
    public void testSetRDVTitre() {
        System.out.println("setRDVTitre");
        String titre = "Title";
        CalendarPlugin instance = new CalendarPlugin();
        String expResult = "Le titre à été ajouté !";
        String result = instance.setRDVTitre(titre);
        assertEquals(expResult, result);
    }

    /**
     * Test of setRDVDate method, of class CalendarPlugin.
     */
    @Test
    public void testSetRDVDate() {
        System.out.println("setRDVDate");
        String message = "04/10/2014 de 4:00 a 5:00";
        CalendarPlugin instance = new CalendarPlugin();
        String expResult = "La date et les heures ont bien été pris en compte !";
        String result = instance.setRDVDate(message);
        assertEquals(expResult, result);
    }

    /**
     * Test of setRDVParticipant method, of class CalendarPlugin.
     */
    @Test
    public void testSetRDVParticipant() {
        System.out.println("setRDVParticipant");
        String message = "";
        CalendarPlugin instance = new CalendarPlugin();
        String expResult = "Le participant à été ajouté !";
        String result = instance.setRDVParticipant(message);
        assertEquals(expResult, result);
    }

    /**
     * Test of setRDVLieu method, of class CalendarPlugin.
     */
    @Test
    public void testSetRDVLieu() {
        System.out.println("setRDVLieu");
        String lieu = "Paris";
        CalendarPlugin instance = new CalendarPlugin();
        String expResult = "Le lieu à été ajouté !";
        String result = instance.setRDVLieu(lieu);
        assertEquals(expResult, result);
    }
    
}
