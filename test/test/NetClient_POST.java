package test;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.*;

public class NetClient_POST {
    public static void main(String[] args) {
        try {
            URI uri = new URI("https","scanword.smapps.net","/rest/sync/ios","");
            URL url = new CreatingURL(uri).getURL();

            URLConnection urlConnection = url.openConnection();

            HttpsURLConnection httpsConnection = (HttpsURLConnection) urlConnection;
            httpsConnection.setRequestMethod("POST");
            httpsConnection.setDoOutput(true);
            httpsConnection.setRequestProperty("Content-Type", "application/json");

            new ReadContent().readContent(url);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}