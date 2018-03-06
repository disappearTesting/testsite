/**
 * @author hookie
 * @version 1.0
 */
package pom;

import org.openqa.selenium.WebDriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CurrentDatetimePage {

    private WebDriver driver;

    public CurrentDatetimePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCurrentDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy - hh:mm a", Locale.ENGLISH);
        Date date = new Date();
        return dateFormat.format(date);
    }

    public void splitDatetime(String datetime) {
        // dd MMMM yyyy - hh:mm a
        String[] arrayDatetime = datetime.split("\\s");
        String day = arrayDatetime[0];
        String month = arrayDatetime[1];
        String year = arrayDatetime[2];
        String time = arrayDatetime[4];
        String marker = arrayDatetime[5];
    }
}
