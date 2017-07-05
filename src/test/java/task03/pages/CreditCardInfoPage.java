package task03.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreditCardInfoPage extends Page {

    public CreditCardInfoPage(PageManager pages){
        super(pages);
    }

    private String cardNumberOf = "1234567812345678";
    private String cvvOf = "123";
    private String nameOf = "Ivan";
    private String lastNameOf = "Ivanoff";
    private String cityOf = "Minsk";
    private String addressOf = "Street A home b";
    private String postalOf = "200120";


    @FindBy(css = "#notLogInAccNumber")
    private WebElement cardNumber;

    @FindBy(css = "#cvv")
    private WebElement cvv;

    @FindBy(css = "#notLogInFirstName")
    private WebElement name;

    @FindBy(css = "#notLogInLastName")
    private WebElement lastName;

    @FindBy(css = "#cityCountyWard")
    private WebElement city ;

    @FindBy(css = "#postal")
    private WebElement postal ;

    @FindBy(css = "#addr1")
    private WebElement address;

    public void pay() {
        payData();
        fillComboboxData();
        driver.findElement(By.cssSelector("#addInsurance")).click();

    }

    private void payData() {
        wait.until(ExpectedConditions.visibilityOf(cardNumber));
        cardNumber.sendKeys(cardNumberOf);
        cvv.sendKeys(cvvOf);
        name.sendKeys(nameOf);
        lastName.sendKeys(lastNameOf);
        city.sendKeys(cityOf);
        postal.sendKeys(postalOf);
        address.sendKeys(addressOf);
    }

    private void fillComboboxData() {
        driver.findElement(By.cssSelector("#notLogInExpMonth-menu"));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#ui-id-599"))));
        driver.findElement(By.cssSelector("#ui-id-599")).click();

        driver.findElement(By.cssSelector("#notLogInExpYear-menu"));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#ui-id-612"))));
        driver.findElement(By.cssSelector("#ui-id-612")).click();

    }
}
