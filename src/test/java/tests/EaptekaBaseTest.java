package tests;

import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class EaptekaBaseTest {

    final String ENTRANCE = "//*[@class='htop__links right']/a[2]";
    final String LOGIN_ERROR = "//*[@class='help-block form-error']";
    final String POPUP_CLOSE = "//*[@class='popups__xclose']";

    @BeforeAll
    public static void setUp(){
        open("https://www.eapteka.ru/");
        $x("//*[@class='header__tower-skip header__skip-start btn btn-success btn-sm']").click();
    }
}
