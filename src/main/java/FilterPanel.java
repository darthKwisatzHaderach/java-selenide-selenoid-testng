import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

/** Панель фильтров */
public class FilterPanel {
    SelenideElement filter = $(".sm-category__left");

    /** Отфильтровать результаты по бренду
     * @param brandName наименование бренда */
    @Step("Отфильтровать результаты по бренду '{0}'")
    public CatalogPage filterByBrand(String brandName){
        filter.$(byText(brandName)).click();

        return page(CatalogPage.class);
    }
}
