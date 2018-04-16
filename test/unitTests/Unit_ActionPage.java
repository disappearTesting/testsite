/**
 * @author hookie
 * @version 1.0
 */
package unitTests;

import org.junit.After;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import pom.ActionPage;
import pom.SetTextTestResult;
import pom.TestRunException;

public class Unit_ActionPage {

    private static final String URL_ACTION_PAGE = "http://testsite.local/rest/actionPage/index.php";

    private WebDriver driver;
    private Actions builder;
    private ActionPage objAction;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        builder = new Actions(driver);
        objAction = new ActionPage(driver, builder);
        driver.get(URL_ACTION_PAGE);
    }

    @After
    public void tearDown() {
        //driver.quit();
    }

    @Test
    public void test_GetAlertClickAndHold() {
        SetTextTestResult test = objAction.getAlertClickAndHold_Action();
        assertTrue(test.getMessage(), test.getResult());
    }

    @Test
    public void test_InputText_ContextMenuHard_Action() {
        SetTextTestResult test = objAction.setTextToInput_ContextMenuHard_Action("test");
        assertTrue(test.getMessage(), test.getResult());
    }

    @Test
    public void test_ValueOfTheCheckbox_ContextMenuHard_Action() {
        SetTextTestResult test = objAction.toggleCheckbox_ContextMenuHard_Action();
        assertTrue(test.getMessage(), test.getResult());
    }

    @Test
    public void test_SelectRadioButton_ContextMenuHard_Action() {
        SetTextTestResult test = objAction.selectRadioButton_ContextMenuHard_Action();
        assertTrue(test.getMessage(), test.getResult());
    }

    @Test
    public void test_SelectDropdownMenu_ContextMenuHard_Action() throws TestRunException {
        assertTrue(objAction.callContextMenu());
        assertTrue(objAction.callContextMenu());
    }
}