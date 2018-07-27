/**
 * Created by Makarov_K on 02.05.2018.
 */
package pom;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentReportTest {

    private String path;
    private String filename;

    public ExtentReportTest(String path, String filename) {
        this.path = path;
        this.filename = filename;
    }

    public String getHTMLReport() {
        return System.getProperty(path) + filename;
    }

    public ExtentReports getObjectOfExtent() {
        return new ExtentReports(getHTMLReport(), false);
    }
}