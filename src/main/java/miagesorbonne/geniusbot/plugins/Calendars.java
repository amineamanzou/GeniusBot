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

    public Calendars(String titre, Calendar heureDeb, Calendar heureFin, ArrayList<String> participants, String lieu) {
        this.titre = titre;
        this.debut = heureDeb;
        this.fin = heureFin;
        this.participants = participants;
        this.lieu = lieu;
    }

    @Override
    public String toString() {
        String message = "Titre: " + titre + "- Date: " + lieu + " - Heure de début: " + hours(debut) + " - Heure de fin: " + hours(fin);
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


    public String hours(Calendar cal) {
        int hh = cal.get(Calendar.HOUR_OF_DAY);
        int mn = cal.get(Calendar.MINUTE);
        int ss = cal.get(Calendar.SECOND);

        String heureS = ((hh < 10) ? "0" : "") + hh;
        String minutesS = ((mn < 10) ? "0" : "") + mn;
        String secondesS = ((ss < 10) ? "0" : "") + ss;

        return (heureS + ":" + minutesS + ":" + secondesS);
    }
}
