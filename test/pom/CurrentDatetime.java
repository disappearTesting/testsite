/**
 * @author hookie
 * @version 1.0
 */
package pom;

import org.openqa.selenium.WebDriver;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;

public class CurrentDatetime {

    private WebDriver driver;

    public CurrentDatetime(WebDriver driver) {
        this.driver = driver;
    }

    public String getCurrentDatetime() {
        DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy - hh:mm a", Locale.ENGLISH);
        Date date = new Date();
        String currentDatetime = dateFormat.format(date);
        return currentDatetime;
    }
}
