package task01;

import browser.BrowserSingleton;
import logic.SearchManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class BrowserSearchManager implements SearchManager {
    protected WebDriver driver;

    @Test
    public void openPage(String url) {

        driver = BrowserSingleton.getInstance();
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

    }

    @Test
    public void searchWords(String words) {
        WebElement searchField = driver.findElement(By.cssSelector("#search_from_str"));
        searchField.clear();
        searchField.sendKeys(words);

        WebElement searchButton = driver.findElement(By.cssSelector(".button.big"));
        searchButton.click();
    }

    @Test
    public int NumberOfResultsOnPage(){
        List<WebElement> counter = driver.findElements(By.cssSelector(".b-results__li"));
        return counter.size()-1;
    }

    @Override
    public void stopBrowser() {
        driver.close();
    }

    @Test
    public void searchInFinded(String text) {
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        try {
            WebElement result = driver.findElement(By.partialLinkText(text));
            result.click();
        } catch (Exception e) {
            stopBrowser();
            throw new org.openqa.selenium.WebDriverException(e);

        }

    }


}
