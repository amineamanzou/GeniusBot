

import miagesorbonne.geniusbot.plugins.CalendarPlugin;

public class MainCalendar {

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