package ru.lamoda.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AddedToCartModalComponent {

    SelenideElement
            itemAddedModalWindow = $(".d-modal__frame"),
            itemAddedModalWindowTitle = $(".d-modal__header"),
            navigateToCartButton = $(".d-modal__bottom a");

    public void checkModalWindowAfterAddingItemToCart(String value) {
        itemAddedModalWindow.should(visible);
        itemAddedModalWindowTitle.shouldHave(text(value));
    }

    public void clickNavigateToCartButton() {
        navigateToCartButton.click();
    }
}
