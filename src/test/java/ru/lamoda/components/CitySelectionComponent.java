package ru.lamoda.components;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

public class CitySelectionComponent {

    ElementsCollection
            citiesList = $$("._citiesList_rq1gl_34 a"),
            selectedCity = $$("._locationTitle_rq1gl_59");

    public void selectCity(String value) {
        citiesList.find(text(value)).click();
    }

    public void verifySelectedCity(String value) {
        selectedCity.should(texts(value));
    }
}
