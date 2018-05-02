/**
 * Created by Makarov_K on 02.05.2018.
 */
package pom;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentReportTest {

    private String path;
    private String filename;
    private ExtentReports extent;

    public ExtentReportTest(String path, String filename) {
        this.path = path;
        this.filename = filename;
    }

    private ExtentReports getExtent() {
        String extentReportFile = System.getProperty(path) + filename;
        // Create object of extent report and specify the report file path.
        return new ExtentReports(extentReportFile, false);
    }

    private ExtentTest getStartTest(String testName, String description) {
        extent = getExtent();
        // Start the test using the ExtentTest class object.
        return extent.startTest(testName,description);
    }

    private void getEndTest(String testName, String description) {
        extent = getExtent();
        extent.endTest(getStartTest(testName, description));
    }
}