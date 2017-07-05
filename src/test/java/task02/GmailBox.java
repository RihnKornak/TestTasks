package task02;

import logic.MailBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GmailBox implements MailBox {

    private GmailManager manager;
    private WebDriver driver;

    public GmailBox(GmailManager manager) {
        this.manager = manager;
        this.driver = manager.getDriver();
    }

    @Override
    public void openInbox() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Входящие")));
        driver.findElement(By.partialLinkText("Входящие")).click();

    }

    @Override
    public void openOutbox() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Отправлен")));
        driver.findElement(By.partialLinkText("Отправлен")).click();
    }

    @Override
    public void openSpambox() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".CJ")));
        driver.findElement(By.cssSelector(".CJ")).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Спам")));
        driver.findElement(By.partialLinkText("Спам")).click();
    }

    @Override
    public void search(String text) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#gs_taif50")));
        WebElement searchField = driver.findElement(By.id("gbqfq"));
        searchField.click();
        searchField.clear();
        searchField.sendKeys("in:inbox " + text);
        driver.findElement(By.xpath(".//*[@id='gbqfb']")).click();

    }

    @Override
    public void sendMail(String mail, String address) {
        driver.findElement(By.xpath(".//*[@id=':io']/div/div")).click();
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='to']")));
        driver.findElement(By.xpath("//*[@name='to']")).sendKeys(address);
        driver.findElement(By.xpath("//*[@role='textbox']")).sendKeys(mail);
        driver.findElement(By.xpath("//*[@role='button' and @class='T-I J-J5-Ji aoO T-I-atl L3']")).click();

    }

    @Override
    public List<String> getResultsOfSearch() {

        String allText = driver.getPageSource();
        String[] parseText = allText.split("<*span*>");
        List<String> result = new ArrayList<>();
        for (int i = 1; i < parseText.length - 1; i++) {
            result.add(parseText[i]);
        }
        System.out.println(Arrays.asList(parseText));
        return result;
    }
}
