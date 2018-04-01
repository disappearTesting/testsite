package unitTests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Set;

public class Unit_Test {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("https://www.naukri.com/");
    }

    @Test
    public void test_Test() {
        String mainWindowHandle = driver.getWindowHandle();

        Set<String> allWindowHandles = driver.getWindowHandles();
        for(String currentWindowHandle : allWindowHandles) {
            if(!currentWindowHandle.equals(mainWindowHandle)) {
                driver.switchTo().window(currentWindowHandle);
                driver.close();
            }
        }

    }
}
