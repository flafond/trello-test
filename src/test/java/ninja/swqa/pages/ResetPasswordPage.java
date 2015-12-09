package ninja.swqa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Interact with reset password page.
 * <p>
 * <b>NOTE:</b> All methods expect current url to be '/forgot'.
 */
public class ResetPasswordPage {
    @FindBy(id = "email")
    private WebElement tEmail;

    @FindBy(id = "submit")
    private WebElement bSubmit;

    @FindBy(className = "error-message")
    public WebElement errorField;

    public void resetPassword(String emailTxt) {
        tEmail.sendKeys(emailTxt);
        bSubmit.click();
    }

    public String getErrorMessage() {
        return errorField.getText();
    }
}
