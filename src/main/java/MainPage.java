import static com.codeborne.selenide.Selenide.*;

/** Главная страница сайта Sportmaster */
public class MainPage {
    public TopPanel topPanel;
    public static String url = "https://www.sportmaster.ru/";

    public MainPage(){
        this.topPanel = new TopPanel();
    }
}
