
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Contact Plugin that add contact management functionnality to Genius.
 *
 * @author Alexandre Le Boucher <alex.leboucher.inef@gmail.com>
 * @author Shinthujan Sivakumar <shinthujan.sivakumar@gmail.com>
 * @author Amine Amanzou <amineamanzou@gmail.com>
 */
public class ContactPlugin {

    String csvFile = "DemoContact.csv";
    BufferedReader br = null;
    String line = "";
    String splitBy = ";";

    public ContactPlugin() {

    }

    /**
     *
     * @param name
     * @return le contact en question ou null sinon
     */
    public String findByName(String name) {

        String temp = "";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                String[] contact = line.split(splitBy);

                if (contact[1] == null ? name == null : contact[1].equals(name)) {
                    temp += contact[0] + contact[1] + contact[2];
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
        return temp;
    }

}
