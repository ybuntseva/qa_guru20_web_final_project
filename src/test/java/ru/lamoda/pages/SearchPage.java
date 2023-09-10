package ru.lamoda.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SearchPage {

    private SelenideElement searchResult = $("._main_1jpla_2");

    public SearchPage checkItemNotFoundMessage(String value) {
        searchResult.should(text(value));

        return this;
    }
}
