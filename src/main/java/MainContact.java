import miagesorbonne.geniusbot.plugins.ContactPlugin;

/**
 * Main Contact Class that demonstrate the functions of the plugin Contact
 * 
 * @author Alexandre Le Boucher <alex.leboucher.inef@gmail.com>
 * @author Shinthujan Sivakumar <shinthujan.sivakumar@gmail.com>
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class MainContact {

    /**
     * Main Method
     * 
     * @param args 
     */
    public static void main(String[] args) {
        System.out.println("DEBUT");
        ContactPlugin test = new ContactPlugin();
        test.read();
        System.out.println("FIN");
        test.listContact();
        System.out.println(test.knowsHim("Amine"));
        System.out.println(test.knowsHim("Alexandre Le Boucher"));
        System.out.println(test.exists("Amine"));
        System.out.println(test.exists("Alexandre Le Boucher"));
        System.out.println(test.whereLeaves("Alexandre Le Boucher"));
        System.out.println(test.allAboutHim("Alexandre Le Boucher"));
        
        System.out.println(test.information("Amine Amanzou", "all"));
        System.out.println(test.information("Amine Amanzou", "surnom"));
        
    }
}