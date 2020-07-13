import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.testng.ScreenShooter;
import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.*;

@Listeners({ ScreenShooter.class})
public abstract class BaseTest {

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browser) throws Exception {
        Configuration.timeout = 10000;
        Configuration.baseUrl = "https://www.sportmaster.ru";
        Configuration.reportsFolder = "allure-results";
        ScreenShooter.captureSuccessfulTests = true;

        Configuration.remote = "http://localhost:4444/wd/hub";

        if ("chrome".equals(browser)) {
            Configuration.browser = "chrome";
        } else if ("firefox".equals(browser)) {
            Configuration.browser = "firefox";
        } else if ("opera".equals(browser)) {
            Configuration.browser = "opera";
        } else if ("android".equals(browser)) {
            Configuration.browser = "android";
        } else {
            throw new Exception("Произошла ошибка: указанный браузер недоступен.");
        }

        Configuration.browserSize = "1920x1080";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;

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
