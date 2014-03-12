/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package miagesorbonne.geniusbot.plugins.calendar;

import java.util.ArrayList;

/**
 *
 * @author Sinthu
 */
public class Calendar {
    private String titre;
    private String heureDeb;
    private String heureFin;
    private ArrayList<String> participants;
    private String lieu;

    public Calendar(String titre, String heureDeb, String heureFin, ArrayList<String> participants, String lieu) {
        this.titre = titre;
        this.heureDeb = heureDeb;
        this.heureFin = heureFin;
        this.participants = participants;
        this.lieu = lieu;
    }
    
    @Override
    public String toString() {
        String message = "Titre: " + titre + " - Heure de début: " + heureDeb + " - Heure de fin: " + heureFin;
        message += " - Participants: " + participants.toString() + " - Lieu: "+lieu;
        return message;
    }
            
    
}
