import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CartDialog extends BaseDialog {
    SelenideElement cartDiaolg = $("#basketMessage");
    SelenideElement message = cartDiaolg.$("h1");
}
