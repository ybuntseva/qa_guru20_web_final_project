package ru.lamoda.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.lamoda.pages.ItemsPage;

import static io.qameta.allure.Allure.step;

public class RemoveItemsFromCartTests extends TestBase {

    String emptyCartMessage = "В корзине нет товаров";

    ItemsPage itemsPage = new ItemsPage();

    @DisplayName("Удаление товара из корзины")
    @Tag("removeFromCart")
    @Test
    void successfullyRemoveItemFromCart() {

        step("Открыть карточку товара в разделе \"Одежда\"", () -> {
            itemsPage.selectClothesSubTab()
                    .openItemCard();
        });

        step("Выбрать размер товара", () -> {
            itemsPage.openSizeDropdownList()
                    .selectSize();
        });

        step("Добавить товар в корзину", () -> {
            itemsPage.clickAddToCartButton()
                    .clickNavigateToCartButton();
        });

        step("Удалить товар из корзины", () -> {
            itemsPage.hoverOverItemInfo()
                    .clickDeleteItemFromCartButton();
        });

        step("Проверить, что товар удален из корзины", () -> {
            itemsPage.checkEmptyCartTitle(emptyCartMessage);
        });
    }
}

