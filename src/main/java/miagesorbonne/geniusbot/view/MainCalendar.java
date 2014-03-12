package miagesorbonne.geniusbot.view;

import miagesorbonne.geniusbot.plugins.calendar.CalendarPlugin;

public class MainCalendar {

    public static void main(String[] args) {
        System.out.println("DEBUT");
        CalendarPlugin test = new CalendarPlugin();
        test.read();
        System.out.println("FIN");
        test.test();
    }
}