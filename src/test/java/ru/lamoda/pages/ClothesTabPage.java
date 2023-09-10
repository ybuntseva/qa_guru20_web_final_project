package ru.lamoda.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ClothesTabPage {

    private SelenideElement
            clothesSubTab = $$("._root_1416b_2 a").find(text("Одежда")),
            addToFavoriteIcon = $(".x-product-card__card").$(".icon"),
            itemCard = $(".x-product-card__card");

    public ClothesTabPage selectClothesSubTab() {
        clothesSubTab.click();

        return this;
    }

    public ClothesTabPage addToFavorites() {
        addToFavoriteIcon.click();

        return this;
    }

    public ClothesTabPage openItemCard() {
        itemCard.click();

        return this;
    }
}
