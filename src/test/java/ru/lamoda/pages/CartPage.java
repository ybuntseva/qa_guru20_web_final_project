package ru.lamoda.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CartPage {

    private SelenideElement
            cart = $("#cart"),
            itemCount = $("._count_1uvko_20"),
            addedItemInfo = $("._root_t2t70_2"),
            deleteButton = $$(".x-button").find(text("Удалить")),
            emptyCartTitle = $("._title_k4g9v_9");

    public CartPage checkTitleOfCartPage(String value) {
        cart.shouldHave(text(value));

        return this;
    }

    public CartPage checkItemCountInCart(String value) {
        itemCount.shouldHave(text(value));

        return this;
    }

    public CartPage hoverOverItemInfo() {
        addedItemInfo.hover();

        return this;
    }

    public CartPage clickDeleteItemFromCartButton() {
        deleteButton.click();

        return this;
    }

    public CartPage checkEmptyCartTitle(String value) {
        emptyCartTitle.should(text(value));

        return this;
    }
}

