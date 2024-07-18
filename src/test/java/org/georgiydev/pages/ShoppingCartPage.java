package org.georgiydev.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

/**
 * Страница корзины <hr>
 * 7. Удаляем через иконку мусорки <br>
 * 8. Проверяем информацию, что товар был удален и есть кнопка восстановить
 */
public class ShoppingCartPage extends Page {
    private static final String URL = "https://semena-partner.ru/personal/cart/";
    private static final SelenideElement REMOVE_FROM_CART_BUTTON = $("span.basket-item-actions-remove"),
            CART_ITEM_NAME = $x("//*[@data-entity=\"basket-item-name\"]"),
            REMOVE_NOTIFIER = $(".basket-items-list-item-notification-removed"),
            RECOVER_BUTTON = $x("//*[@data-entity=\"basket-item-restore-button\"]");

    @Override
    public Page openUrl() {
        Selenide.open(URL);

        return this;
    }

    /**
     * Проверить что товар находится в корзине
     */
    public ShoppingCartPage checkIfItemIsInCart() {
        CART_ITEM_NAME.shouldBe(exist);
        return this;
    }

    /**
     * Клик по кнопке удаления товара из корзины
     */
    public ShoppingCartPage clickRemoveFromCartButton() {
        REMOVE_FROM_CART_BUTTON.click();
        return this;
    }

    /**
     * Проверить что товара нет в корзине
     */
    public ShoppingCartPage checkIfItemRemoved() {
        CART_ITEM_NAME.shouldNotBe(exist);
        return this;
    }

    /**
     * Проверить что появилось сообщение об удалении
     */
    public ShoppingCartPage checkIfNotificationAppeared() {
        REMOVE_NOTIFIER.shouldBe(exist);
        return this;
    }

    /**
     * Проверить что появилась кнопка "Восстановить"
     */
    public ShoppingCartPage checkIfRecoverButtonAppeared() {
        RECOVER_BUTTON.shouldBe(exist);
        return this;
    }
}
