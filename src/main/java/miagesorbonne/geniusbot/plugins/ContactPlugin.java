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
    
    
    public String knowsHim(String name){
        
        String answer = "";
        boolean prog = false;
        for (int i = 1; i < listContacts.size(); i++) {
            if ((listContacts.get(i).getNom()).equals(name)) {
                prog = true;
                answer += listContacts.get(i).getNom() + "\n";
            }
        }

        if (prog) {
            answer = "Oui nous avons dans notre répertoire : \n" + answer;
        } else {
            answer = "Nous ne connaissons personne de ce nom la !";
        }
        return answer;
        
    }
    
    
    public String whoIsHe(String name){
        
        return null;
    }
    
    public String whereLeaves(String name){
     
        return null;
        
    }
    
    public String howOld(String name){
        
        return null;
    }
    
    public String allAboutHim(String name){
        
        return null;
    }
    
    public String phone(String name){
        
        return null;
    }
    
    public String allMail(String name){
        
        return null;
    }
    
    
    
}
