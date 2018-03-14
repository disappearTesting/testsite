/**
 * @author hookie
 * @version 1.0
 */
package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.ArrayList;
import java.util.List;

public class DatetimeKendoUIPage {

    private WebDriver driver;

    private By inputDateTime = By.id("input-datetime");
    private By iconDatetime = By.xpath("/html/body/div[1]/content/form/fieldset/div[1]/div/span[2]");
    private By iconRemoveDatetime = By.xpath("/html/body/div[1]/content/form/fieldset/div[1]/div/span[1]");
    private By thSwitchDatetime_div3 = By.xpath("/html/body/div[2]/div[3]/table/thead/tr[1]/th[2]");
    private By thSwitchDatetime_div4 = By.xpath("/html/body/div[2]/div[4]/table/thead/tr/th[2]");
    private By thSwitchDatetime_div5 = By.xpath("/html/body/div[2]/div[5]/table/thead/tr/th[2]");
    private By thNextDatetime_div3 = By.xpath("/html/body/div[2]/div[3]/table/thead/tr[1]/th[3]");
    private By thNextDatetime_div4 = By.xpath("/html/body/div[2]/div[4]/table/thead/tr/th[3]");
    private By thNextDatetime_div5 = By.xpath("/html/body/div[2]/div[5]/table/thead/tr/th[3]/i");
    private By thPreviousDatetime_div3 = By.xpath("/html/body/div[2]/div[3]/table/thead/tr[1]/th[1]/i");
    private By thPreviousDatetime_div4 = By.xpath("/html/body/div[2]/div[4]/table/thead/tr/th[1]/i");
    private By thPreviousDatetime_div5 = By.xpath("/html/body/div[2]/div[5]/table/thead/tr/th[1]");
    private By thTodayDatetime = By.xpath("/html/body/div[2]/div[3]/table/tfoot/tr[1]/th");
    private By legendMarkerAM = By.xpath("/html/body/div[2]/div[2]/table/tbody/tr/td/fieldset[1]/legend");
    private By legendMarkerPM = By.xpath("/html/body/div[2]/div[2]/table/tbody/tr/td/fieldset[2]/legend");

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
        elementsDatetimeDropdownMenu.add(driver.findElement(thSwitchDatetime_div3));
        elementsDatetimeDropdownMenu.add(driver.findElement(thNextDatetime_div3));
        elementsDatetimeDropdownMenu.add(driver.findElement(thPreviousDatetime_div3));

        return elementsDatetimeDropdownMenu;
    }

    public String getTodayDatetime() {
        driver.findElement(iconDatetime).click();
        driver.findElement(thTodayDatetime).click();
        String currentDatetime = driver.findElement(inputDateTime).getAttribute("value");
        return currentDatetime;
    }

    public boolean selectTimeDatetime(String marker, String hour, String minute) {
        // use this method after selected Day
        boolean result = false;
        String markerAM = driver.findElement(legendMarkerAM).getText();
        String markerPM = driver.findElement(legendMarkerPM).getText();
        List<WebElement> columnsHourAM = driver.findElements(By.className("hour_AM"));
        List<WebElement> columnsHourPM = driver.findElements(By.className("hour_PM"));
        List<WebElement> columnsMinute = driver.findElements(By.className("minute"));
        if(marker.equals(markerAM)) {
            for(WebElement cellHourAM : columnsHourAM) {
                if(cellHourAM.getText().equals(hour)) {
                    cellHourAM.click();
                    result = true;
                    break;
                }
            }
            for(WebElement cellMinute : columnsMinute) {
                String[] arrayRangeMinute = cellMinute.getText().split(":");
                String rangeMinute = arrayRangeMinute[1];
                if(minute.equals(rangeMinute)) {
                    cellMinute.click();
                    result = true;
                    break;
                }
            }
        } else if(marker.equals(markerPM)) {
            for(WebElement cellHourPM : columnsHourPM) {
                if(cellHourPM.getText().equals(hour)) {
                    cellHourPM.click();
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    public boolean selectDayDatetime(String day) {
        // use this method after selected Month
        boolean result = false;
        List<WebElement> columnsDay = driver.findElements(By.tagName("td"));
        for(WebElement cellDay: columnsDay) {
            if (cellDay.getText().equals(day)) {
                cellDay.click();
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean selectMonthDatetime(String month) {
        // use this method after selected Year
        boolean result = false;
        List<WebElement> columnsMonth = driver.findElements(By.tagName("span"));
        for(WebElement cellMonth : columnsMonth) {
            if(cellMonth.getText().equals(month)) {
                cellMonth.click();
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean selectYearDatetime(String year) {
        boolean result = false;
        driver.findElement(thSwitchDatetime_div3).click();
        String currentYear = driver.findElement(thSwitchDatetime_div4).getText();
        if(!year.equals(currentYear)) {
            driver.findElement(thSwitchDatetime_div4).click();
            String rangeDatetime = driver.findElement(thSwitchDatetime_div5).getText();
            String[] arrayRangeYear = rangeDatetime.split("-");
            String minYear = arrayRangeYear[0];
            String maxYear = arrayRangeYear[1];
            if(Integer.parseInt(year) > Integer.parseInt(maxYear)) {
                do {
                    driver.findElement(thNextDatetime_div5).click();
                    rangeDatetime = driver.findElement(thSwitchDatetime_div5).getText();
                    arrayRangeYear = rangeDatetime.split("-");
                    maxYear = arrayRangeYear[1];
                } while (Integer.parseInt(year) == Integer.parseInt(maxYear));
                List<WebElement> columnsYear = driver.findElements(By.tagName("span"));
                for(WebElement cellYear : columnsYear) {
                    if(cellYear.getText().equals(year)) {
                        cellYear.click();
                        result = true;
                        break;
                    }
                }
            } else if(Integer.parseInt(year) < Integer.parseInt(minYear)) {
                do {
                    driver.findElement(thPreviousDatetime_div5).click();
                    rangeDatetime = driver.findElement(thSwitchDatetime_div5).getText();
                    arrayRangeYear = rangeDatetime.split("-");
                    minYear = arrayRangeYear[0];
                } while (Integer.parseInt(year) == Integer.parseInt(minYear));
                List<WebElement> columnsYear = driver.findElements(By.tagName("span"));
                for(WebElement cellYear : columnsYear) {
                    if(cellYear.getText().equals(year)) {
                        cellYear.click();
                        result = true;
                        break;
                    }
                }
            }
        }
        return result;
    }
}