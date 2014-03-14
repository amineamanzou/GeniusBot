package miagesorbonne.geniusbot.plugins;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


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
    
    /**
     * Main constructor of the contact plugin
     */
    public ContactPlugin() {
        this.listContacts = new ArrayList<Contact>();
        read();
    }
    
    /**
     * Display the list of contact
     * @TODO Iterator on the listContact ... @AlexLB
     */
    public void listContact() {
        System.out.println(listContacts.get(0).toString());
        System.out.println(listContacts.get(1).toString());
        System.out.println(listContacts.get(2).toString());
        System.out.println(listContacts.get(3).toString());
    }
    
    /**
     * Parsing the CSV file
     */
    public void read() {
        try {
            br = new BufferedReader(new FileReader(csvFile));

            while ((line = br.readLine()) != null) {
                String[] contact = line.split(splitBy);

                
                int i = 0;
                while (i < contact.length) {
                    
                    String nom = contact[i++];
                   
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    String naissance = contact[i++];
                    /*Date date = null;

                    try {
                        date = formatter.parse(naissance);
                    } catch (ParseException ex) {
                        Logger.getLogger(ContactPlugin.class.getName()).log(Level.SEVERE, null, ex);
                    } */
                    String sexe = contact[i++];
                    String adresse = contact[i++];
                    String surnom = contact[i++];
                    ArrayList<String> mails = new ArrayList<String>(Arrays.asList(contact[i++].split(listSplit)));
                    ArrayList<String> telephones = new ArrayList<String>(Arrays.asList(contact[i++].split(listSplit)));
                    String age = contact[i++];

                    Contact c = new Contact(nom, naissance, sexe, adresse, surnom, mails, telephones, age);
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
     * Return if a contact exist according to his name
     * @param name name of the contact
     * @return true if the name exist, else false
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
    
   
    
    /**
     * Method used to retrieve the right information without displaying it
     * @param name name of the contact
     * @param infos type of informaton
     * @return searched information
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
                 else if(infos.equals("naissance"))
                     temp = listContacts.get(i).getNaissance();
                 
            }
        }
        
        return temp;
    }
    
    
    
    /**
     * Method returning if a contact exist or not
     * @param name name of the contact
     * @return the name of the contact or an empty name
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
     * Get the adress of the contact in a sentence if it exist
     * @param name name of the contact
     * @return The adresse of the contact or empty
     */
    public String whereLeaves(String name){
     
        String answer = "";
     
        if (exists(name)) {
            answer = name + " habite  " + informations(name,"adresse");
        } else {
            answer = "Nous ne connaissons personne de ce nom la !";
        }
        return answer;
        
    }
    
      /**
     * Get the date of birth of the contact in a sentence if it exist
     * @param name name of the contact
     * @return The date of birth of the contact or empty
     */
    public String whenBorns(String name){
     
        String answer = "";
     
        if (exists(name)) {
            answer = name + " est né(e) le  " + informations(name,"naissance");
        } else {
            answer = "Nous ne connaissons personne de ce nom la !";
        }
        return answer;
        
    }
    
    /**
     * Get All the informaiton about the contact according to his name
     * @param name name of the contact
     * @return informations about contact or empty
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
    
    public String whoLivesIn(String city){
        
        String answer = "";
     
       for (int i = 1; i < listContacts.size(); i++) {
            if ((listContacts.get(i).getAdresse()).equals(city.toLowerCase()))
                answer +=  listContacts.get(i).getNom() + " vit bien à " + city + "\n";
       }
       
       if(answer.isEmpty())
             answer = "Personne ne vit à " + city ;
         
        return answer;
        
        
    }
    
    public String whoHasMore(String age){
        
        String answer = "";
        String temp = age;
        if(age.length() == 1)
            temp = "0" + age;
        
         for (int i = 1; i < listContacts.size(); i++) {
            if ((listContacts.get(i).getAge()).compareTo(temp) > 0)
                answer +=  listContacts.get(i).getNom() + " a plus de " + age + " ans. \n";
       }
         
         if(answer.isEmpty())
             answer = "Personne n'a plus de " + age + " ans.";
         
        return answer;
        
        
    }
    
    
    /**
     * Get the phone numbers list of the contact in a sentence
     * @param name name of the contact
     * @return phone list or not
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
     * Get the mail list of the contact in a sentence
     * @param name name of the contact
     * @return mail list of the contact or not
     */
    public String mail(String name){
        
         String answer = "";
     
        if (exists(name)) {
            answer = name + "est disponible au(x) : " + informations(name,"mail");
        } else {
            answer = "Nous ne connaissons personne de ce nom la !";
        }
        return answer;
    }
    
     
     
   
    
    
    
   
    
   
    
    
    
}
