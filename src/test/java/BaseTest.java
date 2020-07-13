import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {

    @BeforeClass
    public void BeforeClass(){
        Configuration.timeout = 10000;
        open(MainPage.url);
    }
}
