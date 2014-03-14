package miagesorbonne.geniusbot.plugins;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Calendar PLugin that add calendar functionnality to the bot
 *
 * @author Alexandre Le Boucher <alex.leboucher.inef@gmail.com>
 * @author Shinthujan Sivakumar <shinthujan.sivakumar@gmail.com>
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class CalendarPlugin {

    String csvFile = "./src/main/java/calendar.csv";
    BufferedReader br;
    String line = "";
    String splitBy = ";";
    String listSplit = "-";
    List<Calendars> listCal;

    /**
     * Main constructor of the plugin
     */
    public CalendarPlugin() {
        this.listCal = new ArrayList<Calendars>();
        read();
    }

    /**
     * Method that print the list of Calendar
     */
    public void listCal() {
        for (int i = 0; i < listCal.size(); i++) {
            System.out.println(listCal.get(i).toString());
        }
    }

    /**
     * Method that read the CSV
     */
    public void read() {
        try {
            br = new BufferedReader(new FileReader(csvFile));
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] cal = line.split(splitBy);

                int i = 0;

                String titre = cal[i++];
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                String d = cal[i++];
                Date date = null;

                try {
                    date = formatter.parse(d);
                } catch (ParseException ex) {
                    Logger.getLogger(CalendarPlugin.class.getName()).log(Level.SEVERE, null, ex);
                }

                formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                String h = d + " " + cal[i++];
                Date heureDeb = null;
                Calendar cDeb = Calendar.getInstance();

                try {
                    heureDeb = formatter.parse(h);
                    cDeb.setTime(heureDeb);
                } catch (ParseException ex) {
                    Logger.getLogger(CalendarPlugin.class.getName()).log(Level.SEVERE, null, ex);
                }

                h = d + " " + cal[i++];
                Date heureFin = null;
                Calendar cFin = Calendar.getInstance();

                try {
                    heureFin = formatter.parse(h);
                    cFin.setTime(heureFin);
                } catch (ParseException ex) {
                    Logger.getLogger(CalendarPlugin.class.getName()).log(Level.SEVERE, null, ex);
                }

                ArrayList<String> participants = new ArrayList<String>(Arrays.asList(cal[i++].split(listSplit)));
                String lieu = cal[i++];

                Calendars c = new Calendars(titre, cDeb, cFin, participants, lieu);
                listCal.add(c);
            }

        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                }
            }
        }
    }

    /**
     * Default Method linked to the bot for testing
     *
     * @param question
     * @return
     */
    public String getAnswer(String question) {
        String answer = "";
        if (question.equals("journee")) {
            answer = "Test";
        }
        return answer;
    }

    /**
     * Init the calendar
     *
     * @param targetDate
     * @return targetDate
     */
    private Calendar getCalendarWithoutTime(Calendar targetDate) {
        targetDate.set(Calendar.HOUR_OF_DAY, 0);
        targetDate.set(Calendar.MINUTE, 0);
        targetDate.set(Calendar.SECOND, 0);
        targetDate.set(Calendar.MILLISECOND, 0);

        return targetDate;
    }

    /**
     * Return the Date
     *
     * @param date
     * @return
     */
    public static Date getDateWithoutTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * Return the program of the day
     *
     * @return
     */
    public String getProgrammeJournee(String msg) {
        String answer = "";
        Calendar now = Calendar.getInstance();
        boolean prog = false;
        for (int i = 1; i < listCal.size(); i++) {
            Calendar d = (Calendar) listCal.get(i).getDebut().clone();
            if (getCalendarWithoutTime(d).equals(getCalendarWithoutTime(now))
                    && listCal.get(i).getDebut().after(Calendar.getInstance())) {
                prog = true;
                answer += "- " + listCal.get(i).getTitre() + " de " + listCal.get(i).getHeureDeb() + " à " + listCal.get(i).getHeureFin() + "\n";
            }
        }

        if (prog) {
            answer = "Votre programme de la journée est le suivant : \n" + answer;
        } else {
            answer = "Vous n'avez pas de programme aujourd'hui !";
        }

        return answer;
    }

    /**
     * Return the program of the week
     *
     * @return
     */
    public String getProgrammeSemaine(String msg) {
        String answer = "";

        List<Date> listDates = new ArrayList<Date>(25);
        Calendar cal = Calendar.getInstance();
        cal.setTime(Calendar.getInstance().getTime());
        listDates.add(Calendar.getInstance().getTime());
        while (cal.getTime().before(nextWeek().getTime())) {
            cal.add(Calendar.DATE, 1);
            listDates.add(cal.getTime());
        }

        boolean prog = false;
        for (int y = 0; y < listDates.size() - 1; y++) {
            for (int i = 1; i < listCal.size(); i++) {
                if (getDateWithoutTime(listCal.get(i).getDebut().getTime()).equals(getDateWithoutTime(listDates.get(y)))
                        && listCal.get(i).getDebut().after(Calendar.getInstance())) {
                    prog = true;
                    answer += "- " + listCal.get(i).getTitre() + " le " + listCal.get(i).getDate() + " de " + listCal.get(i).getHeureDeb() + " à " + listCal.get(i).getHeureFin() + "\n";
                }
            }
        }

        if (prog) {
            answer = "Votre programme de la semaine est le suivant : \n" + answer;
        } else {
            answer = "Vous n'avez pas de programme cette semaine !";
        }

        return answer;
    }

    /**
     * Get the event of the next week
     *
     * @return
     */
    public Calendar nextWeek() {
        Calendar now = Calendar.getInstance();
        int weekday = now.get(Calendar.DAY_OF_WEEK);
        if (weekday != Calendar.MONDAY) {

            // the 2 is the difference between Saturday and Monday  
            int days = (Calendar.SATURDAY - weekday + 2) % 7;
            now.add(Calendar.DAY_OF_YEAR, days);
        }

        return now;
    }

    /**
     * Get the next meeting with someone
     *
     * @param name
     * @return
     */
    public String getNextMeeting(String name) {
        String answer = "";

        boolean next = false;
        int nearestDate = 0;
        for (int i = 0; i < listCal.size(); i++) {
            if (listCal.get(i).getDebut().after(Calendar.getInstance())) {
                for (int y = 0; y < listCal.get(i).getParticipants().size(); y++) {
                    if (listCal.get(i).getParticipants().get(y).toLowerCase().equals(name)) {
                        next = true;
                        break;
                    }
                }
                if (next) {
                    nearestDate = i;
                    break;
                }
            }
        }

        if (!next) {
            answer = "Vous n'avez pas de rendez-vous avec " + name + " !";
        } else {
            next = false;
            for (int i = 1; i < listCal.size(); i++) {
                if (listCal.get(i).getDebut().before(listCal.get(nearestDate).getDebut())
                        && listCal.get(i).getDebut().after(Calendar.getInstance())) {
                    next = false;
                    for (int y = 0; y < listCal.get(i).getParticipants().size(); y++) {
                        if (listCal.get(i).getParticipants().get(y).equals(name)) {
                            next = true;
                            break;
                        }
                    }
                    if (next) {
                        nearestDate = i;
                    }
                }
            }

            answer = "Votre prochain rendez vous avec " + name + " aura lieu le ";
            answer += listCal.get(nearestDate).getDate();
            answer += " de " + listCal.get(nearestDate).getHeureDeb() + " à " + listCal.get(nearestDate).getHeureFin();
        }

        return answer;
    }

    /**
     * Get the current hour:minute:second
     *
     * @return
     */
    public String getHours(String msg) {
        SimpleDateFormat date = new SimpleDateFormat("HH:mm:ss");
        return date.format(new Date());
    }

    /**
     * Return the next meeting
     *
     * @return
     */
    public String getNextRDV(String msg) {
        String answer = "";

        boolean next = false;
        int nearestDate = 0;
        for (int i = 0; i < listCal.size(); i++) {
            if (listCal.get(i).getDebut().compareTo(Calendar.getInstance()) > 0) {
                nearestDate = i;
                next = true;
                break;
            }
        }

        if (!next) {
            answer = "Vous n'avez pas de rendez-vous !";
        } else {

            for (int i = 1; i < listCal.size(); i++) {
                if (listCal.get(i).getDebut().before(listCal.get(nearestDate).getDebut())
                        && listCal.get(i).getDebut().after(Calendar.getInstance())) {
                    nearestDate = i;
                }
            }

            answer = "Votre prochain rendez vous aura lieu le ";
            answer += listCal.get(nearestDate).getDate();
            answer += " de " + listCal.get(nearestDate).getHeureDeb() + " à " + listCal.get(nearestDate).getHeureFin();
        }

        return answer;
    }

    /**
     * Save a new meeting event
     *
     * @param titre
     * @return
     */
    public String setRDVTitre(String titre) {
        String answer = "";
        listCal.add(new Calendars());
        listCal.get(listCal.size() - 1).setTitre(titre);
        return answer;
    }

    //19/03/2014 de 9:00 a 10:00
    public String setRDVDate(String message) {
        String answer = "";

        String[] msg = message.split(" ");
     
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String hDeb = msg[0] + " " + msg[2];
        Date heureDeb = null;
        Calendar cDeb = Calendar.getInstance();

        try {
            heureDeb = formatter.parse(hDeb);
            cDeb.setTime(heureDeb);
        } catch (ParseException ex) {
            Logger.getLogger(CalendarPlugin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String hFin = msg[0] + " " + msg[4];
        Date heureFin = null;
        Calendar cFin = Calendar.getInstance();

        try {
            heureFin = formatter.parse(hFin);
            cFin.setTime(heureFin);
        } catch (ParseException ex) {
            Logger.getLogger(CalendarPlugin.class.getName()).log(Level.SEVERE, null, ex);
        }

        listCal.get(listCal.size() - 1).setDebut(cDeb);
        listCal.get(listCal.size() - 1).setFin(cFin);

        return answer;
    }

    public String setRDVParticipant(String message) {
        String answer = "";
        ArrayList<String> p = new ArrayList<String>();
        p.add(message);
        listCal.get(listCal.size() - 1).setParticipants(p);
        return answer;
    }

    public String setRDVLieu(String lieu) {
        String answer = "";
        listCal.get(listCal.size() - 1).setLieu(lieu);
        return answer;
    }

}
