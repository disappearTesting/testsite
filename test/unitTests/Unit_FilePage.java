package unitTests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import pom.ExtentReportTest;
import pom.FilePage;
import pom.FirefoxProfileTestsite;
import pom.TestRunException;

import java.io.IOException;

public class Unit_FilePage {

    private static final String URL_FILE_PAGE = "http://testsite.local/rest/filePage/upload.php";
    private static final String UPLOAD_PATH = "C:\\Users\\Makarov_K\\IdeaProjects\\testsite\\rest\\filePage\\folderToUpload\\";

    private WebDriver driver;
    private FilePage objFile;
    private FirefoxProfileTestsite objProfile;
    private ExtentReportTest objReport;

    @Before
    public void setUp() {
        FirefoxProfile mprofile = objProfile.setFirefoxProfileDownloadSettings();
        driver = new FirefoxDriver((Capabilities) mprofile);
        objFile = new FilePage(driver);
        driver.get(URL_FILE_PAGE);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test_UploadFile_Success() throws InterruptedException, TestRunException, IOException {
        Assert.assertTrue(objFile.uploadFile_Success(UPLOAD_PATH, "fileToUpload.txt", "C:\\Users\\Makarov_K\\IdeaProjects\\testsite\\rest\\filePage\\uploadFile_Success.exe"));
    }

    @Test
    public void test() throws InterruptedException, TestRunException, IOException {
        objFile.downloadFile_Success();
    }
}