package ru.lamoda.tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.lamoda.pages.MainPage;
import ru.lamoda.pages.SearchPage;

import static io.qameta.allure.Allure.step;

public class SearchTest extends TestBase {

    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();

    @CsvSource(value = {
            "davines, Ничего не нашли по запросу «davines»",
            "rituals, Ничего не нашли по запросу «rituals»"
    })
    @ParameterizedTest(name = "Отображение текста {1} при поиске товара {0}, отсутствующего в каталоге")
    void verifyDisplayedTextForItemsNotInList(String searchQuery, String expectedMessage) {

        step("", () ->
                mainPage.sendSearchQuery(searchQuery));

        step("", () ->
                searchPage.checkItemNotFoundMessage(expectedMessage));
    }
}
