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

    /**
     * Main constructor of a single event
     *
     * @param titre
     * @param heureDeb
     * @param heureFin
     * @param participants
     * @param lieu
     */
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

    public Calendars() {
        this.titre = "";
        this.debut = null;
        this.fin = null;
        this.participants = new ArrayList<String>();
        this.lieu = null;
    }

    public void setDebut(Calendar debut) {
        this.debut = debut;
        this.date = days(debut);
        this.heureDeb = hours(debut);
    }

    public void setFin(Calendar fin) {
        this.fin = fin;
        this.heureFin = hours(fin);
    }
    
    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setParticipants(ArrayList<String> participants) {
        this.participants = participants;
    }
    
    public void setOneParticipant(String name) {
        if(!this.participants.isEmpty()) {
            this.participants.add(name);
        }
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    @Override
    public String toString() {
        String message = "Titre: " + titre + "- Date: " + date + " , " + debut.getTime() + " - Heure de début: " + heureDeb + " - Heure de fin: " + heureFin;
        message += " - Participants: " + participants.toString() + " - Lieu: " + lieu;
        return message;
    }

    /**
     * Get the title of the event
     *
     * @return title
     */
    public String getTitre() {
        return titre;
    }

    /**
     * Get the list of participants to the event
     *
     * @return participants
     */
    public ArrayList<String> getParticipants() {
        return participants;
    }

    /**
     * Get the place where will be the event
     *
     * @return place
     */
    public String getLieu() {
        return lieu;
    }

    /**
     * Get the begining date of the event
     *
     * @return begin
     */
    public Calendar getDebut() {
        return debut;
    }

    /**
     * Get the date of the end of the event
     *
     * @return
     */
    public Calendar getFin() {
        return fin;
    }

    /**
     * Get the date of the event
     *
     * @return date
     */
    public String getDate() {
        return date;
    }

    /**
     * Get the hour when begin the event
     *
     * @return hourBegin
     */
    public String getHeureDeb() {
        return heureDeb;
    }

    /**
     * Get the hour when end the event
     *
     * @return hourEnd
     */
    public String getHeureFin() {
        return heureFin;
    }

    /**
     * Get the hour part of the date
     *
     * @param cal
     * @return
     */
    public String hours(Calendar cal) {
        int hh = cal.get(Calendar.HOUR_OF_DAY);
        int mn = cal.get(Calendar.MINUTE);

        String heureS = ((hh < 10) ? "0" : "") + hh;
        String minutesS = ((mn < 10) ? "0" : "") + mn;

        return (heureS + ":" + minutesS);
    }

    /**
     * Get the day part of the date
     *
     * @param cal
     * @return
     */
    public String days(Calendar cal) {
        int dd = cal.get(Calendar.DATE);
        int mm = cal.get(Calendar.MONTH)+1;
        int yy = cal.get(Calendar.YEAR);
     
        return (dd + "/" + mm + "/" + yy);
    }
}
