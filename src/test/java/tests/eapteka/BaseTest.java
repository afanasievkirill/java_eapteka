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

    //Search viget
    final SelenideElement searchBar = $x("//form/input");
    final SelenideElement searchSubbmit = $x("//*[@class='searchbar__button btn btn-send']");

    @BeforeAll
    public static void setUp(){
        open("https://www.eapteka.ru/");
        setRegion.click();
    }

    @AfterEach
    void tearDown(){
    }
}
