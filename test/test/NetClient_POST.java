package test;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

public class NetClient_POST {
    public static void main(String[] args) {
        try {
            URI uri = new URI("https", "scanword.smapps.net","/rest/sync/ios", "");
            URL url = uri.toURL();

            HttpsURLConnection httpsConnection = (HttpsURLConnection) url.openConnection();
            httpsConnection.setRequestMethod("POST");
            httpsConnection.setDoOutput(true);
            httpsConnection.setRequestProperty("Content-Type", "application/json");
            httpsConnection.setUseCaches(false);

            new ReadContent().readContent(url);

        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}