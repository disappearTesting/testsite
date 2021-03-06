/**
 * @author hookie
 * @version 1.0
 */
package seleniumExamples;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Selenium_LoginPageUseMobProxy {

    private static final String URL = "http://testsite.local/testsite_resources/loginPage/login.php";

    public static void main(String[] args) {
        BrowserMobProxy proxy = new BrowserMobProxyServer();
        proxy.start(0);

        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

        WebDriver driver = new FirefoxDriver(capabilities);
        driver.get(URL);

        pom.LoginPage objLogin = new pom.LoginPage(driver);
        objLogin.loginSetEmailPassword("makarov@smartproject.ua", "123456");

        driver.quit();
    }
}