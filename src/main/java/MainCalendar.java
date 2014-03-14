import miagesorbonne.geniusbot.plugins.CalendarPlugin;

/**
 * Main Calendar Class that demonstrate the functions of the plugin Calendar
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
        System.out.println("\nQuestion prochain rencontre : \n" + test.getNextMeeting("Test"));
        System.out.println("\nQuestion programme semaine : \n" + test.getProgrammeSemaine());
        System.out.println("\nPrendre RDV : \n" + test.setRDV("Prend rendez-vous avec Michel Durand lundi à 18h à Paris"));
    }
}