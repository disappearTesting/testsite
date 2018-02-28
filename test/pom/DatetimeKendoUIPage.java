/**
 * @author hookie
 * @version 1.0
 */
package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DatetimeKendoUIPage {

    private WebDriver driver;

    private By inputDateTime = By.id("input-datetime");
    private By inputDate = By.id("input-date");
    private By inputTime = By.id("input-time");

    private By datetimeDropdownMenu = By.xpath("/html/body/div[1]/content/form/fieldset/div[1]/div/span[2]");
    private By datetDropdownMenu = By.xpath("/html/body/div[1]/content/form/fieldset/div[2]/div/span[2]");
    private By timetDropdownMenu = By.xpath("/html/body/div[1]/content/form/fieldset/div[3]/div/span[2]");

    public DatetimeKendoUIPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getInputDateTime() {
        return inputDateTime;
    }

    public By getInputDate() {
        return inputDate;
    }

    public By getInputTime() {
        return inputTime;
    }

    public By getDatetimeDropdownMenu() {
        return datetimeDropdownMenu;
    }

    public By getDatetDropdownMenu() {
        return datetDropdownMenu;
    }

    public By getTimetDropdownMenu() {
        return timetDropdownMenu;
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
