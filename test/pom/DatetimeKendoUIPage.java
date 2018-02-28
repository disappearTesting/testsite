/**
 * @author hookie
 * @version 1.0
 */
package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DatetimeKendoUIPage {

    private WebDriver driver;

    private By inputDateTime = By.id("input-datetime");
    private By iconDatetime = By.xpath("/html/body/div[1]/content/form/fieldset/div[1]/div/span[2]");
    private By iconRemoveDatetime = By.xpath("/html/body/div[1]/content/form/fieldset/div[1]/div/span[1]");
    private By thSwitchDatetime = By.xpath("/html/body/div[2]/div[3]/table/thead/tr[1]/th[2]");
    private By thNextDatetime = By.xpath("/html/body/div[2]/div[3]/table/thead/tr[1]/th[3]");
    private By thPreviousDatetime = By.xpath("/html/body/div[2]/div[3]/table/thead/tr[1]/th[1]");
    private By thTodayDatetime = By.xpath("/html/body/div[2]/div[3]/table/tfoot/tr[1]/th");

    private By inputDate = By.id("input-date");
    private By iconDate = By.xpath("/html/body/div[1]/content/form/fieldset/div[2]/div/span[2]");

    private By inputTime = By.id("input-time");
    private By iconTime = By.xpath("/html/body/div[1]/content/form/fieldset/div[3]/div/span[2]");

    public DatetimeKendoUIPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getInputDateTime() {
        return inputDateTime;
    }

    public By getIconDatetime() {
        return iconDatetime;
    }

    public List<WebElement> getElementsDatetimeDropdownMenu() {

        List<WebElement> elementsDatetimeDropdownMenu = new ArrayList();
        elementsDatetimeDropdownMenu.add(driver.findElement(iconRemoveDatetime));
        elementsDatetimeDropdownMenu.add(driver.findElement(thSwitchDatetime));
        elementsDatetimeDropdownMenu.add(driver.findElement(thNextDatetime));
        elementsDatetimeDropdownMenu.add(driver.findElement(thPreviousDatetime));
        elementsDatetimeDropdownMenu.add(driver.findElement(thTodayDatetime));

        return elementsDatetimeDropdownMenu;
    }
}