/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package miagesorbonne.geniusbot.plugins;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Sinthu
 */
public class Calendars {
    private String titre;
    private Date date;
    private String heureDeb;
    private String heureFin;
    private ArrayList<String> participants;
    private String lieu;

    public Calendars(String titre, Date date, String heureDeb, String heureFin, ArrayList<String> participants, String lieu) {
        this.titre = titre;
        this.date = date;
        this.heureDeb = heureDeb;
        this.heureFin = heureFin;
        this.participants = participants;
        this.lieu = lieu;
    }
    
    @Override
    public String toString() {
        String message = "Titre: " + titre + "- Date: " + date + " - Heure de début: " + heureDeb + " - Heure de fin: " + heureFin;
        message += " - Participants: " + participants.toString() + " - Lieu: "+lieu;
        return message;
    }

    public String getTitre() {
        return titre;
    }

    public Date getDate() {
        return date;
    }

    public ArrayList<String> getParticipants() {
        return participants;
    }

    public String getLieu() {
        return lieu;
    }
          
    
    
}
