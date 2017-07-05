package task03;

import org.testng.annotations.BeforeClass;
import task03.pages.PageManager;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class FlyBase {
    protected PageManager pages;
    protected Properties properties = new Properties();

    @BeforeClass
    void init(){
        pages = new PageManager();
    }

    @BeforeClass
    void initProperties() {
        try(FileReader fileReader = new FileReader("src/test/resourses/flightcombination")) {
            properties.load(fileReader);
        } catch (IOException e) {
            e.getStackTrace();
            System.out.println("There is no properties file !");
        }

    }


}
