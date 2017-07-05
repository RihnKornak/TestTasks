package task02;

import logic.UserHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class GmailUser implements UserHelper{

    private Properties properties = new Properties();
    {
        try(FileReader reader = new FileReader("src/test/resourses/email")) {
            properties.load(reader);
        }catch (IOException e) {
            e.printStackTrace();

        }

    }
    private GmailManager manager;
    private String login = properties.getProperty("user");
    private String password = properties.getProperty("pass");
    private WebDriver driver;

    public GmailUser(GmailManager manager) {
        this.manager = manager;
        this.driver = manager.getDriver();
    }

    @Override
    public void logIn() {
        if (!isLoggedIn()){
            new WebDriverWait(driver,20).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='identifierId']")));
               driver.findElement(By.xpath(".//*[@id='identifierId']")).clear();
               driver.findElement(By.xpath(".//*[@id='identifierId']")).sendKeys(this.login);
               driver.findElement(By.xpath(".//*[@id='identifierNext']/content/span")).click();
            new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#password > div > div > div > input")));
            driver.findElement(By.cssSelector("div#password > div > div > div > input")).clear();
            driver.findElement(By.cssSelector("div#password > div > div > div > input")).sendKeys(this.password);
            driver.findElement(By.cssSelector("div#passwordNext > div:nth-of-type(2)")).click();

        }
    }

    @Override
    public void resetProfileChange() {
        try {
            if (driver.getPageSource().contains("Добро пожаловать!")) {
                driver.findElement(By.cssSelector(".iUe6Pd.Us7fWe.JhUD8d")).click();
                driver.findElement(By.cssSelector("#identifierLink")).click();
            }
        } catch (Exception e) {
            System.out.println("PEREHVAT !!!!");
            driver.close();
        }
    }


    @Override
    public void logOut() {

        driver.findElement(By.cssSelector(".gb_8a.gbii")).click();
        driver.findElement(By.cssSelector("#gb_71")).click();
    }

    @Override
    public boolean isLoggedIn() {
        //return driver.findElements(By.xpath(".//*[@id='gb_70']")).size() > 0;
        return false;
    }

}
