package ninja.swqa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

/**
 * Interact with the login page.
 * <p>
 * <b>NOTE:</b> All methods expect current url to be '/login'.
 */
public class LoginPage {
    @FindBy(id = "user")
    private WebElement tEmail;

    @FindBy(id = "password")
    private WebElement tPassword;

    @FindBy(id = "login")
    private WebElement bSubmit;

    @FindBy(linkText = "Reset it.")
    private WebElement lReset;

    @FindBy(linkText = "Create a Trello account.")
    private WebElement lCreateAccount;

    @FindBys(@FindBy(className = "header-logo-default"))
    private List<WebElement> imgLogo;

    @FindBy(className = "error-message")
    private WebElement errorMessage;

    public void login(String emailText, String passwordText) {
        tEmail.sendKeys(emailText);
        tPassword.sendKeys(passwordText);
        bSubmit.submit();
    }

    public void clickResetPassword() {
        lReset.click();
    }

    public void clickCreateAccount() {
        lCreateAccount.click();
    }

    // This logo does not appear unless logged in
    public Boolean IsLoggedIn() {
        return ! imgLogo.isEmpty();
    }

    public String getFlashMessage() {
        return errorMessage.getText();
    }
}
