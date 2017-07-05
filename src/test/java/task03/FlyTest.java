package task03;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class FlyTest extends FlyBase {


    @Test
    public void openHomePageTest() {

        pages.homePage.openPage(properties.getProperty("site"));
        pages.bookingWidgetPage.fillWidget(properties);
        pages.ticketSelectionPage.select2Tickets();
        pages.tripSummaryPage.continueBtn();
        // pages.passengerInfoPage.fillPassengersFields();
        //pages.tripExtrasPage.reviewAndPay();
        //pages.creditCardInfoPage.pay();
        //pages.stopBrowser();

    }
}
