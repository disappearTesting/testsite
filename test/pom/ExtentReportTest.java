/**
 * Created by Makarov_K on 02.05.2018.
 */
package pom;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentReportTest {

    // Create object of extent report and specify the report file path.
    private ExtentReports extent;
    private ExtentHtmlReporter htmlReporter;

    public ExtentReportTest(String path, String filename) {
        this.htmlReporter = new ExtentHtmlReporter(path + filename);
        this.extent = new ExtentReports();
    }

    public ExtentReports getExtent() {
        return extent;
    }
}
