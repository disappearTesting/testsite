package pom;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.io.*;
import java.text.*;
import java.util.*;

public class GetCookies {

    private WebDriver driver;
    private String cookieFileName;

    public GetCookies(WebDriver driver, String cookieFileName) {
        this.driver = driver;
        this.cookieFileName = cookieFileName;
    }

    //logical method
    private boolean checkExistingFile(String path, String filename) {
        File file = new File(path + filename);
        return file.exists() && file.isFile();
    }

    // logical method
    private File writeTheCookieFile() throws IOException {
        File file = new File(cookieFileName);
        BufferedWriter bufferedWriter;
        if (file.exists()) {
            file.delete();
        } else {
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Cookie cookie : driver.manage().getCookies()) {
                bufferedWriter.write(cookie.getName() + ";" + cookie.getValue() + ";" + cookie.getDomain() + ";" + cookie.getPath() + ";" + cookie.getExpiry() + ";" + cookie.isSecure());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        }
        return file;
    }

    // action method
    public File getTheCookieFile() throws IOException {
        return writeTheCookieFile();
    }

    // action method
    public boolean checkExistingCookieFile(String path, String filename) {
        return checkExistingFile(path, filename);
    }

    // logical method
    private void readTheCookieFile() throws IOException, ParseException {
        File file = new File(cookieFileName);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String strLine = bufferedReader.readLine();
        while (strLine != null) {
            StringTokenizer token = new StringTokenizer(strLine, ";");
            while (token.hasMoreTokens()) {
                String name = token.nextToken();
                String value = token.nextToken();
                String domain = token.nextToken();
                if(domain == "testsite.local") {
                    switch (domain = null) {
                    }
                }
                String path = token.nextToken();

                Date expiry = null;
                String val;
                if (!(val = token.nextToken()).equals("null")) {
                     //Locale ruLocale = new Locale.Builder().setLanguage("ru").setRegion("RU").build();
                     SimpleDateFormat dateFormat = new SimpleDateFormat("EEE dd MMM yyyy HH:mm:ss z", Locale.ENGLISH);
                     expiry = dateFormat.parse(val);
                }
                boolean isSecure = new Boolean(token.nextToken()).booleanValue();
                Cookie cookie = new Cookie(name, value, domain, path, expiry, isSecure);
                driver.manage().addCookie(cookie);
            }
        }
    }

    // action method
    public void addCookie_Q() throws InterruptedException, IOException, ParseException {
        driver.manage().deleteAllCookies();
        Thread.sleep(3000);
        readTheCookieFile();
        //driver.navigate().refresh();
        Thread.sleep(3000);
        driver.get("http://testsite.local/rest/loginPage/login.php");
    }
}
