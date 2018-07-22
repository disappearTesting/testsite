package test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RequestParams {

    private Map<String, String> mapParams;

    private Map<String, String> defineParams() {
        mapParams = new HashMap<String, String>();
        mapParams.put("user_id","3116818");
        return mapParams;
    }

    private StringBuffer setParams() {
        Map<String, String> map = defineParams();
        StringBuffer requestParams = new StringBuffer();
        Iterator<String> iterator = map.keySet().iterator();
        requestParams.
    }
}
