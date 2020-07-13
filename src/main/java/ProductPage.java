import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

/** Страница с описанием товара */
public class ProductPage extends BasePage {
    SelenideElement sizeButton = $x("//div[@data-selenium='enabled_product_size']");
    SelenideElement addToCartButton = $x("//a[@data-selenium='add_to_basket']");

    /**
     * Открыть страницу с описанием товара по идентификатору
     *
     * @param id идентификатор товара
     */
    @Step("Открыть страницу с описанием товара по идентификатору {0}")
    public ProductPage openProductById(String id) {
        open("/product/" + id);

        return page(ProductPage.class);
    }

    /**
     * Выбрать любой доступный размер
     */
    @Step("Выбрать любой доступный размер")
    public ProductPage selectAnyAvailableSize() {
        sizeButton.click();

        return page(ProductPage.class);
    }

    /**
     * Нажать кнопку 'В корзину'
     */
    @Step("Нажать кнопку 'В корзину'")
    public CartDialog clickAddToCartButton() {
        addToCartButton.click();

        return page(CartDialog.class);
    }
}
