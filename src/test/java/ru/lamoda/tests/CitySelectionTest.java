package ru.lamoda.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.lamoda.pages.MainPage;

import static io.qameta.allure.Allure.step;

public class CitySelectionTest extends TestBase {

    MainPage mainPage = new MainPage();

    @ValueSource(strings = {
            "г. Москва",
            "г. Омск",
            "г. Новосибирск"
    })
    @DisplayName("Проверка возможности выбора города для доставки")
    @Tag("parametrized")
    @ParameterizedTest
    void chooseCityForDeliveryTest(String city) {

        step("Открыть окно выбора города и выбрать город", () ->
                mainPage.openCitySelectionBox()
                        .selectCity(city));

        step("Проверить отображение выбранного города", () ->
                mainPage.verifySelectedCity(city));
    }
}
