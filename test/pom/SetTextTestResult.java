/**
 * @author hookie
 * @version 1.0
 */
package pom;

public class SetTextTestResult {
    private boolean result;
    private String message;

    public SetTextTestResult(Boolean result, String message) {

        this.result = result;
        this.message = message;
    }

    public boolean getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }
}
