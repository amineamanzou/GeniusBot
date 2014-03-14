package miagesorbonne.geniusbot.plugins;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Contact class representing one contact entity
 * 
 * @author Alexandre Le Boucher <alex.leboucher.inef@gmail.com>
 * @author Shinthujan Sivakumar <shinthujan.sivakumar@gmail.com>
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class Contact{
    
    private String nom;
    private String naissance;
    private String sexe;
    private String adresse;
    private String surnom;
    private String age;
    private ArrayList<String> mails;
    private ArrayList<String> telephones;

    /**
     * Main constructor of a contact
     * @param nom
     * @param naissance
     * @param sexe
     * @param adresse
     * @param surnom
     * @param mails
     * @param telephones 
     */
    public Contact(String nom, String naissance, String sexe, String adresse, String surnom,  ArrayList<String> mails, ArrayList<String> telephones, String age) {
        this.nom = nom;
        this.naissance = naissance;
        this.sexe = sexe;
        this.adresse = adresse;
        this.surnom = surnom;
        this.mails = mails;
        this.telephones = telephones;
        this.age = age;
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
     * Get the name of the contact
     * @return name
     */
    public String getNom() {
        return nom;
    }
    
     public String getAge() {
        return age;
    }
    
    /**
     * Get the pseudo of the contact
     * @return pseudo
     */
    public String getSurnom() {
        return surnom;
    }

    /**
     * Get the adress of a contact
     * @return address
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * Get the birth day of the contact
     * @return birthday 
     */
    public String getNaissance(){
        
        return naissance;
    }

    /**
     * Get the sexe of the contact
     * @return sexe
     */
    public String getSexe() {
        return sexe;
    }
    
    /**
     * Get the email list of the contact
     * @return email
     */
    public ArrayList<String> getMails() {
        return mails;
    }
    
    /**
     * Get the phone numbers list of the contact
     * @return phone
     */
    public ArrayList<String> getTelephone() {
        return telephones;
    }

}
