package ninja.swqa.support;

import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generic utilities.
 */
public class Util {
    /**
     * Convert List<WebElement> to List<String> - useful for comparing onscreen
     * results to expected results.
     * @param elementList List of WebElements to convert. Typically a 'ul' block
     * @return List of strings extracted from iterating over the WebElements
     */
    public static List<String> toStrings(List<WebElement> elementList) {
        return elementList.stream().map(s -> s.getText()).collect(Collectors.toList());
    }
}
