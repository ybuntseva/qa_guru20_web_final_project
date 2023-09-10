package ru.lamoda.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.lamoda.components.CitySelectionComponent;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {

    CitySelectionComponent citySelectionComponent = new CitySelectionComponent();

    private SelenideElement cityBox = $("._root_32s20_2"),
            searchBox = $("._input_1su1z_19");
    private ElementsCollection
            tabMenu = $$("._root_mexq0_2 a"),
            subTabsMenu = $$("._root_1416b_2 a");

    public MainPage selectTab(String value) {
        tabMenu.find(Condition.text(value)).click();

        return this;
    }

    public MainPage openCitySelectionBox() {
        cityBox.click();

        return this;
    }

    public MainPage selectCity(String value) {
        citySelectionComponent.selectCity(value);

        return this;
    }

    public MainPage verifySelectedCity(String value) {
        citySelectionComponent.verifySelectedCity(value);

        return this;
    }

    public MainPage checkSubTabsDisplayed(List<String> list) {
        subTabsMenu.should(texts(list));

        return this;
    }

    public MainPage sendSearchQuery(String value) {
        searchBox.setValue(value).pressEnter();

        return this;
    }
}
