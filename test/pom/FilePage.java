package pom;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.FieldAccessor_Short;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;

public class FilePage {

    private WebDriver driver;

    private static By buttonBrowseFile = By.id("button-browse-file");
    private static By buttonUploadFile = By.id("button-upload-file");

    public FilePage(WebDriver driver) {
        this.driver = driver;
    }

    //logical method
    private boolean checkExistingFile(String path, String filename) {
        File file = new File(path + filename);
        return file.exists() && file.isFile();
    }

    //logical method
    private void selectTheFile_WindowsFileUploadDialog_UseAutoItScript(WebElement element, String script) throws InterruptedException, IOException, TestRunException {
        if(element != null && element.isEnabled()) {
            element.click();
            Thread.sleep(5000);
            Runtime.getRuntime().exec(script);
        } else {
            throw new TestRunException("selectTheFile_WindowsFileUploadDialog_UseAutoItScript(). Error, element is null or is't enabled");
        }
    }

    //action method
    public boolean uploadFile_Success(String path, String filename, String script) throws InterruptedException, TestRunException, IOException {
        WebElement buttonBrowse = driver.findElement(buttonBrowseFile);
        WebElement buttonUpload = driver.findElement(buttonUploadFile);
        selectTheFile_WindowsFileUploadDialog_UseAutoItScript(buttonBrowse, script);
        Thread.sleep(5000);
        buttonUpload.click();
        return checkExistingFile(path, filename);
    }

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://testsite.local/rest/filePage/upload.php");
        WebElement element = driver.findElement(By.id("button-upload-file"));
        Actions builder = new Actions(driver);
        builder.moveToElement(element).click();

    }
}
