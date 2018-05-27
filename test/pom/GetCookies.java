package pom;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.io.*;
import java.util.Date;
import java.util.StringTokenizer;

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
    private Cookie readTheCookieFile() throws IOException {
        Cookie cookie = null;
        File file = new File(cookieFileName);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String strLine = bufferedReader.readLine();
        while(strLine != null){
            StringTokenizer token = new StringTokenizer(strLine,";");
            while(token.hasMoreTokens()){
                String name = token.nextToken();
                String value = token.nextToken();
                String domain = token.nextToken();
                String path = token.nextToken();
                Date expiry = null;

                String val;
                if(!(val=token.nextToken()).equals("null"))
                {
                    expiry = new Date(val);
                }
                Boolean isSecure = new Boolean(token.nextToken()).booleanValue();
                cookie = new Cookie(name,value,domain,path,expiry,isSecure);
            }
        }
        return cookie;
    }

    // action method
    public Cookie getCookie() throws IOException {
         return readTheCookieFile();
    }
}
