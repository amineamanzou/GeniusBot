package miagesorbonne.geniusbot.plugins;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;


/**
 * Contact Plugin that add contact management functionnality to Genius.
 *
 * @author Alexandre Le Boucher <alex.leboucher.inef@gmail.com>
 * @author Shinthujan Sivakumar <shinthujan.sivakumar@gmail.com>
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class ContactPlugin {

    
    String csvFile = "./src/main/java/contact.csv";
    BufferedReader br;
    String line = "";
    String splitBy = ";";
    String listSplit = "-";
    ArrayList<Contact> listContacts;
    
    
    
    public ContactPlugin() {
        this.listContacts = new ArrayList<Contact>();
    }

   
     public void listContact() {
        System.out.println(listContacts.get(0).toString());
        System.out.println(listContacts.get(1).toString());
        System.out.println(listContacts.get(2).toString());
        System.out.println(listContacts.get(3).toString());
    }
    
    
    public void read() {
        try {
            br = new BufferedReader(new FileReader(csvFile));

            while ((line = br.readLine()) != null) {
                String[] contact = line.split(splitBy);

                int i = 0;
                while (i < contact.length) {
                    
                    String nom = contact[i++];
                    String sexe = contact[i++];
                    String adresse = contact[i++];
                    String surnom = contact[i++];
                    ArrayList<String> mails = new ArrayList<String>(Arrays.asList(contact[i++].split(listSplit)));
                    ArrayList<String> telephones = new ArrayList<String>(Arrays.asList(contact[i++].split(listSplit)));
                   

                    Contact c = new Contact(nom, sexe, adresse, surnom, mails, telephones);
                    listContacts.add(c);
                }
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
     * Fonction qui retourne un booléen pour savoir si un contact existe ou non en fonction de son nom
     * @param name nom du contact
     * @return true si le nom existe, non sinon
     */
    public Boolean exists(String name){
        
        boolean temp = false;
        
         for (int i = 1; i < listContacts.size(); i++) {
            if ((listContacts.get(i).getNom()).equals(name)) {
                temp = true;            
            }
        }
        
        return temp;
    }
    
    
    
    
    public String information(String name, String infos){
        
         String answer = "";
       

        for (int i = 1; i < listContacts.size(); i++) {
            if ((listContacts.get(i).getNom()).equals(name)) {
                if(infos.equals("adresse"))
                     answer = name + "habite : " + listContacts.get(i).getAdresse();
                
                else if(infos.equals("sexe"))
                     answer = name + " est de sexe " + listContacts.get(i).getSexe();
                
                 else if(infos.equals("all"))
                      answer = "Voici toutes les informations diponibles sur le contact " + name + " : \n" 
                    + listContacts.get(i).toString();
                     
                 else if(infos.equals("surnom"))
                     answer = "Ses collègues l'ont surnommé " + listContacts.get(i).getSurnom();
                 
                 else if(infos.equals("telephone"))
                      answer = name + "est disponible au(x) : " + listContacts.get(i).getTelephone().toString();
                 
                 else if(infos.equals("mail"))
                     answer = name + "est disponible au(x) : " + listContacts.get(i).getMails().toString();
                    
                 
            }
        }
        
        return answer;
        
        
        
    }
    
    
    /**
     * Fonction qui retourne l'information en fonction du nom et de l'information que l'on veut
     * @param name nom du contact
     * @param infos l'information recherchée
     * @return l'information recherchée
     */
    private String informations(String name, String infos){
        
        String temp = "";
       

        for (int i = 1; i < listContacts.size(); i++) {
            if ((listContacts.get(i).getNom()).equals(name)) {
                if(infos.equals("adresse"))
                     temp = listContacts.get(i).getAdresse();
                else if(infos.equals("sexe"))
                     temp = listContacts.get(i).getSexe();
                 else if(infos.equals("all"))
                     temp = listContacts.get(i).toString();
                 else if(infos.equals("surnom"))
                     temp = listContacts.get(i).getSurnom();
                 else if(infos.equals("telephone"))
                     temp = listContacts.get(i).getTelephone().toString();
                 else if(infos.equals("mail"))
                     temp = listContacts.get(i).getMails().toString();
                 
            }
        }
        
        return temp;
    }
    
    
    
    /**
     * Fonction qui retourne si un contact existe ou non en donnant son nom
     * @param name nom du contact
     * @return le nom du contact ou non
     */
    public String knowsHim(String name){
        
        String answer = "";
     
        if (exists(name)) {
            answer = "Oui nous avons dans notre répertoire : \n" + name;
        } else {
            answer = "Nous ne connaissons personne de ce nom la !";
        }
        return answer;
        
    }
    
    
 
    /**
     * Fonction qui retourne l'adresse d'un contact si il existe
     * @param name nom du contact
     * @return l'adresse du contact ou non
     */
    public String whereLeaves(String name){
     
        String answer = "";
     
        if (exists(name)) {
            answer = name + "habite : " + informations(name,"adresse");
        } else {
            answer = "Nous ne connaissons personne de ce nom la !";
        }
        return answer;
        
    }
    
    
    /**
     * Retourne toutes les informations disponibles sur le contact
     * @param name nom du contact
     * @return les informations du contact ou non
     */
    public String allAboutHim(String name){
        
        String answer = "";
     
        if (exists(name)) {
            answer = "Voici toutes les informations diponibles sur le contact " + name + " : \n" 
                    + informations(name,"all");
        } else {
            answer = "Nous ne connaissons personne de ce nom la !";
        }
        return answer;
        
    }
    
    
    /**
     * Retourne les numéros de téléphone du contact
     * @param name nom du contact
     * @return les numéros de téléphone ou non
     */
    public String phone(String name){
        
        String answer = "";
     
        if (exists(name)) {
            answer = name + "est disponible au(x) : " + informations(name,"telephone");
        } else {
            answer = "Nous ne connaissons personne de ce nom la !";
        }
        return answer;
        
    }
    
    /**
     * Retourne les mails du contact
     * @param name nom du contact
     * @return les mails du contact ou non
     */
    public String Mail(String name){
        
         String answer = "";
     
        if (exists(name)) {
            answer = name + "est disponible au(x) : " + informations(name,"mail");
        } else {
            answer = "Nous ne connaissons personne de ce nom la !";
        }
        return answer;
    }
    
     
     
   
    
    
    
   
    
   
    
    
    
}
