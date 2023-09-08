package ru.lamoda.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ItemsPage {

    SelenideElement
            clothesSubTab = $$("._root_1416b_2 a").find(text("Одежда")),
            itemCard = $(".x-product-card__card"),
            sizeSelectionBox = $("._selectWrapper_1widv_10"),
            sizeDropdownList = $("._dropdown_1widv_123"),
            sizeSelected = $("._colspan_1widv_150:not(._colspanDisabled_1widv_169)"),
            addToCartButton = $$(".x-button").find(text("Добавить в корзину")),
            itemAddedModalWindow = $(".d-modal__frame"),
            itemAddedModalWindowTitle = $(".d-modal__header"),
            navigateToCartButton = $(".d-modal__bottom a"),
            cart = $("#cart"),
            itemCount = $("._count_1uvko_20"),
            addToFavoriteIcon = $(".x-product-card__card").$(".icon"),
            addToFavoriteModal = $(".d-modal__header"),
            addedItemInfo = $("._root_t2t70_2"),
            deleteButton = $$(".x-button").find(text("Удалить")),
            emptyCartTitle = $("._title_1wc5j_7");

    public ItemsPage selectClothesSubTab() {
        clothesSubTab.click();

        return this;
    }

    public ItemsPage openItemCard() {
        itemCard.click();

        return this;
    }

    public ItemsPage addToFavorites() {
        addToFavoriteIcon.click();

        return this;
    }

    public ItemsPage checkAddToFavoriteModalHeader(String value) {
        addToFavoriteModal.shouldHave(text(value));

        return this;
    }

    public ItemsPage openSizeDropdownList() {
        sizeSelectionBox.click();

        return this;
    }

    public ItemsPage checkSizeDropdownListVisible() {
        sizeDropdownList.should(visible);

        return this;
    }

    public ItemsPage selectSize() {
        sizeSelected.click();

        return this;
    }

    public ItemsPage clickAddToCartButton() {
        addToCartButton.click();

        return this;
    }

    public ItemsPage checkModalWindowAfterAddingItemToCart(String value) {
        itemAddedModalWindow.should(visible);
        itemAddedModalWindowTitle.shouldHave(text(value));

        return this;
    }

    public ItemsPage clickNavigateToCartButton() {
        navigateToCartButton.click();

        return this;
    }

    public ItemsPage checkTitleOfCartPage(String value) {
        cart.shouldHave(text(value));

        return this;
    }

    public ItemsPage checkItemCountInCart(String value) {
        itemCount.shouldHave(text(value));

        return this;
    }

    public ItemsPage hoverOverItemInfo() {
        addedItemInfo.hover();

        return this;
    }

    public ItemsPage clickDeleteItemFromCartButton() {
        deleteButton.click();

        return this;
    }

    public ItemsPage checkEmptyCartTitle(String value) {
        emptyCartTitle.should(text(value));

        return this;
    }
}

