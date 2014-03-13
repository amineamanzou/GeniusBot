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
        read();
    }

    public void listCal() {
        for (int i = 0; i < listCal.size(); i++) {
            System.out.println(listCal.get(i).toString());
        }
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

                    formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                    String h = d + " " + cal[i++];
                    Date heureDeb = null;
                    Calendar cDeb = Calendar.getInstance();

                    try {
                        heureDeb = formatter.parse(h);
                        cDeb.setTime(heureDeb);
                    } catch (ParseException ex) {
                        Logger.getLogger(CalendarPlugin.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    h = d + " " + cal[i++];
                    Date heureFin = null;
                    Calendar cFin = Calendar.getInstance();

                    try {
                        heureFin = formatter.parse(h);
                        cFin.setTime(heureFin);
                    } catch (ParseException ex) {
                        Logger.getLogger(CalendarPlugin.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    ArrayList<String> participants = new ArrayList<String>(Arrays.asList(cal[i++].split(listSplit)));
                    String lieu = cal[i++];

                    Calendars c = new Calendars(titre, cDeb, cFin, participants, lieu);
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

    private Calendar getDateWithOutTime(Calendar targetDate) {
        targetDate.set(Calendar.HOUR_OF_DAY, 0);
        targetDate.set(Calendar.MINUTE, 0);
        targetDate.set(Calendar.SECOND, 0);
        targetDate.set(Calendar.MILLISECOND, 0);

        return targetDate;
    }

    public String getProgrammeJournee() {
        String answer = "";
        Calendar now = Calendar.getInstance();
        boolean prog = false;
        for (int i = 1; i < listCal.size(); i++) {
            if (getDateWithOutTime(listCal.get(i).getDebut()).equals(getDateWithOutTime(now))) {
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
