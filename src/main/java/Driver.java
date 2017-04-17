import ca.bubblewrapstudios.connectcalendar.WitClient;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by rahul on 2017-03-31.
 */
public class Driver {

    public static void main(String[] args) {
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("data.txt"));

            while ((line = br.readLine()) != null) {
                new WitClient(line);
            }
        } catch (Exception e) {
            System.out.println("Error parsing: " + line);
        }

    }
}
