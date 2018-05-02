/**
 * Created by Makarov_K on 02.05.2018.
 */
package pom;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentReportTest {

    // Create object of extent report and specify the report file path.
    ExtentReports extent;

    public ExtentReportTest(String path, String filename) {
        this.extent = new ExtentReports(System.getProperty(path) + filename, false);
    }

    public ExtentReports getExtent() {
        return extent;
    }

}
