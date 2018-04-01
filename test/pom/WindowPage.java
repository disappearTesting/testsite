/**
 * @author hookie
 * @version 1.0
 */
package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class WindowPage {

    private static final String URL_WINDOW_INDEX_PAGE = "http://testsite.local/rest/windowPage/index.php";
    private static final String URL_WINDOW_MAIN_PAGE = "http://testsite.local/rest/windowPage/main.php";
    private static final String URL_WINDOW_HOME_PAGE = "http://testsite.local/rest/windowPage/home.php";

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

    public String getParentWindowHandle() {
        return driver.getWindowHandle();
    }

    public boolean getBlankWindow() {
        boolean windowIsOpen = false;
        if(driver.findElement(textBlankWindow).isEnabled()) {
            try {
                driver.findElement(textBlankWindow).click();
                windowIsOpen = true;
            } catch (ElementClickInterceptedException e) {
                e.printStackTrace();
            }
        }
        return windowIsOpen;
    }

    public boolean getBlankWindowHandle(String parentWindowHandle) {
        boolean result = false;
            Set<String> allWindowHandles = driver.getWindowHandles();
            for (String currentWindowHandle : allWindowHandles) {
                if (!currentWindowHandle.equals(parentWindowHandle)) {
                    driver.switchTo().window(currentWindowHandle);
                    driver.close();
                }
            }

            try {
                driver.switchTo().window(parentWindowHandle);
                result = true;
            } catch (NoSuchWindowException e) {
                e.printStackTrace();
            }
        return result;
    }
}
