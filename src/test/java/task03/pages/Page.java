package task03.pages;

import browser.BrowserSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public  class Page {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected PageManager pages;

    public Page(PageManager pages) {
        this.pages = pages;
        this.driver = BrowserSingleton.getInstance();
        this.wait = new WebDriverWait(driver, 15);
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public WebDriverWait getWait() {
        return this.wait;
    }

    public PageManager getPages() {
        return this.pages;
    }

    public void openPage(String url) {

        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

}
