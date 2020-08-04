package tests.eapteka;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class BaseTest {

    final static SelenideElement setRegion = $x("//*[@class='header__tower-skip header__skip-start btn btn-success btn-sm']");

    //Login viget
    static final SelenideElement entrance = $x("//*[@class='htop__links right']/a[2]");
    final SelenideElement logout = $x("//*[@class='htop__links right']/a[3]");
    static final SelenideElement setLogin = $(By.name("LOGIN"));
    static final SelenideElement setPassword = $(By.name("PASSWORD"));
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

    @BeforeEach
    public void setUps(){
        entrance.shouldHave(text("Вход")).click();
        setLogin.setValue("coxoyis908@in4mail.net");
        setPassword.setValue("password").pressEnter();
        entrance.shouldHave(text("Личный кабинет"));
    }

    @AfterEach
    void tearDown(){
        //Выход
        logout.shouldHave(text("Выход")).click();
    }
}
