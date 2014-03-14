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
     * Test of listContact method, of class ContactPlugin.
     */
    @Test
    public void testListContact() {
        System.out.println("listContact");
        ContactPlugin instance = new ContactPlugin();
        instance.listContact();
        
    }

    /**
     * Test of read method, of class ContactPlugin.
     */
    @Test
    public void testRead() {
        System.out.println("read");
        ContactPlugin instance = new ContactPlugin();
        instance.read();
        
    }

    /**
     * Test of exists method, of class ContactPlugin.
     */
    @Test
    public void testExists() {
        System.out.println("exists");
        String name = "alexandre leboucher";
        ContactPlugin instance = new ContactPlugin();
        Boolean expResult = true;
        Boolean result = instance.exists(name);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of knowsHim method, of class ContactPlugin.
     */
    @Test
    public void testKnowsHim() {
        System.out.println("knowsHim");
        String name = "alexandre leboucher";
        ContactPlugin instance = new ContactPlugin();
        String expResult = "Oui nous avons dans notre répertoire : \nalexandre leboucher";
        String result = instance.knowsHim(name);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of whereLeaves method, of class ContactPlugin.
     */
    @Test
    public void testWhereLeaves() {
        System.out.println("whereLeaves");
        String name = "alexandre leboucher";
        ContactPlugin instance = new ContactPlugin();
        String expResult = "alexandre leboucher habite  marseille";
        String result = instance.whereLeaves(name);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of whenBorns method, of class ContactPlugin.
     */
    @Test
    public void testWhenBorns() {
        System.out.println("whenBorns");
        String name = "alexandre leboucher";
        ContactPlugin instance = new ContactPlugin();
        String expResult = "alexandre leboucher est né(e) le  18/01/1992";
        String result = instance.whenBorns(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of allAboutHim method, of class ContactPlugin.
     */
    @Test
    public void testAllAboutHim() {
        System.out.println("allAboutHim");
        String name = "alexandre leboucher";
        ContactPlugin instance = new ContactPlugin();
        String expResult = "Voici toutes les informations diponibles sur le contact alexandre leboucher : \n" +
"alexandre leboucher de sexe masculin né(e) le 18/01/1992 habite au marseille.\n" +
"Ses collègues aiment bien le surnommer Night Bitch.\n" +
"On peut le contacter aux adresses mails suivantes : [alex@gmail.com, alex.lbj@wanadoo.fr].\n" +
"Ainsi que sur ses numéros de telephone : [064681XXXX]";
        String result = instance.allAboutHim(name);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of whoLivesIn method, of class ContactPlugin.
     */
    @Test
    public void testWhoLivesIn() {
        System.out.println("whoLivesIn");
        String city = "paris";
        ContactPlugin instance = new ContactPlugin();
        String expResult = "sivakumar sinthujan vit bien à paris \n" +
"michel durant vit bien à paris \n";
        String result = instance.whoLivesIn(city);
        assertEquals(expResult, result);
    }

    /**
     * Test of whoHasMore method, of class ContactPlugin.
     */
    @Test
    public void testWhoHasMore() {
        System.out.println("whoHasMore");
        String age = "40";
        ContactPlugin instance = new ContactPlugin();
        String expResult = "alexandre leboucher a plus de 40 ans. \n" +
"michel durant a plus de 40 ans. \n";
        String result = instance.whoHasMore(age);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of phone method, of class ContactPlugin.
     */
    @Test
    public void testPhone() {
        System.out.println("phone");
        String name = "alexandre leboucher";
        ContactPlugin instance = new ContactPlugin();
        String expResult = "alexandre leboucherest disponible au(x) : [064681XXXX]";
        String result = instance.phone(name);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of mail method, of class ContactPlugin.
     */
    @Test
    public void testMail() {
        System.out.println("mail");
        String name = "alexandre leboucher";
        ContactPlugin instance = new ContactPlugin();
        String expResult = "alexandre leboucherest disponible au(x) : [alex@gmail.com, alex.lbj@wanadoo.fr]";
        String result = instance.mail(name);
        assertEquals(expResult, result);
        
    }
    
}
