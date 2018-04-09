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

public class Unit_ActionPage {

    private static final String URL_ACTION_PAGE = "http://testsite.local/rest/actionPage/index.php";

    private WebDriver driver;
    private ActionPage objAction;
    private Actions builder;

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
        assertTrue(objAction.getAlertClickAndHold());
    }

    @Test
    public void test_InputText_ContextMenuHard() {
        assertTrue(objAction.setTextToInput_ContextMenuHard("test"));
    }

    @Test
    public void test_ValueOfTheCheckbox_ContextMenuHard() {
        assertTrue(objAction.setValueToCheckbox_ContextMenuHard());
    }
}
