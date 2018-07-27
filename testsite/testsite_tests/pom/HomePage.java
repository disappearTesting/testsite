/**
 * @author hookie
 * @version 1.0
 */
package pom;

import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkLoginSuccess(String userCredentials) {
        return driver.getPageSource().contains(userCredentials);
    }
}
