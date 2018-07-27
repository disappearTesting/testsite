package pom;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

import java.util.Optional;

public class FirefoxProfileTestsite {

    private FirefoxProfile profile;
    private FirefoxOptions options;

    public FirefoxProfileTestsite(FirefoxProfile profile, FirefoxOptions options) {
        this.profile = profile;
        this.options = options;
    }

    private FirefoxProfile createFirefoxProfile(String profileName) {
        ProfilesIni profilesIni = new ProfilesIni();
        profile = profilesIni.getProfile(profileName);
        return profile;
    }

    public FirefoxOptions getOptions_SkipDownloadDialog_FileType_TXT(String profileName, String downloadDir) {
        profile = createFirefoxProfile(profileName);
        profile.setPreference("browser.download.manager.useWindow", false);
        profile.setPreference("browser.download.dir", downloadDir);
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/plain");
        options = new FirefoxOptions().setProfile(profile);
        return options;
    }
}
