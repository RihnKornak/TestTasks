package task03.pages;

import browser.BrowserSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageManager {

    private WebDriver driver = BrowserSingleton.getInstance();

    public HomePage homePage;
    public TripExtrasPage tripExtrasPage;
    public TripSummaryPage tripSummaryPage;
    public PassengerInfoPage passengerInfoPage;
    public BookingWidgetPage bookingWidgetPage;
    public CreditCardInfoPage creditCardInfoPage;
    public TicketSelectionPage ticketSelectionPage;

    public PageManager() {
        homePage = initElements(new HomePage(this));
        tripExtrasPage = initElements(new TripExtrasPage(this));
        tripSummaryPage = initElements(new TripSummaryPage(this));
        passengerInfoPage = initElements(new PassengerInfoPage(this));
        bookingWidgetPage = initElements(new BookingWidgetPage(this));
        creditCardInfoPage = initElements(new CreditCardInfoPage(this));
        ticketSelectionPage = initElements(new TicketSelectionPage(this));
    }

    private <T extends Page> T initElements(T page) {
        PageFactory.initElements(driver, page);
        return page;
    }

    public void stopBrowser() {
        driver.close();
    }
}
