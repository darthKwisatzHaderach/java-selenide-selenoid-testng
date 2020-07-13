import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public abstract class BaseDialog {
    SelenideElement dialog = $("#sm-popup");
    SelenideElement closeButton = dialog.$x("//a[@data-selenium='close_button']");

    /**
     * Закрыть диалоговое окно
     */
    @Step("Закрыть диалоговое окно")
    public <BasePage, T extends BasePage> BasePage page(T pageObject) {
        closeButton.click();

        return pageObject;
    }
}
