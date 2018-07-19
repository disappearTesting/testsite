package pom;

import org.json.simple.JSONObject;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Random;

import static java.util.Locale.ENGLISH;

public class FB_SendNotification_Invite {

    private final String user_app_id = "100015487932490";
    private final String app_id = "1871073982907351";
    private final String fb_dtsg = "AQFl2ok_73Ut:AQG9K3igxSqv";
    private final String redirect_url = "https://www.facebook.com/dialog/return/arbiter#origin=https%3A%2F%2Fbottle.smapps.org%2Fapp%2Ffb%2F";
    private final String fallback_redirect_uri = "https://bottle.smapps.org/app/fb/";

    private String encoded_state = "fa9fd468ee69bc";

    private JSONObject e2e = new JSONObject();
    private Object getE2e() {
        return e2e.put("submit_0", "1531854395431");
    }

    private static final String MESSAGE = "Wanna play together? You’ll definitely make new friends!";

    private int data_id = 44;
    private String data = "tid|" + data_id;

    private String frictionless = "";

    private String inviteableFriendId = "100015538898268";
    private JSONObject profileChooserItems = new JSONObject();
    private Object getProfileChooserItems() {
        return profileChooserItems.put(inviteableFriendId, true);
    }

    private String signature = "6579488546570717286";
    private String egoLoggingSignature = user_app_id + "-" + app_id + "-" + signature;

    // some unchangeable params
    private final String display = "async";
    private String access_token = "";
    private final String sdk = "joey";
    private int from_post = 1;
    private final int __CONFIRM = 1;
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

    public static void main(String[] args) {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array);
        System.out.println(generatedString);
    }
}
