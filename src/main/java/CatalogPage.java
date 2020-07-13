import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

/** Страница каталога */
public class CatalogPage {
    public FilterPanel filterPanel;

    ElementsCollection items = $$x("//div[@data-selenium='product_item']");

    public CatalogPage(){
        this.filterPanel = new FilterPanel();
    }

    /** Проверить, что на странице каталога присутствует карточка товара
     * @param itemName наименование товара */
    @Step("Проверить, что на странице каталога присутствует карточка товара с именем '{0}'")
    public void containsItemWithName(String itemName){
        items.findBy(Condition.text(itemName));
    }
}
