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
        ResultsPage resultsPage = mainPage.topPanel.search(ITEM_NAME);

        resultsPage.items.get(0).shouldHave(Condition.text(ITEM_NAME));
    }

    @Test
    public void FindItemUsingCatalogTest(){
        MainPage mainPage = new MainPage();
        ResultsPage resultsPage = mainPage.topPanel
                .openCatalogSection("Командные виды спорта", "Коньки");

        resultsPage.filterPanel.filterByBrand("Bauer");

        resultsPage.items.findBy(Condition.text(ITEM_NAME));
    }

    static final String ITEM_NAME ="Bauer SUPREME 2S";
}
