package test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RequestParams {

    private String key;
    private String value;

    private RequestParams(String key, String value) {
        this.key = key;
        this.value = value;
    }

    private Map<String, String> defineParams() {
        Map<String, String> mapParams = new HashMap<>();
        mapParams.put(key,value);
        return mapParams;
    }

    private StringBuffer setParams() {
        Map<String, String> map = defineParams();
        StringBuffer requestParams = new StringBuffer();
        Iterator<String> iterator = map.keySet().iterator();
        while(iterator.hasNext()) {
            try {
                String key = iterator.next();
                String value = map.get(key);
                requestParams.append(URLEncoder.encode(key, "UTF-8"));
                requestParams.append("=").append(
                        URLEncoder.encode(value, "UTF-8"));
                requestParams.append("&");
                System.out.println(requestParams);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return requestParams;
    }

    public static void main(String[] args) {
        new RequestParams("user_id","3116818").setParams();
    }
}