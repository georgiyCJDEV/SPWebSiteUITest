package org.georgiydev.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

/**
 * 7. Удаляем через иконку мусорки
 * 8. Проверяем информацию, что товар был удален и есть кнопка восстановить
 */
public class ShoppingCartPage extends Page {
    private static final String url = "https://semena-partner.ru/personal/cart/";
    private static final SelenideElement removeFromCartButton = $("span.basket-item-actions-remove"),
            cartItemName = $x("//*[@data-entity=\"basket-item-name\"]"),
            removeNotifier = $(".basket-items-list-item-notification-removed"),
            recoverButton = $x("//*[@data-entity=\"basket-item-restore-button\"]");

    @Override
    public Page openUrl() {
        Selenide.open(url);

        return this;
    }

    // Клик по кнопке удаления товара из корзины
    public ShoppingCartPage removeFromCart() {
        removeFromCartButton.click();
        return this;
    }

    // Проверка что товара нет в корзине
    public ShoppingCartPage checkIfRemoved() {
        cartItemName.shouldNotBe(exist);
        return this;
    }

    // Проверка что появилось сообщение об удалении
    public ShoppingCartPage checkIfNotified() {
        removeNotifier.shouldBe(exist);
        return this;
    }

    // Проверка что появилась кнопка "восстановить"
    public ShoppingCartPage checkRecoverBtnAppears() {
        recoverButton.shouldBe(exist);
        return this;
    }
}
