package test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class CreatingURL {

    URI uri;

    public CreatingURL(URI uri) {
        this.uri = uri;
    }

    public URL getURL() {
        URL url = null;
        try {
            url = uri.toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }
}