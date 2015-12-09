package ninja.swqa.support;

/**
 * Created by frank on 12/8/15.
 */
public class User {
    public static final String VALID_EMAIL = System.getenv("TRELLO_EMAIL");
    public static final String INVALID_EMAIL = "bademail@example.com";
    public static final String VALID_PASSWORD = System.getenv("TRELLO_PASSWORD");
    public static final String INVALID_PASSWORD = "badpassword";
}
