package tests.eapteka;

import com.codeborne.selenide.Condition;
import eapteka.pages.SearchPage;
import io.qameta.allure.Issue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$x;

@Tag("SearchTest")
public class SearchTest extends BaseTest {

    SearchPage searchPage = new SearchPage();
    String name = "Афобазол";

    @Issue("WEB-15371")
    @DisplayName("Проверяю работу поиска по препарату {name}")
    @Test
    public void searchTest(){
        searchPage.setProductName(name);
        searchSubbmit.click();
        $x(".//strong[text()="+name+"]").shouldHave(Condition.visible);
    }
}
