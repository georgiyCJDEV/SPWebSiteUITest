package org.georgiydev.pages.PagesComponents;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

/**
 * Класс для элемента - каталог
 */
public class Catalog {
    private static final SelenideElement catalogButton = $x("//div[@class=\"Wrapper Bottom-header_wrapper\"]/button[1]"),
            flowersIcon = $(".flowers-icon");

    // Если иконка цветов не отображается на странице
    public Catalog proceedToFlowers() {
        if (!flowersIcon.is(exist) ||
                !flowersIcon.is(visible) ||
                !flowersIcon.is(clickable)) {
            clickCatalogButton();
        }

        return this;
    }

    // Клик по кнопке каталога
    public void clickCatalogButton() {
        catalogButton.click();
    }

    // Клик по иконке цветов
    public Catalog flowersClick() {
        flowersIcon.click();

        return this;
    }
}
