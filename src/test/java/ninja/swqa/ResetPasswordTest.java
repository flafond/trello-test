package ninja.swqa;

import ninja.swqa.pages.ResetPasswordPage;
import ninja.swqa.support.Site;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ResetPasswordTest {

    private WebDriver driver;
    private ResetPasswordPage resetPage;

    // This is a kludge because (1) POMs don't have access to driver and
    // (2) because we've got to wait for the same page to refresh
    public boolean waitForMessage(WebElement field, String expected) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        return wait.until(ExpectedConditions.textToBePresentInElement(field, expected));
    }

    @Before
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Site.url("/forgot"));
        resetPage = PageFactory.initElements(driver, ResetPasswordPage.class);
    }

    @After
    public void teardown() {
        driver.close();
    }

    @Test
    public void testFailedResetPassword() {
        resetPage.resetPassword("bademail@example.com");
        assert waitForMessage(resetPage.errorField, "There wasn't an account for that email");
    }
}
