package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class FilePage {

    private WebDriver driver;

    private static By buttonBrowseFile = By.id("button-browse-file");
    private static By buttonUploadFile = By.id("button-upload-file");
    private static By aDownloadFile = By.id("a-download-file");

    public FilePage(WebDriver driver) {
        this.driver = driver;
    }

    //logical method
    private boolean checkExistingFile(String path, String filename) {
        File file = new File(path + filename);
        return file.exists() && file.isFile();
    }

    //logical method
    private void selectTheFile_WindowsFileDialog_UseAutoItScript(WebElement element, String script) throws InterruptedException, IOException, TestRunException {
        if(element != null && element.isEnabled()) {
            element.click();
            Runtime.getRuntime().exec(script);
        } else {
            throw new TestRunException("selectTheFile_WindowsFileUploadDialog_UseAutoItScript(). Error, element is null or is't enabled");
        }
    }

    //action method
    public boolean uploadFile_Success(String path, String filename, String script) throws InterruptedException, TestRunException, IOException {
        WebElement buttonBrowse = driver.findElement(buttonBrowseFile);
        WebElement buttonUpload = driver.findElement(buttonUploadFile);
        selectTheFile_WindowsFileDialog_UseAutoItScript(buttonBrowse, script);
        new WebDriverWait(driver, 5).until(ExpectedConditions.textToBePresentInElementValue(buttonBrowse, filename));
        buttonUpload.click();
        return checkExistingFile(path, filename);
    }

    //action method
    public boolean downloadFile_Success(String script) throws InterruptedException, TestRunException, IOException {
        WebElement aDownload = driver.findElement(aDownloadFile);
        selectTheFile_WindowsFileDialog_UseAutoItScript(aDownload, script);
        return false;
    }
}
