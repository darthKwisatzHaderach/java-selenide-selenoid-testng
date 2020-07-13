import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class FilterPanel {
    SelenideElement filter = $(".sm-category__left");

    public ResultsPage filterByBrand(String brandName){
        filter.$(byText(brandName)).click();

        return page(ResultsPage.class);
    }
}
