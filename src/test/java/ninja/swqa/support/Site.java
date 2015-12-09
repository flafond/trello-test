package ninja.swqa.support;

import java.net.MalformedURLException;
import java.net.URL;

public class Site {

    private static URL BASE_URL;
    static {
        try {
            BASE_URL = new URL("https://trello.com");
        } catch (MalformedURLException e) {
            throw new RuntimeException("Couldn't initialize Site", e);
        }
    }

    public static String url(String relativeUrl) {
        String fullUrl;
        try {
            fullUrl = new URL(BASE_URL, relativeUrl).toString();
        } catch (MalformedURLException e) {
            fullUrl = "BAD-URL";
        }
        return fullUrl;
    }
}