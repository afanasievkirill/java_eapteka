package tests.eapteka;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;

public class BaseTest {

    final static SelenideElement setRegion = $x("//*[@class='header__tower-skip header__skip-start btn btn-success btn-sm']");

    final SelenideElement searchBar = $x("//form/input");
    final SelenideElement searchSubbmit = $x("//*[@class='searchbar__button btn btn-send']");

    @BeforeAll
    public static void setUp(){
        SelenideLogger.addListener("allure", new AllureSelenide()
                .savePageSource(true).screenshots(true));
        Configuration.headless = true;
    }

    @BeforeEach
    public void setUps(){
        open("https://www.eapteka.ru/");
        setRegion.click();
    }

    @AfterEach
    void tearDown(){
        closeWebDriver();
    }
}
