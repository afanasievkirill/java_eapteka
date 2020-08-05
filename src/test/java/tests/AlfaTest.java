package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.conditions.Text;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AlfaTest {

    @BeforeEach
    public void setUp(){
        open("https://alfabank.ru/");
        $x("//*[@title='Вклады']").click();
    }

    @Test
    public void archiveDepositsTest(){
        $x("//*[@title='Депозиты']").click();
        $(byText("Архивные депозиты")).scrollTo().click();
        $$x("//*[@class='product-cell__cell-back']").shouldHaveSize(3);
    }

    @Test
    public void depositeInsuranseTest(){
        $x("//*[@class='navigation']/li").sibling(4).$x(".//a").click();
        $x("//*[@class='frame-head row smooth-static']").shouldHave(text("Страхование вкладов")) ;
    }
}
