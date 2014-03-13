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
    private String prenom;
    private String sexe;
    private String adresse;
    private String surnom;
    private ArrayList<String> mails;
    private String telephone;

    
     public Contact(String nom, String prenom, String sexe, String adresse, String surnom,  ArrayList<String> mails, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.adresse = adresse;
        this.surnom = surnom;
        this.mails = mails;
        this.telephone = telephone;
    }
    
    
     @Override
    public String toString() {
        String message = "Nom: " + nom + " " + prenom + "-  " + sexe + " - Adresse: " + adresse +
                " - Surnom: " + surnom;
        message += " - Mail: " + mails.toString() + " - Telephone: " + telephone;
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
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
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
    public String getTelephone() {
        return telephone;
    }

 
   
}
