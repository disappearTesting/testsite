package pom;

import org.json.simple.JSONObject;
import java.util.Random;

public class FB_SendNotification_Invite {

    private final String user_app_id = "100015487932490";
    private final String app_id = "1871073982907351";
    private final String fb_dtsg = "AQFl2ok_73Ut:AQG9K3igxSqv";
    private final String redirect_url = "https://www.facebook.com/dialog/return/arbiter#origin=https%3A%2F%2Fbottle.smapps.org%2Fapp%2Ffb%2F";
    private final String fallback_redirect_uri = "https://bottle.smapps.org/app/fb/";

    private String getEncodedState() {
        String alphanumeric = "abcdefghijklmnopqrstuvwxyz0123456789";
        int stringLength = 14;
        StringBuilder randStr = new StringBuilder();
        for(int i = 0; i < stringLength; i++){
            int number = new Random().nextInt(alphanumeric.length());
            char ch = alphanumeric.charAt(number);
            randStr.append(ch);
        }
        return randStr.toString();
    }
    private String encoded_state = getEncodedState();

    private Object getE2e() {
        JSONObject object = new JSONObject();
        object.put("submit_0", "1531854395431");
        return object;
    }
    private String e2e = getE2e().toString();

    private static final String MESSAGE = "Wanna play together? You’ll definitely make new friends!";

    private int data_id = 44;
    private String data = "tid|" + data_id;

    private String frictionless = "";

    private String inviteableFriendId = "100015538898268";
    private Object getProfileChooserItems() {
        JSONObject object = new JSONObject();
        object.put(inviteableFriendId, true);
        return object;
    }
    private String profileChooserItems = getProfileChooserItems().toString();

    private String getSignature() {
        String numeric = "0123456789";
        int stringLength = 19;
        StringBuilder randInt = new StringBuilder();
        for(int i = 0; i < stringLength; i++) {
            int number = new Random().nextInt(numeric.length());
            char ch = numeric.charAt(number);
            randInt.append(ch);
        }
        return randInt.toString();
    }
    private String signature = getSignature();

    private String egoLoggingSignature = user_app_id + "-" + app_id + "-" + signature;

    // some unchangeable params
    private final String display = "async";
    private String access_token = "";
    private final String sdk = "joey";
    private int from_post = 1;
    private final int __CONFIRM__ = 1;
    private final int __a = 1;
    private String __dyn = "5V4cjJLyGmaWxd2u6aEyzGomzFEuzVbGAdy8Z9LFwxx" + "-" + "6ES2N6wAxu13wFGEa8Gm4UJi28rxuF98CUOuVWxeUW2y4GDgdUHzomAx6USbAqwzxvDx2UO49e5o5aayrzE9ohxG18U8o8k3GEqF3FK5ESq2e2ut5wDAwGwYypUhKHxCq4okGm8xC784a5olyoK7Uy5UGdyU4e4ebzef" + "-" + "EOUx5wKK2acGdhUgV8O9wyQu9z8ynxdy8OdAh8GcBzXxCfxbCyHxqcwGwwzqGu2K64mbyUOmHDKiFUa8aoCubK";
    private String __req = "9d";
    private final int __be = -1;
    private final String __pc = "PHASED:DEFAULT";
    private final int __rev = 4109503;
    private final String jazoest = "265817271531071199766110106885865817183728110411582515389";
    private final int __spin_r = 4109503;
    private final String __spin_b = "trunk";
    private final String __spin_t = "1531838330";

    private String getURL() {
        String URL = "https://apps.facebook.com/v3.0/dialog/app_requests/submit?dpr=1?";
        String URI = fb_dtsg.concat(app_id).concat(redirect_url).concat(fallback_redirect_uri)
                .concat(display).concat(access_token).concat(sdk).concat(String.valueOf(from_post)).concat(encoded_state).concat(e2e).concat(MESSAGE)
                .concat(data).concat(frictionless).concat(profileChooserItems).concat(egoLoggingSignature).concat(String.valueOf(__CONFIRM__))
                .concat(user_app_id).concat(String.valueOf(__a)).concat(__dyn).concat(__req).concat(String.valueOf(__be)).concat(__pc)
                .concat(String.valueOf(__rev)).concat(jazoest).concat(String.valueOf(__spin_r)).concat(String.valueOf(__spin_b)).concat(String.valueOf(__spin_t));
        String result = URL.concat(URI);
        return result;
    }

    public static void main(String[] args) {

    }
}