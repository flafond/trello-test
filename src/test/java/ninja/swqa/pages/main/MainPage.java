package ninja.swqa.pages.main;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Interact with the page reached from login. This is where most of the action is.
 * Individual menu options are broken out to their own classes to keep this
 * from growing beyond control.
 * <p>
 * <b>NOTE:</b> All methods expect current url to be '/'.
 */
public class MainPage {

    // Boards menu locators

    @FindBy(xpath = "//span[@class='header-btn-text' and contains(text(), 'Boards')]")
    private WebElement bBoards;

    // Member menu locators

    @FindBy(className = "js-open-header-member-menu")
    private WebElement bMember;

    @FindBy(className = "js-logout")
    private WebElement lLogOut;

    // Methods

    /**
     * Open member menu (top right with user name) and optionally select one of the options.
     *
     * @param option  Menu option to click after opening menu. See MemberOption.
     * @throws IllegalArgumentException If an option isn't implemented yet. Remove when all are implemented.
     */
    public void memberMenuSelect(MemberOption option) throws IllegalArgumentException {
        bMember.click();

        switch (option) {
            case NONE:
                break;

            case LOGOUT:
                logOut();
                break;

            //TODO: Many other cases to handle

            default:
                throw new IllegalArgumentException("Option not implemented: " + option);
        }
    }

    /**
     * Open the board menu (top left corner).
     *
     * @param option Currently not used.
     * @return This page
     */
    public MainPage boardMenuSelect(String option)  {
        bBoards.click();
        return this;
    }

    public void logOut() {
        lLogOut.click();
    }
}
