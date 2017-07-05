package task03.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class TicketSelectionPage extends Page {

    public TicketSelectionPage(PageManager pages) {
        super(pages);
    }

    @FindBy(xpath = ".//*[@id='fareRowContainer_0']/tbody/tr[2]/td[2]")
    private WebElement firstTicket;

    @FindBy(xpath = ".//*[@id='fareRowContainer_0']/tbody/tr[2]/td[2]")
    private WebElement secondTicket;

    @FindBy(id = "tripSummarySubmitBtn")
    private WebElement submitButton;


    public void select2Tickets() {
       wait.until(ExpectedConditions.elementToBeClickable(firstTicket));
       firstTicket.click();
       wait.until(ExpectedConditions.elementToBeClickable(secondTicket));
       secondTicket.click();
       wait.until(ExpectedConditions.elementToBeClickable(submitButton));
       submitButton.submit();
    }
}
