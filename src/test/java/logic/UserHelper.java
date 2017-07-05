package logic;

import task02.GmailManager;
import task02.GmailUser;

/**
 * Created by Rihn Kornak on 24.06.2017.
 */
public interface UserHelper {
    void logIn();

    void logOut();

    boolean isLoggedIn();

    void resetProfileChange();
}