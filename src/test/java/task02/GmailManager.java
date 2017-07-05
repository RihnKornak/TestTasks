package task02;

import browser.BrowserSingleton;
import logic.LoginedManager;
import logic.MailBox;
import logic.UserHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;


public class GmailManager implements LoginedManager{

    protected WebDriver driver = BrowserSingleton.getInstance();
    private GmailUser user = new GmailUser(this);
    private GmailBox box = new GmailBox(this);

    @Override
    public void openPage(String url) {

        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.partialLinkText("Почта")).click();
}

    @Override
    public UserHelper getUser() {
        return this.user;
    }

    @Override
    public MailBox getMail() {
        return this.box;
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    @Override
    public void stopBrowser() {
        driver.close();
    }
}
