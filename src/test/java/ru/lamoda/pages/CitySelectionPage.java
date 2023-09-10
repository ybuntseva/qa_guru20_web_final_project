package ru.lamoda.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CitySelectionPage {

    SelenideElement
    cityBox = $("._root_32s20_2");

    ElementsCollection
    citiesList = $$("._citiesList_rq1gl_34 a"),
    selectedCity = $$("._locationTitle_rq1gl_59");

    public CitySelectionPage openCitySelectionBox() {
        cityBox.click();

        return this;
    }

    public CitySelectionPage selectCity(String value) {
        citiesList.find(text(value)).click();

        return this;
    }

    public CitySelectionPage verifySelectedCity(String value) {
        selectedCity.should(texts(value));

        return this;
    }
}
