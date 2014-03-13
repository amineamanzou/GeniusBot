/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package miagesorbonne.geniusbot.plugins;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 *  *
 * @author Alexandre Le Boucher <alex.leboucher.inef@gmail.com>
 * @author Shinthujan Sivakumar <shinthujan.sivakumar@gmail.com>
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
 
public class Contact{
    
    private String nom;
    private Date naissance;
    private String sexe;
    private String adresse;
    private String surnom;
    private ArrayList<String> mails;
    private ArrayList<String> telephones;

    
     public Contact(String nom, Date naissance, String sexe, String adresse, String surnom,  ArrayList<String> mails, ArrayList<String> telephones) {
        this.nom = nom;
        this.naissance = naissance;
        this.sexe = sexe;
        this.adresse = adresse;
        this.surnom = surnom;
        this.mails = mails;
        this.telephones = telephones;
    }
    
    
     @Override
    public String toString() {
        
        String message =   nom + " de sexe " + sexe + " né(e) le " + getNaissance() + " habite au " + adresse + ".\n" +
                "Ses collègues aiment bien le surnommer " + surnom + ".\n";
        message += "On peut le contacter aux adresses mails suivantes : " + mails.toString() + ".\n" 
                + "Ainsi que sur ses numéros de telephone : " + telephones.toString();
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
         * 
         * @return la naissance 
         */
    public Date getNaissance(){
        
        return naissance;
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
