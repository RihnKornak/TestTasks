package task01;


import org.testng.annotations.BeforeClass;

public class SearchBase {

    BrowserSearchManager app;

    @BeforeClass
    void init(){
        app = new BrowserSearchManager();
    }
}
