package task03.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TripSummaryPage extends Page {

    public TripSummaryPage(PageManager pages){
        super(pages);
    }

    public void continueBtn() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#tripSummarySubmitBtn")));
        driver.findElement(By.cssSelector("#tripSummarySubmitBtn")).click();
    }
}
