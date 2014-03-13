package miagesorbonne.geniusbot.plugins;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


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
                    String prenom = contact[i++];
                    String sexe = contact[i++];
                    String adresse = contact[i++];
                    String surnom = contact[i++];
                    ArrayList<String> mails = new ArrayList<String>(Arrays.asList(contact[i++].split(listSplit)));
                    String telephone = contact[i++];

                    Contact c = new Contact(nom, prenom, sexe, adresse, surnom, mails, telephone);
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
    
    
    
}
