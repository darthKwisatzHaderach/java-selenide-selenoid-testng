import static com.codeborne.selenide.Selenide.*;

/** Главная страница сайта Sportmaster */
public class MainPage extends BasePage {
    public TopPanel topPanel;
    public static String url = "/";

    public MainPage() {
        this.topPanel = new TopPanel();
    }
}
