package ru.lamoda.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {

    ElementsCollection
            tabMenu = $$("._root_mexq0_2 a"),
            subTabsMenu = $$("._root_1416b_2 a");

    public MainPage selectTab(String value) {
        tabMenu.find(Condition.text(value)).click();

        return this;
    }

    public MainPage checkSubTabsDisplayed(List<String> list) {
        subTabsMenu.should(texts(list));

        return this;
    }
}
