package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchPage {

    private static final SelenideElement
            searchBar = $x("//form/input"),
            searchSubbmit = $x("//*[@class='searchbar__button btn btn-send']"),
            checkElement = $x(".//*[@class='text-muted d-block d-sm-inline']");

    private static final ElementsCollection
        elementsList = $$x(".//*[@class='d-flex align-items-start align-items-lg-center cc-item']");

    @Step("Ввожу наименование препарата в строку поиска")
    public SearchPage setProductName(String productName) {
        searchBar.shouldBe(visible).setValue(productName);
        return this;
    }

    @Step("Подтверждаю ввод нажатием кнопки на формы")
    public SearchPage pressSubbmitButton() {
        searchSubbmit.shouldBe(visible).click();
        return this;
    }

    @Step("Подтверждаю ввод нажатием Энтер")
    public SearchPage pressEnter() {
        searchSubbmit.shouldBe(visible).pressEnter();
        return this;
    }

    @Step("Проверяю наличие количества найденных элементов в заголовке Списка")
    public SearchPage checkHeaderElementsList(int quantity){
        String result = "Найдено " + quantity + " результатов";
        String findResult = checkElement.shouldBe(visible).getText();
        assertEquals(result, findResult);
        return this;
    }

    @Step("Проверяю количество элементов в списке поиска")
    public SearchPage checkList(int quantity){
        elementsList.shouldHaveSize(quantity);
        return this;
    }


}
