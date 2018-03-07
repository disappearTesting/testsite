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

    public void getDatetimeDropdownMenu() {
        driver.findElement(iconDatetime).click();
    }

    public void removeDatetime() {
        driver.findElement(iconRemoveDatetime).click();
    }

    public List<WebElement> getElementsDatetimeDropdownMenu() {

        List<WebElement> elementsDatetimeDropdownMenu = new ArrayList();
        elementsDatetimeDropdownMenu.add(driver.findElement(thSwitchDatetime));
        elementsDatetimeDropdownMenu.add(driver.findElement(thNextDatetime));
        elementsDatetimeDropdownMenu.add(driver.findElement(thPreviousDatetime));

        return elementsDatetimeDropdownMenu;
    }

    public String getTodayDatetime() {
        driver.findElement(iconDatetime).click();
        driver.findElement(thTodayDatetime).click();
        String currentDatetime = driver.findElement(inputDateTime).getAttribute("value");
        return currentDatetime;
    }

    public void selectDay(String day) {
        // use this method after selected Month
        List<WebElement> columnsDay = driver.findElements(By.tagName("td"));
        for(WebElement cellDay: columnsDay) {
            if(cellDay.getText().equals(day)) {
                cellDay.click();
                break;
            }
        }
    }

    public void selectMonth(String month) {
        // use this method after selected Year
        List<WebElement> columnsMonth = driver.findElements(By.tagName("span"));
        for(WebElement cellMonth : columnsMonth) {
            if(cellMonth.getText().equals(month)) {
                cellMonth.click();
                break;
            }
        }
    }

    public void selectYearDatetime(String year) {
        driver.findElement(thSwitchDatetime).click();
        String currentYear = driver.findElement(thSwitchDatetime).getAttribute("value");
        if(!year.equals(currentYear)) {
            driver.findElement(thSwitchDatetime).click();
            String rangeDatetime = driver.findElement(thSwitchDatetime).getAttribute("value");
            String[] arrayRangeYear = rangeDatetime.split("-");
            String minYear = arrayRangeYear[0];
            String maxYear = arrayRangeYear[1];
            if(Integer.parseInt(year) > Integer.parseInt(maxYear)) {
                do {
                    driver.findElement(thNextDatetime).click();
                    rangeDatetime = driver.findElement(thSwitchDatetime).getAttribute("value");
                    arrayRangeYear = rangeDatetime.split("-");
                    maxYear = arrayRangeYear[1];
                } while (Integer.parseInt(year) == Integer.parseInt(maxYear));
                List<WebElement> columnsYear = driver.findElements(By.tagName("span"));
                for(WebElement cellYear : columnsYear) {
                    if(cellYear.getText().equals(year)) {
                        cellYear.click();
                        break;
                    }
                }
            } else {
                do {
                    driver.findElement(thPreviousDatetime).click();
                    rangeDatetime = driver.findElement(thSwitchDatetime).getAttribute("value");
                    arrayRangeYear = rangeDatetime.split("-");
                    minYear = arrayRangeYear[0];
                } while (Integer.parseInt(year) == Integer.parseInt(minYear));
                List<WebElement> columnsYear = driver.findElements(By.tagName("span"));
                for(WebElement cellYear : columnsYear) {
                    if(cellYear.getText().equals(year)) {
                        cellYear.click();
                        break;
                    }
                }
            }
        }
    }
}