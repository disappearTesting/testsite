package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import pom.FirefoxProfileTestsite;
import org.openqa.selenium.json.Json;

import java.util.Optional;

public class FirefoxProfileTestsite {

//    private FirefoxProfile profile;
//
//    public FirefoxProfileTestsite(FirefoxProfile profile) {
//        this.profile = profile;
//    }
//
//    private FirefoxProfile createFirefoxProfile() {
//        ProfilesIni profile = new ProfilesIni();
//        return profile.getProfile("FirefoxProfileTestsite");
//    }
//
//    public FirefoxProfile setFirefoxProfileDownloadSettings() {
//        profile = createFirefoxProfile();
//        profile.setPreference("browser.download.folderList", 2);
//        profile.setPreference("browser.download.manager.showWhenStarting", false);
//        profile.setPreference("browser.download.dir", "C:\\Users\\Makarov_K\\IdeaProjects\\testsite\\rest\\filePage\\folderToDownload");
//        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/csv");
//        return profile;
//    }

    public static void main(String[] args) throws InterruptedException {
        ProfilesIni profilesIni = new ProfilesIni();
        FirefoxProfile profile = profilesIni.getProfile("FirefoxProfileTestsite");
        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.download.manager.showWhenStarting", false);
        profile.setPreference("browser.download.dir", "C:\\Users\\Makarov_K\\IdeaProjects\\testsite\\rest\\filePage\\test");
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/csv");


        FirefoxOptions options = new FirefoxOptions().setProfile(profile);
        WebDriver driver = new FirefoxDriver(options);
        driver.get("http://testsite.local/rest/filePage/index.php");
        WebElement element = driver.findElement(By.id("a-download-file"));
        element.click();
        Thread.sleep(5000);
        driver.quit();
    }
}
