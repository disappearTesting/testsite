/**
 * @author hookie
 * @version 1.0
 */
package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class WindowPage {

    private WebDriver driver;

    private By textBlankWindow = By.linkText("_blank-window");
    private By textSelfWindow = By.linkText("_self-window");
    private By textNewWindow = By.linkText("_new-window");
    private By textIFrameWindow = By.linkText("_iframe-window");

    public WindowPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<Object> getParamsCurrentWindow() {
        List<Object> params = Arrays.asList(driver.getCurrentUrl(), driver.getTitle(), driver.getWindowHandle());
        return params;
    }
}
