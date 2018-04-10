package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

    private static By inputEmail = By.name("email");
    private static By inputPassword = By.name("password");
    private static By buttonSignIn = By.name("btn-login");

    private WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public Login enterUserEmail(String email) {
        driver.findElement(inputEmail).sendKeys(email);
        return this;
    }

    public Login enterUserPassword(String password) {
        driver.findElement(inputPassword).sendKeys(password);
        return this;
    }

    public HomePage submitLoginCredentials() {
        driver.findElement(buttonSignIn).click();
        return new HomePage(driver);
    }

    private class A {
        public A() {
            HomePage homePage = new Login(null)
                    .enterUserEmail("")
                    .enterUserPassword("")
                    .submitLoginCredentials();
        }
    }
}
