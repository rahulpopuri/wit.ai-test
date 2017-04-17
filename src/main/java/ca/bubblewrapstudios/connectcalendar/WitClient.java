package ca.bubblewrapstudios.connectcalendar;

import ca.bubblewrapstudios.connectcalendar.model.IntentValue;
import ca.bubblewrapstudios.connectcalendar.model.MessageResponse;
import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Properties;

/**
 * Created by rahul on 2017-03-31.
 */
public class WitClient {

    private static String WIT_URL_PREFIX;
    private static String API_VERSION;
    private static String SERVER_TOKEN;

    private static boolean initialized = false;
    private String event;

    public WitClient(String event) {
        InputStream input = null;
        if (!initialized) {
            try {
                input = new FileInputStream("config.properties");

                Properties properties = new Properties();
                properties.load(input);

                WIT_URL_PREFIX = properties.getProperty("WIT_URL_PREFIX");
                API_VERSION = properties.getProperty("API_VERSION");
                SERVER_TOKEN = properties.getProperty("SERVER_TOKEN");

                initialized = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                if (input != null) {
                    try {
                        input.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        this.event = event;
        if (event != null) {
            execute();
        }
    }

    private void execute() {
        try {
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet httpGet = new HttpGet(WIT_URL_PREFIX + "v=" + API_VERSION + "&q=" + URLEncoder.encode(event, "UTF-8"));
            httpGet.addHeader("Authorization", "Bearer " + SERVER_TOKEN);
            HttpResponse response = httpClient.execute(httpGet);
            switch (response.getStatusLine().getStatusCode()) {
                case 200:
                    MessageResponse messageResponse = new Gson().fromJson(EntityUtils.toString(response.getEntity()), MessageResponse.class);
                    IntentValue positive = messageResponse.getEntities().getPositive().get(0);
                    if (positive != null) {
                        System.out.println(messageResponse.getText() + "\n" + "display = " + positive.getValue() + ", confidence = " + positive.getConfidence());
                        System.out.println();
                    }
                    break;

                default:
                    System.out.println("Response code: " + response.getStatusLine().getStatusCode() + response.getEntity().toString());
                    break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
