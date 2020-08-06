package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SearchPages {

    private final SelenideElement
            searchBar = $x("//form/input"),
            searchSubbmit = $x("//*[@class='searchbar__button btn btn-send']");
}
