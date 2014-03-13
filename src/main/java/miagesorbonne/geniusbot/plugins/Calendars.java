package miagesorbonne.geniusbot.plugins;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Calendar Entity used to stor an event in a calendar
 *
 * @author Alexandre Le Boucher <alex.leboucher.inef@gmail.com>
 * @author Shinthujan Sivakumar <shinthujan.sivakumar@gmail.com>
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class Calendars {

    private String titre;
    private Calendar debut;
    private Calendar fin;
    private ArrayList<String> participants;
    private String lieu;
    
    private String date;
    private String heureDeb;
    private String heureFin;

    public Calendars(String titre, Calendar heureDeb, Calendar heureFin, ArrayList<String> participants, String lieu) {
        this.titre = titre;
        this.debut = heureDeb;
        this.fin = heureFin;
        this.participants = participants;
        this.lieu = lieu;
        
        this.date = days(debut);
        this.heureDeb = hours(debut);
        this.heureFin = hours(fin);
    }

    @Override
    public String toString() {
        String message = "Titre: " + titre + "- Date: " + date + " , "+ debut.getTime()+" - Heure de début: " + heureDeb + " - Heure de fin: " + heureFin;
        message += " - Participants: " + participants.toString() + " - Lieu: " + lieu;
        return message;
    }

    public String getTitre() {
        return titre;
    }

    public ArrayList<String> getParticipants() {
        return participants;
    }

    public String getLieu() {
        return lieu;
    }

    public Calendar getDebut() {
        return debut;
    }

    public Calendar getFin() {
        return fin;
    }

    public String getDate() {
        return date;
    }

    public String getHeureDeb() {
        return heureDeb;
    }

    public String getHeureFin() {
        return heureFin;
    }

    
    public String hours(Calendar cal) {
        int hh = cal.get(Calendar.HOUR_OF_DAY);
        int mn = cal.get(Calendar.MINUTE);

        String heureS = ((hh < 10) ? "0" : "") + hh;
        String minutesS = ((mn < 10) ? "0" : "") + mn;

        return (heureS + ":" + minutesS);
    }
    
    public String days(Calendar cal) {
        int dd = cal.get(Calendar.DATE);
        int mm = cal.get(Calendar.MONTH);
        int yy = cal.get(Calendar.YEAR);

        return (dd + "/" + mm + "/" + yy);
    }
}
