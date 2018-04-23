package unitTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Resizable {
    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub

        WebDriver driver = new FirefoxDriver();

        driver.get("https://jqueryui.com/resizable/");
        driver.manage().window().maximize();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
//Locate resizable element's bottom-right corner.
        WebElement resizeElement = driver.findElement(By.xpath("//*[@id='resizable']/div[3]"));
        //*[@id="resizable"]/div[3]

        //To resize jQuery resizable element by 250 pixel X,Y offset using dragAndDropBy method of Actions class.
        new Actions(driver).dragAndDropBy(resizeElement, 250, 250).build().perform();
        Thread.sleep(5000);

        //After 5 seconds, This will resize jQuery resizable element by -100 pixel X,Y offset using the combination of clickAndHold, moveByOffset and release methods of Actions class.
        new Actions(driver).clickAndHold(resizeElement).moveByOffset(-100,-100).release().perform();
    }
}