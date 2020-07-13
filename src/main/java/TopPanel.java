import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class TopPanel {
    SelenideElement searchContainer = $("#productSearchContainer");
    SelenideElement searchField = searchContainer.$x("input[@data-selenium='product_search_input']");
    SelenideElement searchButton = searchContainer.$x("input[@data-selenium='product_search_button']");

    public ResultsPage search(String query){
        searchField.val(query);
        searchButton.click();

        return page(ResultsPage.class);
    }
}
