package unitTests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import pom.ExtentReportTest;
import pom.FilePage;
import pom.FirefoxProfileTestsite;
import pom.TestRunException;

import java.io.IOException;

public class Unit_FilePage {

    private static final String URL_FILE_PAGE = "http://testsite.local/rest/filePage/index.php";
    private static final String UPLOAD_FILENAME = "fileToUpload.txt";
    private static final String UPLOAD_PATH = "C:\\Users\\Makarov_K\\IdeaProjects\\testsite\\rest\\filePage\\folderToUpload\\";
    private static final String UPLOAD_SCRIPT_PATH = "C:\\Users\\Makarov_K\\IdeaProjects\\testsite\\rest\\filePage\\uploadFile_Success.exe";
    private static final String DOWNLOAD_FILENAME = "fileToDownload.txt";
    private static final String DOWNLOAD_PATH = "C:\\Users\\hookie\\IdeaProjects\\testsite\\rest\\filePage\\test\\";
    private static final String FIREFOX_PROFILE_FILENAME = "FirefoxProfileTestsite";

    private WebDriver driver;
    private FilePage objFile;
    private FirefoxProfile profile;
    private FirefoxOptions options;
    private FirefoxProfileTestsite objProfile;
    private ExtentReportTest objReport;

    @Before
    public void setUp() {
        objProfile = new FirefoxProfileTestsite(profile, options);
        options = objProfile.getOptions_SkipDownloadDialog_FileType_TXT(FIREFOX_PROFILE_FILENAME, DOWNLOAD_PATH);
        driver = new FirefoxDriver(options);
        objFile = new FilePage(driver);
        driver.get(URL_FILE_PAGE);
    }

    @After
    public void tearDown() {
        //driver.quit();
    }

    @Test
    public void test_UploadFile_Success() throws InterruptedException, TestRunException, IOException {
        Assert.assertTrue(objFile.uploadFile_Success(UPLOAD_PATH, UPLOAD_FILENAME, UPLOAD_SCRIPT_PATH));
    }

    @Test
    public void test_DownloadFile_TXT_Success() {
        //objProfile.getOptions_SkipDownloadDialog_FileType_TXT(FIREFOX_PROFILE_FILENAME, DOWNLOAD_PATH);
        Assert.assertTrue(objFile.downloadFile_TXT_Success(DOWNLOAD_PATH, DOWNLOAD_FILENAME));
    }
}