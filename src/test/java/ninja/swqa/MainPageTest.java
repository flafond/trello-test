package ninja.swqa;

import ninja.swqa.pages.LoginPage;
import ninja.swqa.pages.main.BoardMenu;
import ninja.swqa.pages.main.MainPage;
import ninja.swqa.pages.main.MemberOption;
import ninja.swqa.support.Site;
import ninja.swqa.support.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class MainPageTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private MainPage mainPage;
    private BoardMenu boardMenu;

    //TODO: Avoid tearing down the driver each time.
    @Before
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://trello.com/login");

        loginPage = PageFactory.initElements(driver, LoginPage.class);
        mainPage  = PageFactory.initElements(driver, MainPage.class);
        boardMenu = PageFactory.initElements(driver, BoardMenu.class);

        loginPage.login(User.VALID_EMAIL, User.VALID_PASSWORD);
    }

    @After
    public void teardown() {
        driver.close();
    }

    /**
     * <b>NOTE:</b> This test is fragile as adding or renaming a board will break it.
     */
    @Test
    public void testBoardsMenu() {
        mainPage.boardMenuSelect("");
//        boardMenu.getMyBoards().forEach(System.out::println);
        Assert.assertEquals(
                Arrays.asList("Play", "Welcome Board", "Work"),
                boardMenu.getMyBoards());
    }

    /**
     * <b>NOTE:</b> This test is fragile as closing a board will break it.
     */
    @Test
    public void testClosedBoardsList() {
        mainPage.boardMenuSelect("");
        Assert.assertEquals("Board(s) closed, didn't expect any",
                "No boards have been closed", boardMenu.clickSeeClosed().get(0));
        boardMenu.dismissClosedBoards();
    }

    @Test
    public void testLogout() {
        mainPage.memberMenuSelect(MemberOption.LOGOUT);

        //TODO: Implement some sort of base URL functionality
        Assert.assertEquals("Didn't go to logout page", Site.url("/logged-out"), driver.getCurrentUrl());
    }
}
