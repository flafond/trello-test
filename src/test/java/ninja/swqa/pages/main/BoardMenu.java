package ninja.swqa.pages.main;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

import static ninja.swqa.support.Util.toStrings;

/**
 * Interact with the Boards Menu, which appears when the Boards button in the
 * top left corner of the main page is clicked.
 */
public class BoardMenu {

    @FindBy(xpath = "//input[@placeholder='Find boards by name…']")
    private WebElement tBoardSearch;

    @FindBy(linkText = "Create new board…")
    private WebElement lCreateNew;

    @FindBy(linkText = "Always keep this menu open.")
    private WebElement lKeepOpen;

    @FindBy(linkText = "See closed boards…")
    private WebElement lSeeClosed;
    @FindBys(@FindBy(xpath = "//div[@class='window-main-col']/p"))
    private List<WebElement> listClosedBoards;

    @FindBy(className = "dialog-close-button")
    private WebElement xClosedBoards;

    // These locators look complicated, but I think they're more robust than other options

    @FindBy(xpath = ".//*[@id='boards-drawer']//span[contains(text(), 'My Boards')]/../span[contains(@class, 'js-collapse-section')]")
    private WebElement expandMyBoards;

    @FindBys(@FindBy(xpath = "//div[@id='boards-drawer']//span[contains(text(), 'My Boards')]/../..//ul/li//span[@class='compact-board-tile-link-text-name']"))
    private List<WebElement> listMyBoards;

    @FindBy(xpath = ".//*[@id='boards-drawer']//span[contains(text(), 'Starred Boards')]/../span[contains(@class, 'js-collapse-section')]")
    private WebElement expandStarredBoards;

    @FindBys(@FindBy(xpath = "//div[@id='boards-drawer']//span[contains(text(), 'Starred Boards')]/../..//ul/li//span[@class='compact-board-tile-link-text-name']"))
    private List<WebElement> listStarredBoards;

    @FindBy(xpath = ".//*[@id='boards-drawer']//span[contains(text(), 'Recent Boards')]/../span[contains(@class, 'js-collapse-section')]")
    private WebElement expandRecentBoards;

    @FindBys(@FindBy(xpath = "//div[@id='boards-drawer']//span[contains(text(), 'Recent Boards')]/../..//ul/li//span[@class='compact-board-tile-link-text-name']"))
    private List<WebElement> listRecentBoards;

    // Methods

    //TODO: See if there is a way to parameterize next 3 methods and their locators?
    public List<String> getMyBoards() {
        return toStrings(listMyBoards);
    }

    public List<String> getRecentBoards() {
        return toStrings(listRecentBoards);
    }

    public List<String> getStarredBoards() {
        return toStrings(listStarredBoards);
    }

    public List<String> getClosedBoards() {
        return toStrings(listClosedBoards);
    }

    public List<String> clickSeeClosed() {
        lSeeClosed.click();
        return getClosedBoards();
    }

    public BoardMenu dismissClosedBoards() {
        xClosedBoards.click();
        return this;
    }

    //TODO: Class incomplete - contains just enough for existing tests
}
