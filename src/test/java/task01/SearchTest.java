package task01;

import org.openqa.selenium.WebDriverException;
import org.testng.annotations.Test;

public class SearchTest extends SearchBase {
    @Test(expectedExceptions = WebDriverException.class)
    public void goToTutWebSiteSearchAutomatedTesting() {

        app.openPage("https://tut.by/");
        app.searchWords("automated testing");
        System.out.println(app.NumberOfResultsOnPage());
        app.searchInFinded("Minsk Automated Testing Community");
        app.stopBrowser();
    }

}
