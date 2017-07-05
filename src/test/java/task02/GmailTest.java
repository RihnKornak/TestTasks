package task02;

import org.testng.annotations.Test;

public class GmailTest extends GmailBase {

    @Test
    public void goToGmailWithLoginPassword() {

        app.openPage("https://google.by/");
        app.getUser().resetProfileChange();
        app.getUser().logIn();
        app.getMail().openInbox();
        app.getMail().openOutbox();
        app.getMail().openSpambox();
        app.getMail().openInbox();
        app.getMail().search("a");
        app.getMail().getResultsOfSearch();
        app.getMail().sendMail("Tipa pismo","test@mail.ru");
        app.getUser().logOut();
       // app.stopBrowser();

    }
}
