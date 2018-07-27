package client;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

public class NetClient {
    public static void main(String[] args) throws URISyntaxException, MalformedURLException {

        URI uri = new URI("https", "scanword-stage.smapps.net", "/rest/sync/ios", null);
        URL url = uri.toURL();

        Map<String, String> params = new LinkedHashMap<>();
        params.put("user_id", "3116963");
        params.put("auth_key", "110d770ef9f1e6d81c2dce7c7b224f26");
        params.put("vendor_id", "C9332507-6821-443E-BC09-0870A1BA1CB5");
        params.put("advertising_id", "00000000-0000-0000-0000-000000000000");
        params.put("advertising_track_enabled", "0");
        params.put("vendor_key", "67cfffb331dae540bdded988c35c136b");
        params.put("advertising_key", "575115c0a76bbc7cf76f331a9a933a0c");
        params.put("device_info", "ewogICJkZXZpY2VfaGVpZ2h0IiA6ICI1NjgiLAogICJhcHBfdmVyc2lvbiIgOiAiMS43LjE2IiwKICAibGFzdF9zeW5jX2luZXRfdHlwZSIgOiAibm9fc3luY190eXBlIiwKICAiYXBwX2J1aWxkIiA6ICI2MiIsCiAgImFkdmVydGlzaW5nX3RyYWNrX2VuYWJsZWQiIDogIjAiLAogICJkZXZpY2VfcGxhdGZvcm0iIDogImlQaG9uZTYsMSIsCiAgImF1dG9sb2FkX25ld19pc3N1ZXNfb24iIDogIjAiLAogICJkZXZpY2Vfc3lzdGVtX3ZlcnNpb24iIDogIjEwLjIiLAogICJsb2NhbGl6YXRpb24iIDogInJ1IiwKICAiaXNzdWVzX2xvYWRlZCIgOiAiMCIsCiAgImRldmljZV93aWR0aCIgOiAiMzIwIgp9");
        params.put("visit_id", "146bf9847a7913eb78ada4ed9f4f1b2c");
        params.put("request_id", "48036c76ca6b47d45b0b89c98204a220");
        params.put("updates", "ewogICJlOWM5ZmMyMTA2NmUzN2I1Y2YwYzY2ZmM4ZWJlNjI1OSIgOiB7CiAgICAidXVzIiA6IHsKICAgICAgInRtIiA6IDEKICAgIH0sCiAgICAiX3VvdCIgOiAxNTMyNDE5NTI2CiAgfSwKICAiNTU5OGQ0MzQ1N2E3YTFjNGY3Yjc3YTYxZmJhZWRmZDEiIDogewogICAgInV1cyIgOiB7CiAgICAgICJsYyIgOiAyLAogICAgICAibGYiIDogewogICAgICAgICJiYWNrZ3JvdW5kIiA6IDEKICAgICAgfQogICAgfSwKICAgICJfdW90IiA6IDE1MzI0MTk1MjUKICB9Cn0=");

        String query = new QueryBuilder().setQuery(params).toString();
        byte[] post = query.getBytes(StandardCharsets.UTF_8);

        try {
            url = new URL(url.toString());
            HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();

            httpConnection.setDoOutput(true);
            httpConnection.setRequestMethod("POST");
            httpConnection.setRequestProperty("User-Agent", "Java client");
            httpConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            DataOutputStream writer = new DataOutputStream(httpConnection.getOutputStream());
            writer.write(post);
            writer.flush();

            new ReadContent().readContent(httpConnection);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
