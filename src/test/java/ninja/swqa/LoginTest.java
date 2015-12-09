package ninja.swqa;

import ninja.swqa.pages.LoginPage;
import ninja.swqa.support.Site;
import ninja.swqa.support.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Site.url("/login"));
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @After
    public void teardown() {
        driver.close();
    }

    @Test
    public void testSuccessfulLogin() {
        loginPage.login(User.VALID_EMAIL, User.VALID_PASSWORD);
        assert loginPage.IsLoggedIn();
    }

    @Test
    public void testBadAccountLogin() {
        loginPage.login(User.INVALID_EMAIL, User.VALID_PASSWORD);
        assert ! loginPage.IsLoggedIn();
    }

    @Test
    public void testBadPasswordLogin() {
        loginPage.login(User.VALID_EMAIL, User.INVALID_PASSWORD);
        assert ! loginPage.IsLoggedIn();
    }
}
