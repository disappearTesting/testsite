/**
 * @author hookie
 * @version 1.0
 */
package pom;

import org.openqa.selenium.*;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
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

    public boolean getWindow(String typeWindow) {
        boolean windowIsOpen = false;
        switch (typeWindow) {
            case "blank" :
                try {
                    driver.findElement(textBlankWindow).click();
                    windowIsOpen = true;
                    break;
                } catch (NoSuchElementException e) {
                    e.printStackTrace();
                } catch (InvalidElementStateException e) {
                    e.printStackTrace();
                }
            case "self" :
                try {
                    driver.findElement(textSelfWindow).click();
                    windowIsOpen = true;
                    break;
                } catch (NoSuchElementException e) {
                    e.printStackTrace();
                } catch (InvalidElementStateException e) {
                    e.printStackTrace();
                }
            case "new" :
                try {
                    driver.findElement(textNewWindow).click();
                    windowIsOpen = true;
                    break;
                } catch (NoSuchElementException e) {
                    e.printStackTrace();
                } catch (InvalidElementStateException e) {
                    e.printStackTrace();
                }
        }
        return windowIsOpen;
    }

    public boolean getParentkWindow(String parentWindowHandle, String urlParentWindow) {
        boolean result = false;
        Set<String> allWindowHandles = driver.getWindowHandles();
        if(allWindowHandles.size() > 1) {
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
        } else {
            driver.navigate().to(urlParentWindow);
            result = true;
        }

        return result;
    }
}
