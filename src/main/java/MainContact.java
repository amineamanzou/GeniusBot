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

public class MainContact {

    public static void main(String[] args) {
        System.out.println("DEBUT");
        ContactPlugin test = new ContactPlugin();
        test.read();
        System.out.println("FIN");
        test.listContact();
    }
}