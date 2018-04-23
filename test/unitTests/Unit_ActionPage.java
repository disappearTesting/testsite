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
    public void test_ResizeTheElement_ResizeArea() throws TestRunException {
        assertTrue(objAction.resizeTheElement_ResizeArea());
    }

    @Test
    public void test_ResizeTheElement_UseJavascript_Textarea_contextMenu() throws TestRunException {
        assertTrue(objAction.callContextMenu_ButtonContextMenu());
        assertTrue(objAction.resizeTheElement_UseJavascript_Textarea_ContextMenu());
    }

    @Test
    public void test_CallAlertClickAndHold_ButtonClickAndHold() throws TestRunException {
        assertTrue(objAction.callAlertClickAndHold_ButtonClickAndHold());
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
        assertTrue(objAction.toggleCheckbox_ElementChceckbox());
    }

    @Test
    public void test_SelectOption_useValue_InputDropdownMenu() throws TestRunException {
        assertTrue(objAction.callContextMenu_ButtonContextMenu());
        assertTrue(objAction.selectOption_UseValue_InputDropdownMenu());
    }

    @Test
    public void test_SelectRadioButton_ContextMenuHard() throws TestRunException {
        assertTrue(objAction.callContextMenu_ButtonContextMenu());
        assertTrue(objAction.selectRadioButton_RadioButton());
    }
}