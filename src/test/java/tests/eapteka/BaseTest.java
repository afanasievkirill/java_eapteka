package tests.eapteka;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class BaseTest {

    final static SelenideElement setRegion = $x("//*[@class='header__tower-skip header__skip-start btn btn-success btn-sm']");

    //Login viget
    final SelenideElement entrance = $x("//*[@class='htop__links right']/a[2]");
    final SelenideElement logout = $x("//*[@class='htop__links right']/a[3]");
    final SelenideElement setLogin = $(By.name("LOGIN"));
    final SelenideElement setPassword = $(By.name("PASSWORD"));
    final SelenideElement loginError = $x("//*[@class='help-block form-error']");
    final SelenideElement popupClose = $x("//*[@class='popups__xclose']");

    //Search viget
    final SelenideElement searchBar = $x("//form/input");
    final SelenideElement searchSubbmit = $x("//*[@class='searchbar__button btn btn-send']");

    @BeforeAll
    public static void setUp(){
        open("https://www.eapteka.ru/");
        setRegion.click();
    }
}
