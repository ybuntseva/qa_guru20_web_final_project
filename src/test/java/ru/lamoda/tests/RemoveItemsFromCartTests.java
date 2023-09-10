package ru.lamoda.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.lamoda.pages.ClothesTabPage;
import ru.lamoda.pages.ItemCardPage;
import ru.lamoda.pages.CartPage;

import static io.qameta.allure.Allure.step;

public class RemoveItemsFromCartTests extends TestBase {

    String emptyCartMessage = "В корзине нет товаров";

    CartPage cartPage = new CartPage();
    ClothesTabPage clothesTabPage = new ClothesTabPage();
    ItemCardPage itemCardPage = new ItemCardPage();

    @DisplayName("Удаление товара из корзины")
    @Tag("removeFromCart")
    @Test
    void successfullyRemoveItemFromCart() {

        step("Открыть карточку товара в разделе \"Одежда\"", () -> {
            clothesTabPage.selectClothesSubTab()
                    .openItemCard();
        });

        step("Выбрать размер товара", () -> {
            itemCardPage.openSizeDropdownList()
                    .selectSize();
        });

        step("Добавить товар в корзину", () -> {
            itemCardPage.clickAddToCartButton()
                    .clickNavigateToCartButton();
        });

        step("Удалить товар из корзины", () -> {
            cartPage.hoverOverItemInfo()
                    .clickDeleteItemFromCartButton();
        });

        step("Проверить, что товар удален из корзины", () -> {
            cartPage.checkEmptyCartTitle(emptyCartMessage);
        });
    }
}

