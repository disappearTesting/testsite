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
}
