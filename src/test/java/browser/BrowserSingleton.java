package browser;

import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Rihn Kornak on 24.06.2017.
 */
public class BrowserSingleton {


    private static FirefoxDriver driver;

    public static FirefoxDriver getInstance(){
        if (driver == null){
            System.setProperty("webdriver.gecko.driver", "drv/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        return driver;
    }

}
