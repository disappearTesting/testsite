/**
 * @author hookie
 * @version 1.0
 */
package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DatetimePage {

    private WebDriver driver;

    private By inputDateTime = By.id("input-datetime");
    private By inputDate = By.id("input-date");
    private By inputTime = By.id("input-time");

    public DatetimePage(WebDriver driver) {
        this.driver = driver;
    }

    public void setDateTime(String datetime) {
        WebElement element = driver.findElement(inputDateTime);
        element.sendKeys(datetime);
    }

    public void setDate(String date) {
        WebElement element = driver.findElement(inputDate);
        element.sendKeys(date);
    }

    public void setTime(String time) {
        WebElement element = driver.findElement(inputTime);
        element.sendKeys(time);
    }
}
