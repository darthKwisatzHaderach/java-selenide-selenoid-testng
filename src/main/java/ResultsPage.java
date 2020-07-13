import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ResultsPage {
    ElementsCollection items = $$x("//div[@data-selenium='product_item']");

    public ElementsCollection results() {
        return items;
    }
}
