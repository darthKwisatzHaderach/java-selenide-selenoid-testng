import com.codeborne.selenide.ElementsCollection;
import static com.codeborne.selenide.Selenide.*;

public class ResultsPage {
    public FilterPanel filterPanel;

    ElementsCollection items = $$x("//div[@data-selenium='product_item']");

    public ResultsPage(){
        this.filterPanel = new FilterPanel();
    }

    public ElementsCollection results() {
        return items;
    }
}
