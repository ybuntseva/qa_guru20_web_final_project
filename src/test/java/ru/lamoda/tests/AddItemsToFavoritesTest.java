package ru.lamoda.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.lamoda.pages.ClothesTabPage;
import ru.lamoda.pages.ItemCardPage;

import static io.qameta.allure.Allure.step;

public class AddItemsToFavoritesTest extends TestBase {

    String loginMessage = "Войдите, чтобы добавить в избранное";

    ClothesTabPage clothesTabPage = new ClothesTabPage();
    ItemCardPage itemCardPage = new ItemCardPage();

    @DisplayName("Проверка отображаения модального окна с текстом \"Войдите, чтобы добавить в избранное\" " +
            "у неавторизованного пользователя при добавлении товара в Избранное")
    @Tag("favorite")
    @Test
    void addItemToFavoritesByUnauthorizedUser() {

        step("Открыть карточку товара в разделе \"Одежда\"", () -> {
            clothesTabPage.selectClothesSubTab();
        });

        step("Нажать на иконку сердечка \"Добавить в Избранное\"", () -> {
            clothesTabPage.addToFavorites();
        });

        step("Проверить, что отобразилось модальное окно с текстом \"Войдите, чтобы добавить в избранное\"", () -> {
            itemCardPage.checkAddToFavoriteModalHeader(loginMessage);
        });
    }
}
