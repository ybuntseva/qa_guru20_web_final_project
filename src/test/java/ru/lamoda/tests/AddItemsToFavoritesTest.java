package ru.lamoda.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.lamoda.pages.ItemsPage;

import static io.qameta.allure.Allure.step;

public class AddItemsToFavoritesTest extends TestBase {

    String loginMessage = "Войдите, чтобы добавить в избранное";

    ItemsPage itemsPage = new ItemsPage();

    @DisplayName("Проверка отображаения модального окна с текстом \"Войдите, чтобы добавить в избранное\" " +
            "у неавторизованного пользователя при добавлении товара в Избранное")
    @Tag("favorite")
    @Test
    void addItemToFavoritesByUnauthorizedUser() {

        step("Открыть карточку товара в разделе \"Одежда\"", () -> {
            itemsPage.selectClothesSubTab();
        });

        step("Нажать на иконку сердечка \"Добавить в Избранное\"", () -> {
            itemsPage.addToFavorites();
        });

        step("Проверить, что отобразилось модальное окно с текстом \"Войдите, чтобы добавить в избранное\"", () -> {
            itemsPage.checkAddToFavoriteModalHeader(loginMessage);
        });
    }
}
