package pom;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GetCookies {

    private WebDriver driver;

    public GetCookies(WebDriver driver) {
        this.driver = driver;
    }

    // logical method
    public BufferedWriter getCookies(String fileName) throws IOException {
        File file = new File(fileName);
        BufferedWriter bufferedWriter = null;
        if (file.exists()) {
            file.delete();
        } else {
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            bufferedWriter = new BufferedWriter(writer);
            for (Cookie cookie : driver.manage().getCookies()) {
                bufferedWriter.write(cookie.getName() + ";" + cookie.getValue() + ";" + cookie.getDomain() + ";" + cookie.getPath() + ";" + cookie.getExpiry() + ";" + cookie.isSecure());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            writer.close();
        }
        return bufferedWriter;
    }
}
