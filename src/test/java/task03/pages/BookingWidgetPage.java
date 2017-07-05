package task03.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.Properties;

public class BookingWidgetPage extends Page {

    private String site;
    private String trip;
    private String departure;
    private String destination;
    private String departDate;
    private String destinDate;
    private String exactDates;
    private String typeOfPrice;
    private String restFields;

    public BookingWidgetPage(PageManager pages) {
        super(pages);
    }

    @FindBy(xpath = ".//*[@id='navBookTrip']" )
    private WebElement openWidget;

    @FindBy(xpath = ".//*[@id='book-air-content-trigger']")
    private WebElement selectFlight;

    @FindBy(css = "#originCity")
    private WebElement flightFrom;

    @FindBy(css = "#destinationCity" )
    private WebElement flightTo;

    @FindBy(css = "#departureDate")
    private WebElement departureDate;

    @FindBy(css = "#returnDate")
    private WebElement returnDate;

    @FindBy(css = "#findFlightsSubmit")
    private WebElement formSubmit;

    public void fillWidget(Properties properties) {
        fillStrings(properties);
        pages.bookingWidgetPage.openPage(site);
        openWidget.click();
        wait.until(ExpectedConditions.elementToBeClickable(selectFlight));
        selectFlight.click();
        this.selectTrip(trip);
        this.fillDestinations();
        this.fillDates();
        this.selectDates(exactDates);
        this.selectPrice(typeOfPrice);
        formSubmit.submit();

    }

    private void fillStrings(Properties properties) {
        this.site = properties.getProperty("site");
        this.trip = properties.getProperty("trip");
        this.departure = properties.getProperty("departure");
        this.destination = properties.getProperty("destination");
        this.departDate = properties.getProperty("departDate");
        this.destinDate = properties.getProperty("destinDate");
        this.exactDates = properties.getProperty("exactDates");
        this.typeOfPrice = properties.getProperty("typeOfPrice");
        this.typeOfPrice = properties.getProperty("typeOfPrice");
        this.restFields = properties.getProperty("restFields");
    }

    private void fillDestinations() {
        flightFrom.clear();
        flightFrom.sendKeys(departure);
        flightTo.clear();
        flightTo.sendKeys(destination);
    }

    private void fillDates() {
        departureDate.sendKeys(departDate);
        this.closeCalendar();
        returnDate.sendKeys(destinDate);
        this.closeCalendar();
    }

    private void selectTrip(String trip) {
        if (trip.equalsIgnoreCase("Round Trip")) trip = "#roundTripBtn";
        if (trip.equalsIgnoreCase("one way")) trip = "#oneWayBtn";
        if (trip.equalsIgnoreCase("Multi-City")) trip = "air-shopping-multicity-link";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(trip)));
        driver.findElement(By.cssSelector(trip)).click();
    }

    private void selectPrice(String price) {
        if (price.equalsIgnoreCase("Money")) price = "#cashBtn";
        if (price.equalsIgnoreCase("Miles")) price = "#milesBtn";
       wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(price)));
        driver.findElement(By.cssSelector(price)).click();
    }

    private void closeCalendar() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".ui-datepicker-closeButton")));
        driver.findElement(By.cssSelector(".ui-datepicker-closeButton")).click();
    }

    private void selectDates(String date) {
        if (date.equalsIgnoreCase("Exact dates")) date = "#exactDaysBtn";
        if (date.equalsIgnoreCase("Flexible dates")) date = "#flexDaysBtn";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(date)));
        driver.findElement(By.cssSelector(date)).click();
    }

}
