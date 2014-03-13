package miagesorbonne.geniusbot.plugins;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Calendar PLugin that add calendar functionnality to the bot
 * 
 * @author Alexandre Le Boucher <alex.leboucher.inef@gmail.com>
 * @author Shinthujan Sivakumar <shinthujan.sivakumar@gmail.com>
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class CalendarPlugin {

    String csvFile = "./src/main/java/calendar.csv";
    BufferedReader br;
    String line = "";
    String splitBy = ";";
    String listSplit = "-";
    ArrayList<Calendars> listCal;

    public CalendarPlugin() {
        this.listCal = new ArrayList<Calendars>();
    }

    public void listCal() {
        System.out.println(listCal.get(0).toString());
        System.out.println(listCal.get(1).toString());
    }

    public void read() {
        try {
            br = new BufferedReader(new FileReader(csvFile));

            while ((line = br.readLine()) != null) {
                String[] cal = line.split(splitBy);

                int i = 0;
                while (i < cal.length) {
                    String titre = cal[i++];

                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    String d = cal[i++];
                    Date date = null;

                    try {
                        date = formatter.parse(d);
                    } catch (ParseException ex) {
                        Logger.getLogger(CalendarPlugin.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    String heureDeb = cal[i++];
                    String heureFin = cal[i++];
                    ArrayList<String> participants = new ArrayList<String>(Arrays.asList(cal[i++].split(listSplit)));
                    String lieu = cal[i++];

                    Calendars c = new Calendars(titre, date, heureDeb, heureFin, participants, lieu);
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

    private Date getDateWithOutTime(Date targetDate) {
        Calendar newDate = Calendar.getInstance();
        newDate.setLenient(false);
        newDate.setTime(targetDate);
        newDate.set(Calendar.HOUR_OF_DAY, 0);
        newDate.set(Calendar.MINUTE, 0);
        newDate.set(Calendar.SECOND, 0);
        newDate.set(Calendar.MILLISECOND, 0);

        return newDate.getTime();
    }

    public String getProgrammeJournee() {
        String answer = "";
        Date now = new java.util.Date();
        boolean prog = false;
        for (int i = 1; i < listCal.size(); i++) {
            if (getDateWithOutTime(listCal.get(i).getDate()).equals(getDateWithOutTime(now))) {
                prog = true;
                answer += listCal.get(i).getTitre() + "\n";
            }
        }

        if (prog) {
            answer = "Votre programme de la journée est le suivant : \n" + answer;
        } else {
            answer = "Vous n'avez pas de programme aujourd'hui !";
        }
        return answer;
    }

    public String getProgrammeSemaine() {
        String answer = "";

        return answer;
    }

    public String getRDV(String question) {
        String answer = "";

        return answer;
    }

    public String getNextMeeting(String question) {
        String answer = "";

        return answer;
    }

    public String setRDV(String question) {
        String answer = "";

        return answer;
    }

    public String getHours() {
        SimpleDateFormat date = new SimpleDateFormat("HH:mm:ss");
        return date.format(new Date());
    }

    public String getNextRDV(String question) {
        String answer = "";

        return answer;
    }

}
