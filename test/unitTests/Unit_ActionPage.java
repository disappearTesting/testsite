/**
 * @author hookie
 * @version 1.0
 */
package unitTests;

import org.junit.After;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import pom.ActionPage;
import pom.TestRunException;

public class Unit_ActionPage {

    private static final String URL_ACTION_PAGE = "http://testsite.local/rest/actionPage/index.php";

    private WebDriver driver;
    private Actions builder;
    private JavascriptExecutor javascript;
    private ActionPage objAction;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        builder = new Actions(driver);
        //javascript = (JavascriptExecutor)driver;
        objAction = new ActionPage(driver, builder);
        driver.get(URL_ACTION_PAGE);
    }

    @After
    public void tearDown() {
        //driver.quit();
    }

    @Test
    public void test_GetCountOfRowsInElement() throws TestRunException {
        objAction.callContextMenu();
        objAction.getCountOfRowsInTextarea();
    }

    @Test
    public void test_ResizeElement() throws TestRunException {
        objAction.resizeElement();
    }

    @Test
    public void test_GetAlertClickAndHold() throws TestRunException {
        assertTrue(objAction.callAlertClickAndHold("AlertClickAndHold"));
    }

    @Test
    public void test_CallContextMenu() throws TestRunException {
        assertTrue(objAction.callContextMenu());
    }

    @Test
    public void test_SetTextToInput_ContextMenuHard() throws TestRunException {
        assertTrue(objAction.callContextMenu());
        assertTrue(objAction.setTextToInput_ContextMenuHard("test"));
    }

    @Test
    public void test_ToggleCheckbox_ContextMenuHard() throws TestRunException {
        assertTrue(objAction.callContextMenu());
        assertTrue(objAction.toggleCheckbox_ContextMenuHard());
    }

    @Test
    public void test_SelectOption_ContextMenuHard_useValue() throws TestRunException {
        assertTrue(objAction.callContextMenu());
        assertTrue(objAction.selectOption_ContextMenuHard_useValue("1"));
    }

    @Test
    public void test_SelectRadioButton_ContextMenuHard() throws TestRunException {
        assertTrue(objAction.callContextMenu());
        assertTrue(objAction.selectRadioButton_ContextMenuHard());
    }
}