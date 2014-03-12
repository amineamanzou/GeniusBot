package miagesorbonne.geniusbot.plugins;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Sinthu
 */
public class CalendarPlugin {

    String csvFile = "./src/main/java/calendar.csv";
    BufferedReader br;
    String line = "";
    String splitBy = ";";
    String listSplit = "-";
    ArrayList<Calendar> listCal;

    public CalendarPlugin() {
        this.listCal = new ArrayList<Calendar>();
    }

    public void read() {
        try {
            br = new BufferedReader(new FileReader(csvFile));

            while ((line = br.readLine()) != null) {
                String[] cal = line.split(splitBy);

                int i = 0;
                while (i < cal.length) {
                    String titre = cal[i++];
                    String heureDeb = cal[i++];
                    String heureFin = cal[i++];
                    ArrayList<String> participants = new ArrayList<String>(Arrays.asList(cal[i++].split(listSplit)));
                    String lieu = cal[i++];

                    Calendar c = new Calendar(titre, heureDeb, heureFin, participants, lieu);
                    listCal.add(c);
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

    public String getAnswer(String question) {
        String answer = "";

        if (question.equals("journee")) {
            answer = "Test";
        }

        return answer;
    }
}
