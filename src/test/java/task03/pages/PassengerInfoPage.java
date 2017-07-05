package task03.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PassengerInfoPage extends Page {

    @FindBy(css = "#firstName0")
    private WebElement name;

    @FindBy(css = "#lastName0")
    private WebElement lastName;

    @FindBy(css = "#emgcFirstName_0")
    private WebElement eName;

    @FindBy(css = "#emgcLastName_0")
    private WebElement eLastName;

    @FindBy(css = "#emgcPhoneNumber_0")
    private WebElement ePhone;

    @FindBy(css = "#telephoneNumber0")
    private WebElement cPhone;

    @FindBy(css = "#email")
    private WebElement cMail;

    @FindBy(css = "#reEmail")
    private WebElement cReMail;

    private String nameOf = "Ivan";
    private String lastNameOf = "Ivanoff";
    private String eNameOf = "Ivan";
    private String eLastNameOf = "Ivanoff";
    private String ePhoneOf = "291111111";
    private String cPhoneOf = "291111111";
    private String cMailOf = "google@gmail.com";

    public PassengerInfoPage(PageManager pages){
        super(pages);
    }

    public void fillPassengersFields() {

        fillPassengersInfo();
        fillDates();
        fillSex();
        fillEmergency();
        fillContactInfo();
        confirm();
    }

    private void fillEmergency() {
        eName.sendKeys(eNameOf);
        eLastName.sendKeys(eLastNameOf);
        driver.findElement(By.cssSelector("#emgcCountry_0-menu")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#ui-id-230"))));
        driver.findElement(By.cssSelector("#ui-id-230")).click();
        ePhone.sendKeys(ePhoneOf);
    }

    private void fillContactInfo() {
        driver.findElement(By.cssSelector("#deviceType-menu")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#ui-id-2"))));
        driver.findElement(By.cssSelector("#ui-id-2")).click();

        driver.findElement(By.cssSelector("#countryCode0-menu")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#ui-id-25"))));
        driver.findElement(By.cssSelector("#ui-id-25")).click();

        driver.findElement(By.cssSelector("#year0-menu")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#ui-id-124"))));
        driver.findElement(By.cssSelector("#ui-id-124")).click();

        cPhone.sendKeys(cPhoneOf);
        cMail.sendKeys(cMailOf);
        cReMail.sendKeys(cMailOf);
    }

    private void fillPassengersInfo() {
        wait.until(ExpectedConditions.visibilityOf(name));
        name.sendKeys(nameOf);
        lastName.sendKeys(lastNameOf);
    }

    private void fillDates() {

        driver.findElement(By.cssSelector("#month0-button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='month0-menu']//li[text() = 'January']")));
        WebElement element = driver.findElement(By.xpath(".//*[@id='month0-menu']//li[text() = 'January']"));
        element.click();

        driver.findElement(By.cssSelector("#day0-button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='day0-menu']//li[text() = '5']")));
        driver.findElement(By.xpath(".//*[@id='day0-menu']//li[text() = '5']")).submit();

        driver.findElement(By.cssSelector("#year0-button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='year0-menu']//li[text() = '1990']")));
        driver.findElement(By.xpath(".//*[@id='year0-menu']//li[text() = '1990']")).submit();
    }

    private void fillSex() {
        driver.findElement(By.cssSelector("#gender0-button")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#ui-id-20"))));
        driver.findElement(By.cssSelector("#ui-id-20")).click();
    }

    private void confirm() {
        driver.findElement(By.cssSelector("#paxReviewPurchaseBtn")).click();
    }
}
