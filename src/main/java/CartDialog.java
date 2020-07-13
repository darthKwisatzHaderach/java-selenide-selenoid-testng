import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

/** Диалог успешного добавления товара в корзину*/
public class CartDialog extends BaseDialog {
    SelenideElement cartDialog = $("#basketMessage");
    SelenideElement message = cartDialog.$("h1");
}
