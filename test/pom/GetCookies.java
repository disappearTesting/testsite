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

    // logical method
    private BufferedWriter writeTheCookieFile() throws IOException {
        File file = new File(cookieFileName);
        BufferedWriter bufferedWriter = null;
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
        return bufferedWriter;
    }

    // logical method
    private BufferedReader readeTheCookieFile() throws IOException {
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
                Cookie cookie = new Cookie(name,value,domain,path,expiry,isSecure);
                System.out.println(cookie);
                driver.manage().addCookie(cookie); // This will add the stored cookie to your current session
            }
        }
        return bufferedReader;
    }
}
