import com.codeborne.selenide.Condition;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.open;

public class SearchTests extends BaseTest {

    @BeforeTest
    public void BeforeTest(){
        open(MainPage.url);
    }

    @Test
    public void FindItemUsingTopPanelSearchTest(){
        MainPage mainPage = new MainPage();
        CatalogPage catalogPage = mainPage.topPanel.search(ITEM_NAME);

        catalogPage.containsItemWithName(ITEM_NAME);
    }

    @Test
    public void FindItemUsingCatalogTest(){
        MainPage mainPage = new MainPage();
        CatalogPage catalogPage = mainPage.topPanel.openCatalogSection("Командные виды спорта", "Коньки");
        catalogPage.filterPanel.filterByBrand("Bauer");

        catalogPage.containsItemWithName(ITEM_NAME);
    }

    static final String ITEM_NAME ="Bauer SUPREME 2S";
}
