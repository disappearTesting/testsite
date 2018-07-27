package scanword_client;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Map;

public class NetClient {

    private HttpURLConnection httpURLConnection;

    private HttpURLConnection getHttpURLConnection(URL url, String requestMethod) {
        try {
            url = new URL(url.toString());
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod(requestMethod);
            httpURLConnection.setRequestProperty("User-Agent", "Java scanword_client");
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return httpURLConnection;
    }

    private StringBuffer buildQueryString(Map<String, String> params) {
        StringBuffer requestParams = new StringBuffer();
        Iterator<String> iterator = params.keySet().iterator();
        while(iterator.hasNext()) {
            try {
                String key = iterator.next();
                String value = params.get(key);
                requestParams.append(URLEncoder.encode(key, "UTF-8"));
                requestParams.append("=").append(URLEncoder.encode(value, "UTF-8"));
                requestParams.append("&");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return requestParams;
    }

    private byte[] getQueryByteArray(String query) {
        return query.getBytes(StandardCharsets.UTF_8);
    }

    private void readContent() {
        if(httpURLConnection != null) {
            try {
                BufferedReader input = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
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

    public void doRequest(URL url, Map<String,String> requestParams, String method) {
        try {
            //
            String query = buildQueryString(requestParams).toString();
            byte[] post = getQueryByteArray(query);

            //
            HttpURLConnection httpConnection = getHttpURLConnection(url, method);

            //
            DataOutputStream writer = new DataOutputStream(httpConnection.getOutputStream());
            writer.write(post);
            writer.flush();

            //
            readContent();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getResponseCode() throws IOException {
        return httpURLConnection.getResponseCode();
    }

    public String getResponseMessage() throws IOException {
        return httpURLConnection.getResponseMessage();
    }
}
