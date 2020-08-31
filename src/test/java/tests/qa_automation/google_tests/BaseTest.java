package tests.qa_automation.google_tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    @BeforeAll
    public static void setUp(){
        SelenideLogger.addListener("allure", new AllureSelenide()
                .savePageSource(true).screenshots(true));
    }
}
