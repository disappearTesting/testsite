package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class ReadContent {
    public void readContent(HttpURLConnection connection) {
        if(connection != null) {
            try {
                BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder content = new StringBuilder();
                while((inputLine = input.readLine()) != null) {
                    content.append(inputLine);
                    content.append(System.lineSeparator());
                }
                System.out.println(content.toString());
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
