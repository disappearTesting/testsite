/**
* @author hookie
* @version 1.0
*/
package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class UploadFilePage {

    private WebDriver driver;
    private String path;
    private By inputFile = By.name("uploadfile");
    private By inputSubmit = By.name("upload");

    public UploadFilePage(WebDriver driver) {
        this.driver = driver;
    }

    private File setFile(String path) {
        return new File(path);
    }

    private void choiceUploadFile(String path) {
        driver.findElement(inputFile).sendKeys(setFile(path).getAbsolutePath());
    }

    private void clickUploadFile() {
        driver.findElement(inputSubmit).click();
    }

    public void uploadFile(String path) {
        this.setFile(path);
        this.choiceUploadFile(path);
        this.clickUploadFile();
    }
}
