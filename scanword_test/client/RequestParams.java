package test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RequestParams {

    // logical method
    private StringBuffer defineRequestParams(Map<String, String> params) {
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

    // action method
    public StringBuffer setRequestParams(Map<String, String> params) {
        return defineRequestParams(params);
    }
}