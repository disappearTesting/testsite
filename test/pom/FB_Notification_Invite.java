package pom;

import org.json.simple.JSONObject;

public class FB_Notification_Invite {

    private final String fb_dtsg = "AQFl2ok_73Ut:AQG9K3igxSqv";
    private final String app_id = "1871073982907351";
    private final String redirect_url = "https://www.facebook.com/dialog/return/arbiter#origin=https%3A%2F%2Fbottle.smapps.org%2Fapp%2Ffb%2F";
    private final String fallback_redirect_uri = "https://bottle.smapps.org/app/fb/";
    private final String display = "async";
    private final String access_token = "";
    private final String sdk = "joey";
    private int from_post = 1;
    private String encoded_state;

    private JSONObject e2e = new JSONObject();
    private Object getE2e() {
        return e2e.put("submit_0", "1531854395431");
    }

    private static final String message = "Wanna play together? You’ll definitely make new friends!";

    private int dataId;
    public int getDataId(int id) {
        if(dataId < id) {
            dataId++;
        }
        return dataId;
    }
    private String data = "tid|" + dataId;

    public static void main(String[] args) {

    }
}
