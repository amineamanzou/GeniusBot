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
        System.out.println("DEBUT");
        CalendarPlugin test = new CalendarPlugin();
        test.read();
        System.out.println("FIN");
        test.listCal();
        System.out.println(test.getProgrammeJournee());
        System.out.println(test.getHours());
    }
}