
package pom;

import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class FirefoxProfileTestsite {

    private FirefoxProfile profile;

    public FirefoxProfileTestsite(FirefoxProfile profile) {
        this.profile = profile;
    }

    private FirefoxProfile createFirefoxProfile() {
        ProfilesIni profile = new ProfilesIni();
        return profile.getProfile("FirefoxProfileTestsite");
    }

    public FirefoxProfile setFirefoxProfileDownloadSettings() {
        profile = createFirefoxProfile();
        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.download.manager.showWhenStarting", false);
        profile.setPreference("browser.download.dir", "C:\\Users\\Makarov_K\\IdeaProjects\\testsite\\rest\\filePage\\folderToDownload");
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/csv");
        return profile;
    }
}
