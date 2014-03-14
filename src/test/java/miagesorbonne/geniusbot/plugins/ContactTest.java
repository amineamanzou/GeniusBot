package miagesorbonne.geniusbot.plugins;

import java.util.ArrayList;
import java.util.Arrays;
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
         ArrayList<String> mails = new ArrayList<String>();
         mails.add("alex.lbj@wanadoo.fr");
         ArrayList<String> telephones = new ArrayList<String>();
         telephones.add("0678764534");
        Contact instance = new Contact("alexandre leboucher", "18/01/1992", "masculin", "marseille", "Night Bitch",
             mails, telephones , "23");
        String expResult =
"alexandre leboucher de sexe masculin né(e) le 18/01/1992 habite au marseille.\n" +
"Ses collègues aiment bien le surnommer Night Bitch.\n" +
"On peut le contacter aux adresses mails suivantes : [alex.lbj@wanadoo.fr].\n" +
"Ainsi que sur ses numéros de telephone : [0678764534]";
        String result = instance.toString();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getNom method, of class Contact.
     */
    @Test
    public void testGetNom() {
        System.out.println("getNom");
         ArrayList<String> mails = new ArrayList<String>();
         mails.add("alex.lbj@wanadoo.fr");
         ArrayList<String> telephones = new ArrayList<String>();
         telephones.add("0678764534");
        Contact instance = new Contact("alexandre leboucher", "18/01/1992", "masculin", "marseille", "Night Bitch",
             mails, telephones , "23");
        String expResult = "alexandre leboucher";
        String result = instance.getNom();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getAge method, of class Contact.
     */
    @Test
    public void testGetAge() {
        System.out.println("getAge");
        ArrayList<String> mails = new ArrayList<String>();
         mails.add("alex.lbj@wanadoo.fr");
         ArrayList<String> telephones = new ArrayList<String>();
         telephones.add("0678764534");
        Contact instance = new Contact("alexandre leboucher", "18/01/1992", "masculin", "marseille", "Night Bitch",
             mails, telephones , "23");
        String expResult = "23";
        String result = instance.getAge();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getSurnom method, of class Contact.
     */
    @Test
    public void testGetSurnom() {
        System.out.println("getSurnom");
       ArrayList<String> mails = new ArrayList<String>();
         mails.add("alex.lbj@wanadoo.fr");
         ArrayList<String> telephones = new ArrayList<String>();
         telephones.add("0678764534");
        Contact instance = new Contact("alexandre leboucher", "18/01/1992", "masculin", "marseille", "Night Bitch",
             mails, telephones , "23");
        String expResult = "Night Bitch";
        String result = instance.getSurnom();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getAdresse method, of class Contact.
     */
    @Test
    public void testGetAdresse() {
        System.out.println("getAdresse");
        ArrayList<String> mails = new ArrayList<String>();
         mails.add("alex.lbj@wanadoo.fr");
         ArrayList<String> telephones = new ArrayList<String>();
         telephones.add("0678764534");
        Contact instance = new Contact("alexandre leboucher", "18/01/1992", "masculin", "marseille", "Night Bitch",
             mails, telephones , "23");
        String expResult = "marseille";
        String result = instance.getAdresse();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getNaissance method, of class Contact.
     */
    @Test
    public void testGetNaissance() {
        System.out.println("getNaissance");
        ArrayList<String> mails = new ArrayList<String>();
         mails.add("alex.lbj@wanadoo.fr");
         ArrayList<String> telephones = new ArrayList<String>();
         telephones.add("0678764534");
        Contact instance = new Contact("alexandre leboucher", "18/01/1992", "masculin", "marseille", "Night Bitch",
             mails, telephones , "23");
        String expResult = "18/01/1992";
        String result = instance.getNaissance();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getSexe method, of class Contact.
     */
    @Test
    public void testGetSexe() {
        System.out.println("getSexe");
        ArrayList<String> mails = new ArrayList<String>();
         mails.add("alex.lbj@wanadoo.fr");
         ArrayList<String> telephones = new ArrayList<String>();
         telephones.add("0678764534");
        Contact instance = new Contact("alexandre leboucher", "18/01/1992", "masculin", "marseille", "Night Bitch",
             mails, telephones , "23");
        String expResult = "masculin";
        String result = instance.getSexe();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getMails method, of class Contact.
     */
    @Test
    public void testGetMails() {
        System.out.println("getMails");
        ArrayList<String> mails = new ArrayList<String>();
         mails.add("alex.lbj@wanadoo.fr");
         ArrayList<String> telephones = new ArrayList<String>();
         telephones.add("0678764534");
        Contact instance = new Contact("alexandre leboucher", "18/01/1992", "masculin", "marseille", "Night Bitch",
             mails, telephones , "23");
        ArrayList<String> temp = new ArrayList<String>();
         temp.add("alex.lbj@wanadoo.fr");
        ArrayList<String> expResult = temp ;
        ArrayList<String> result = instance.getMails();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getTelephone method, of class Contact.
     */
    @Test
    public void testGetTelephone() {
        System.out.println("getTelephone");
         ArrayList<String> mails = new ArrayList<String>();
         mails.add("alex.lbj@wanadoo.fr");
         ArrayList<String> telephones = new ArrayList<String>();
         telephones.add("0678764534");
        Contact instance = new Contact("alexandre leboucher", "18/01/1992", "masculin", "marseille", "Night Bitch",
             mails, telephones , "23");
        ArrayList<String> temp = new ArrayList<String>();
         temp.add("0678764534");
        ArrayList<String> expResult = temp;
        ArrayList<String> result = instance.getTelephone();
        assertEquals(expResult, result);
        
    }
    
}
