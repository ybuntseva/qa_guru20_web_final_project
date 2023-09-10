package ru.lamoda.pages;

import com.codeborne.selenide.SelenideElement;
import ru.lamoda.components.AddedToCartModalComponent;
import ru.lamoda.components.FavoriteModalComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ItemCardPage {

    FavoriteModalComponent favoriteModalComponent = new FavoriteModalComponent();
    AddedToCartModalComponent addedToCartModalComponent = new AddedToCartModalComponent();

    private SelenideElement
            sizeSelectionBox = $("._selectWrapper_1widv_10"),
            sizeDropdownList = $("._dropdown_1widv_123"),
            addToCartButton = $$(".x-button").find(text("Добавить в корзину")),
            sizeSelected = $("._colspan_1widv_150:not(._colspanDisabled_1widv_169)");

    public ItemCardPage openSizeDropdownList() {
        sizeSelectionBox.click();

        return this;
    }

    public ItemCardPage checkSizeDropdownListVisible() {
        sizeDropdownList.should(visible);

        return this;
    }

    public ItemCardPage selectSize() {
        sizeSelected.click();

        return this;
    }

    public ItemCardPage clickAddToCartButton() {
        addToCartButton.click();

        return this;
    }

    public ItemCardPage checkAddToFavoriteModalHeader(String value) {
        favoriteModalComponent.checkAddToFavoriteModalHeader(value);

        return this;
    }

    public ItemCardPage checkModalWindowAfterAddingItemToCart(String value) {
        addedToCartModalComponent.checkModalWindowAfterAddingItemToCart(value);

        return this;
    }

    public ItemCardPage clickNavigateToCartButton() {
        addedToCartModalComponent.clickNavigateToCartButton();

        return this;
    }
}
