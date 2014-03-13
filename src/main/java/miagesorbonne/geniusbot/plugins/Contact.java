/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package miagesorbonne.geniusbot.plugins;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 *  *
 * @author Alexandre Le Boucher <alex.leboucher.inef@gmail.com>
 * @author Shinthujan Sivakumar <shinthujan.sivakumar@gmail.com>
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
 
public class Contact{
    
    private String nom;
    private String sexe;
    private String adresse;
    private String surnom;
    private ArrayList<String> mails;
    private ArrayList<String> telephones;

    
     public Contact(String nom, String sexe, String adresse, String surnom,  ArrayList<String> mails, ArrayList<String> telephones) {
        this.nom = nom;
        this.sexe = sexe;
        this.adresse = adresse;
        this.surnom = surnom;
        this.mails = mails;
        this.telephones = telephones;
    }
    
    
     @Override
    public String toString() {
        String message = "Nom: " + nom + "-  " + sexe + " - Adresse: " + adresse +
                " - Surnom: " + surnom;
        message += " - Mail: " + mails.toString() + " - Telephone: " + telephones.toString();
        return message;
    }

  

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    
     /**
     * @return the surnom
     */
    public String getSurnom() {
        return surnom;
    }

     /**
     * @return the adresse
     */
    public String getAdresse() {
        return adresse;
    }

    


    /**
     * @return the sexe
     */
    public String getSexe() {
        return sexe;
    }


    /**
     * @return the mail
     */
    public ArrayList<String> getMails() {
        return mails;
    }
    
  
    /**
     * @return the telephone
     */
    public ArrayList<String> getTelephone() {
        return telephones;
    }

 
   
}
