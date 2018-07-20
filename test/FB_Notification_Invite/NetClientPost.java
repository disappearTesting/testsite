package FB_Notification_Invite;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.*;

public class NetClientPost {

    private String https_protocol;
    private String host;
    private String dialog_path;
    private String params;

    public NetClientPost(String https_protocol, String host, String dialog_path, String params) {
        this.https_protocol = https_protocol;
        this.host = host;
        this.dialog_path = dialog_path;
        this.params = params;
    }

    private URL getURL() throws MalformedURLException, URISyntaxException {
        URI uri = new URI(https_protocol, host, dialog_path + params);
        return uri.toURL();
    }

    private void getConnection_PostRequest() {
        try {
            HttpsURLConnection connection = (HttpsURLConnection) getURL().openConnection();
            connection.connect();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
        } catch (MalformedURLException e) {
            // new URL() failed
            // ...
        } catch (IOException e) {
            // openConnection() failed
            // ...
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
