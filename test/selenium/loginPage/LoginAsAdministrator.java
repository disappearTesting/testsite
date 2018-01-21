/**
 * @author hookie
 * @version 1.0
 */
package selenium.loginPage;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import pom.PomLogin;

public class LoginAsAdministrator {

    private static final String URL = "http://testsite.local/rest/loginPage/login.php";

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

        PomLogin objLogin = new PomLogin(driver);
        objLogin.loginSetNamePassword("test1", "123456");

        //  driver.quit();
    }
}
