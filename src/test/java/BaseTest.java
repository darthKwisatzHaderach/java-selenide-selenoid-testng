import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.testng.ScreenShooter;
import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.*;

@Listeners({ ScreenShooter.class})
public abstract class BaseTest {

    @BeforeClass
    public void beforeClass(){
        Configuration.timeout = 10000;
        Configuration.baseUrl = "https://www.sportmaster.ru";
        Configuration.reportsFolder = "allure-results";
        ScreenShooter.captureSuccessfulTests = true;

        clearBrowserCookies();
    }

    @AfterMethod
    public void tearDown() throws IOException {
        screenshot();
    }

    @Attachment(type = "image/png")
    public byte[] screenshot() throws IOException {
        File screenshot = Screenshots.getLastScreenshot();
        return screenshot == null ? null : Files.toByteArray(screenshot);
    }
}
