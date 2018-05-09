package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
    private void executeAutoItScript(String script) throws IOException {
        Runtime.getRuntime().exec(script);
    }

    //logical method
    private boolean checkExistingFile(String path, String filename) {
        File file = new File(path + filename);
        return file.exists() && file.isFile();
    }

    //action method
    public boolean uploadFile_useAutoItScript(String path, String filename, String script) throws InterruptedException, IOException {
        WebElement buttonBrowse = driver.findElement(buttonBrowseFile);
        WebElement buttonUpload = driver.findElement(buttonUploadFile);
        buttonBrowse.click();
        Thread.sleep(3000);
        executeAutoItScript(script);
        Thread.sleep(3000);
        buttonUpload.click();
        return checkExistingFile(path, filename);
    }
}
