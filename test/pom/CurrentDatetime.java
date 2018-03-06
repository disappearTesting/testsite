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
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

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

    public void getSplitDatetime(String datetime) {
        String[] arrayDatetime = datetime.split("\\s+");
        String day = arrayDatetime[0];
        String month = arrayDatetime[1];
        String year = arrayDatetime[2];
        String time = arrayDatetime[4];
        String marker = arrayDatetime[5];
    }
}
