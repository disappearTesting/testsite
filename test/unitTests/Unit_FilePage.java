package unitTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pom.ExtentReportTest;
import pom.FilePage;

public class Unit_FilePage {

    private WebDriver driver;

    private FilePage objFile;
    private ExtentReportTest objReport;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        objFile = new FilePage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
