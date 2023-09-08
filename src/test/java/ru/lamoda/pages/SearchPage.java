package ru.lamoda.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SearchPage {

    SelenideElement
    searchBox = $("._input_1su1z_19"),
    searchResult = $("._main_1jpla_2");

    public SearchPage sendSearchQuery(String value) {
        searchBox.setValue(value).pressEnter();

        return this;
    }

    public SearchPage checkItemNotFoundMessage(String value) {
        searchResult.should(text(value));

        return this;
    }
}
