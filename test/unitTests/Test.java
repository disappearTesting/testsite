package unitTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Test {

    public static void main(String[] args) {
//        ProfilesIni profileIn = new ProfilesIni();
//        FirefoxProfile profile = profileIn.getProfile("FirefoxProfileTestsite");
//        profile.setPreference("browser.download.folderList", 2);
//        profile.setPreference("browser.download.manager.showWhenStarting", false);
//        profile.setPreference("browser.download.dir", "C:\\Users\\Makarov_K\\IdeaProjects\\testsite\\rest\\filePage\\folderToDownload");
//        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/csv");

        FirefoxProfile profile = new FirefoxProfile();
        DesiredCapabilities capabilities = new DesiredCapabilities();

        profile.setPreference("browser.download.folderList", 2);
        //profile.setPreference("browser.download.manager.showWhenStarting", false);
        profile.setPreference("browser.download.dir", "C:\\Users\\Makarov_K\\IdeaProjects\\testsite\\rest\\filePage\\folderToDownload");
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/csv");
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "firefox");

        WebDriver driver = new FirefoxDriver((Capabilities) profile);
        driver.get("http://testsite.local/rest/filePage/upload.php");
        WebElement aDownload = driver.findElement(By.id("a-download-file"));
        aDownload.click();
    }
}
