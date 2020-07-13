import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

public class SearchTests extends BaseTest {

    @Test
    public void Test(){
        String query = "Bauer SUPREME 2S";

        MainPage mainPage = new MainPage();
        ResultsPage resultsPage = mainPage.topPanel.search(query);

        resultsPage.items.get(0).shouldHave(Condition.text(query));
    }
}
