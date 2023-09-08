package ru.lamoda.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.lamoda.pages.MainPage;

import java.util.List;
import java.util.stream.Stream;

import static io.qameta.allure.Allure.step;

public class NavigationTabsTest extends TestBase {

    MainPage mainPage = new MainPage();

    static Stream<Arguments> navigationTabsTestPage() {
        return Stream.of(
                Arguments.of("Женщинам", List.of("Идеи", "Новинки", "Одежда", "Обувь", "Аксессуары",
                        "Бренды", "Premium", "Спорт","Resale", "Красота", "Дом", "Sale%")),
                Arguments.of("Мужчинам", List.of("Идеи", "Новинки", "Одежда", "Обувь", "Аксессуары",
                        "Бренды", "Premium", "Спорт","Resale", "Красота", "Дом", "Sale%")),
                Arguments.of("Детям", List.of("Школа", "Новинки", "Девочкам", "Мальчикам",
                        "Малышам", "Бренды", "Premium", "Спорт", "Игрушки", "Дом", "Уход", "Resale", "Sale%"))
        );
    }

    @MethodSource
    @DisplayName("Соответствие разделов выбранным категориям покупателей")
    @Tag("parametrized")
    @ParameterizedTest
    void navigationTabsTestPage(String tabs, List<String> expectedSubTabs) {

        step("Выбрать вкладку", () ->
                mainPage.selectTab(tabs));

        step("Проверить отображение сабтабов в зависимости от выбранной вкладки", () ->
                mainPage.checkSubTabsDisplayed(expectedSubTabs));
    }
}
