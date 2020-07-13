import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

/** Описание верхней панели */
public class TopPanel {
    SelenideElement searchContainer = $("#productSearchContainer");
    SelenideElement searchField = searchContainer.$x("input[@data-selenium='product_search_input']");
    SelenideElement searchButton = searchContainer.$x("input[@data-selenium='product_search_button']");

    SelenideElement catalog = $("#newMenu");
    SelenideElement catalogDropdown = catalog.$x("div[@data-selenium='menu_catalog_link']");

    /**
     * Найти наименование с помощью контрола в верхней панели
     *
     * @param query поисковый запрос
     */
    @Step("Выполнить поиск по запросу '{0}'")
    public CatalogPage search(String query) {
        searchField.val(query);
        searchButton.click();

        return page(CatalogPage.class);
    }

    /**
     * Открыть раздел каталога
     *
     * @param categoryName    название категории
     * @param subCategoryName название подкатегории
     */
    @Step("Открыть раздел каталога по категории '{0}' и подкатегории '{1}'")
    public CatalogPage openCatalogSection(String categoryName, String subCategoryName) {
        catalogDropdown.hover();
        $(byText(categoryName)).hover();
        $(byText(subCategoryName)).hover().click();

        return page(CatalogPage.class);
    }
}
