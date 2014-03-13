/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alexandreleboucher
 */

import miagesorbonne.geniusbot.plugins.ContactPlugin;



  /**
     * Main Method
     * 
     * @param args 
     */
public class MainContact {

    public static void main(String[] args) {
        System.out.println("DEBUT");
        ContactPlugin test = new ContactPlugin();
        test.read();
        System.out.println("FIN");
        test.listContact();
        System.out.println(test.knowsHim("Amine"));
        System.out.println(test.knowsHim("Alexandre Le Boucher"));
        System.out.println(test.exists("Amine"));
        System.out.println(test.exists("Alexandre Le Boucher"));
        System.out.println(test.whereLeaves("Alexandre Le Boucher"));
        System.out.println(test.allAboutHim("Alexandre Le Boucher"));
        
        System.out.println(test.information("Amine Amanzou", "all"));
        System.out.println(test.information("Amine Amanzou", "surnom"));
        
    }
}