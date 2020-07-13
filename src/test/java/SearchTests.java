import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.open;

@Feature("Поиск и проверка доступности товара для покупки")
public class SearchTests extends BaseTest {

    @BeforeMethod
    public void beforeTest(){
        open(MainPage.url);
    }

    @Test(description = "Основной поиск по сайту")
    public void findAndBuyItemUsingTopPanelSearchTest(){
        MainPage mainPage = new MainPage();
        CatalogPage catalogPage = mainPage.topPanel.search(ITEM_NAME);

        ProductPage productPage = catalogPage.openItemWithName(ITEM_NAME);

        CartDialog cartDialog = productPage
                .selectAnyAvailableSize()
                .clickAddToCartButton();

        cartDialog.message.shouldHave(Condition.text(SUCCESS_MESSAGE));
    }

    @Test(description = "Поиск через меню каталога")
    public void findAndBuyItemUsingCatalogTest(){
        String category = "Командные виды спорта";
        String subCategory = "Коньки";
        String brandName = "Bauer";

        MainPage mainPage = new MainPage();
        CatalogPage catalogPage = mainPage.topPanel.openCatalogSection(category, subCategory);

        catalogPage.filterPanel.filterByBrand(brandName);

        ProductPage productPage = catalogPage.openItemWithName(ITEM_NAME);

        CartDialog cartDialog = productPage
                .selectAnyAvailableSize()
                .clickAddToCartButton();

        cartDialog.message.shouldHave(Condition.text(SUCCESS_MESSAGE));
    }

    @Test(description = "Поиск по идентификатору товара")
    public void findAndBuyItemById(){
        String productId = "10301784";

        ProductPage productPage = new ProductPage();

        CartDialog cartDialog = productPage
                .openProductById(productId)
                .selectAnyAvailableSize()
                .clickAddToCartButton();

        cartDialog.message.shouldHave(Condition.text(SUCCESS_MESSAGE));
    }

    static final String ITEM_NAME ="Bauer SUPREME 2S";
    static final String SUCCESS_MESSAGE = "Товар добавлен в корзину";
}
