/**
 * @author hookie
 * @version 1.0
 */
package unitTests;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import pom.ActionPage;
import pom.ExtentReportTest;
import pom.TestRunException;

import java.io.IOException;

public class Unit_ActionPage {

    private static final String URL_ACTION_PAGE = "http://testsite.local/testsite_resources/actionPage/index.php";
    private static final String DOWNLOAD_PATH = "C:\\Users\\hookie\\IdeaProjects\\testsite\\testsite_resources\\actionPage\\images\\";
    private static final String REPORT_PATH = "C:\\Users\\hookie\\IdeaProjects\\testsite\\reports\\";

    private WebDriver driver;
    private Actions builder;

    private ActionPage objAction;
    private ExtentReportTest objReport;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        builder = new Actions(driver);
        objAction = new ActionPage(driver, builder);
        driver.get(URL_ACTION_PAGE);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test_SaveImageFromURL_ImageBox() throws IOException, TestRunException {
        assertTrue(objAction.saveImageFromURL_ImageBox(DOWNLOAD_PATH,"img-fig1.png"));
    }

    @Test
    public void test_SortElement_SortBox() throws TestRunException {
        objReport = new ExtentReportTest(REPORT_PATH, "report_test_SortElement_SortBox().html");
        ExtentReports objectOfExtent = objReport.getObjectOfExtent();
        ExtentTest extentTest = objectOfExtent.startTest("test_SortElement_SortBox()",
                "actionPage/index.php. SortBox. Reorder elements in a list.");

        extentTest.log(LogStatus.INFO,"do scrollToElement_SortBox() method");
        objAction.scrollToElement_SortBox();

        extentTest.log(LogStatus.INFO,"do sortElement_UseDragAndDrop_SortBox() method");
        assertTrue(objAction.sortElement_UseDragAndDrop_SortBox("Item 1", "Item 7"));
        assertTrue(objAction.sortElement_UseDragAndDrop_SortBox("Item 6", "Item 7"));

        extentTest.log(LogStatus.INFO,"endTest");
        objectOfExtent.endTest(extentTest);
        objectOfExtent.flush();
    }

    @Test
    public void test_ResizeTheElement_ResizeArea() throws TestRunException {
        assertTrue(objAction.resizeTheElement_ResizeArea(80,80));
    }

    @Test
    public void test_ResizeTheElement_UseJavascript_Textarea_ContextMenu() throws TestRunException {
        assertTrue(objAction.callContextMenu_ButtonContextMenu());
        assertTrue(objAction.resizeTheElement_UseJavascript_Textarea_ContextMenu());
    }

    @Test
    public void test_CallAlertClickAndHold_ButtonClickAndHold() throws TestRunException {
        assertTrue(objAction.callAlertClickAndHold_ButtonClickAndHold("AlertClickAndHold"));
    }

    @Test
    public void test_CallContextMenu_ButtonContextMenu() throws TestRunException {
        assertTrue(objAction.callContextMenu_ButtonContextMenu());
    }

    @Test
    public void test_SetTextToInput_ContextMenuHard() throws TestRunException {
        assertTrue(objAction.callContextMenu_ButtonContextMenu());
        assertTrue(objAction.setTextToInput_InputText());
    }

    @Test
    public void test_ToggleCheckbox_ContextMenuHard() throws TestRunException {
        assertTrue(objAction.callContextMenu_ButtonContextMenu());
        assertTrue(objAction.toggleCheckbox_ElementCheckbox());
    }

    @Test
    public void test_SelectOption_InputDropdownMenu() throws TestRunException {
        assertTrue(objAction.callContextMenu_ButtonContextMenu());
        assertTrue(objAction.selectOption_ContextMenuHard(new String[]{"1"}));
    }

    @Test
    public void test_SelectOption_SelectBox() throws TestRunException {
        assertTrue(objAction.selectOption_SelectBox(new String[]{"option_2", "option_4", "option_6"}));
    }

    @Test
    public void test_SelectRadioButton_ContextMenuHard() throws TestRunException {
        assertTrue(objAction.callContextMenu_ButtonContextMenu());
        assertTrue(objAction.selectRadioButton_RadioButton());
    }
}