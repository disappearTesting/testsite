package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class ReadContent {
    public void readContent(URL url) {
        if(url != null) {
            try {
                BufferedReader input = new BufferedReader(new InputStreamReader(url.openStream()));

                String inputLine;
                while((inputLine = input.readLine()) != null) {
                    System.out.println(inputLine);
                }
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
