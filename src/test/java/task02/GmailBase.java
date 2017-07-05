package task02;

import org.testng.annotations.BeforeClass;


public class GmailBase {
    GmailManager app;

    @BeforeClass
    void init(){
        app = new GmailManager();
    }
}
