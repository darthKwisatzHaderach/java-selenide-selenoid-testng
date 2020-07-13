import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

/** Страница каталога */
public class CatalogPage extends BasePage {
    public FilterPanel filterPanel;

    ElementsCollection items = $$x("//div[@data-selenium='product_item']");

    public CatalogPage() {
        this.filterPanel = new FilterPanel();
    }

    /**
     * Открыть карточку товара по имени
     *
     * @param itemName наименование товара
     */
    @Step("Открыть карточку товара по имени '{0}'")
    public ProductPage openItemWithName(String itemName) {
        items.findBy(Condition.text(itemName)).click();

        return page(ProductPage.class);
    }
}
