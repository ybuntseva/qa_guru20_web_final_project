package ru.lamoda.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.lamoda.pages.ItemsPage;

import static io.qameta.allure.Allure.step;

public class AddItemsToCartTests extends TestBase {

    String itemAddedMessage = "Товар добавлен в корзину",
            cart = "Корзина",
            itemCount = "1 товар";

    ItemsPage itemsPage = new ItemsPage();

    @DisplayName("Проверка отображения модального окна с сообщением о добавлении товара в корзину")
    @Tag("cart")
    @Test
    void successfullyAddItemsToCartModal() {

        step("Открыть карточку товара в разделе \"Одежда\"", () -> {
            itemsPage.selectClothesSubTab()
                    .openItemCard();
        });

        step("Выбрать размер товара", () -> {
            itemsPage.openSizeDropdownList()
                    .selectSize();
        });

        step("Нажать на кнопку \"Добавить в корзину\"", () -> {
            itemsPage.clickAddToCartButton();
        });

        step("Проверить, что отобразилось модальное окно с текстом \"Товар добавлен в корзину\"", () -> {
            itemsPage.checkModalWindowAfterAddingItemToCart(itemAddedMessage);
        });
    }

    @DisplayName("Проверка отображения добавленного товара в корзине")
    @Tag("cart")
    @Test
    void checkItemDisplayedInCart() {

        step("Открыть карточку товара в разделе \"Одежда\"", () -> {
            itemsPage.selectClothesSubTab()
                    .openItemCard();
        });

        step("Выбрать размер товара", () -> {
            itemsPage.openSizeDropdownList()
                    .selectSize();
        });

        step("Нажать на кнопку \"Добавить в корзину\"", () -> {
            itemsPage.clickAddToCartButton()
                    .clickNavigateToCartButton();
        });

        step("Проверить, что в корзине отображается 1 товар", () -> {
            itemsPage.checkTitleOfCartPage(cart)
                    .checkItemCountInCart(itemCount);
        });
    }

    @DisplayName("Проверка открытия выпадающего списка размеров при нажатии на кнопку \"Добавить в корзину\", " +
            "если размер не выбран")
    @Tag("cart")
    @Test
    void addItemToCartWithoutSize() {

        step("Открыть карточку товара в разделе \"Одежда\"", () -> {
            itemsPage.selectClothesSubTab()
                    .openItemCard();
        });

        step("Нажать на кнопку \"Добавить в корзину\"", () -> {
            itemsPage.clickAddToCartButton();
        });

        step("Проверить, что товар не добавлен, вместо этого открылся выпадающий список размеров", () -> {
            itemsPage.checkSizeDropdownListVisible();
        });
    }
}

