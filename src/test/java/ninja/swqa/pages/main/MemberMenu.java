package ninja.swqa.pages.main;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Interact with menu that appears when the user's name is clicked on the top-right.
 * <p>
 * <b>NOTE:</b> All methods expect current url to be '/'.
 */
public class MemberMenu {
    @FindBy(xpath = "//div[contains(@class, \"pop-over\")]//a[contains(@class, \"icon-close\")]")
    private WebElement closeMenuX;

    public void close() {
        closeMenuX.click();
    }

    //TODO: Tons more to go here...
}
