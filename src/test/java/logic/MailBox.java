package logic;

import java.util.List;

/**
 * Created by Rihn Kornak on 24.06.2017.
 */
public interface MailBox {
    void openInbox();
    void openOutbox();
    void openSpambox();
    void search(String text);
    void sendMail(String mail, String address);
    List<String> getResultsOfSearch();

}
