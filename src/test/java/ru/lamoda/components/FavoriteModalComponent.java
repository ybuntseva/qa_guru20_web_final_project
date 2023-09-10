package ru.lamoda.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class FavoriteModalComponent {

    SelenideElement
            addToFavoriteModal = $(".d-modal__header");

    public void checkAddToFavoriteModalHeader(String value) {
        addToFavoriteModal.shouldHave(text(value));
    }
}
