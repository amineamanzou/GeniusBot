import miagesorbonne.geniusbot.plugins.CalendarPlugin;

/**
 * Main Calendar Class that test the plugin Calendar
 * 
 * @author Alexandre Le Boucher <alex.leboucher.inef@gmail.com>
 * @author Shinthujan Sivakumar <shinthujan.sivakumar@gmail.com>
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class MainCalendar {

    /**
     * Main Method
     * 
     * @param args 
     */
    public static void main(String[] args) {
        System.out.println("Liste des evenements:\n");
        CalendarPlugin test = new CalendarPlugin();
        test.listCal();
        System.out.println("\nQuestion programme journée : \n" + test.getProgrammeJournee());
        System.out.println("Question heure : \n" + test.getHours());
        System.out.println("\nQuestion prochain RDV : \n" + test.getNextRDV());
    }
}