package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AlfaTest {

    @Test
    public void archiveDepositsTest(){

        open("https://alfabank.ru/");
        $x("//*[@title='Вклады']").click();
        $x("//*[@title='Депозиты']").click();
        $(byText("Архивные депозиты")).scrollTo().click();
        $$x("//*[@class='product-cell__cell-back']").shouldHaveSize(3);
    }
}
