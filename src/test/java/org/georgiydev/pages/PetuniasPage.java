package org.georgiydev.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

/**
 * Страница категории "Петунии" <hr>
 * 4. Добавляем в корзину любую петунью <br>
 * 5. Проверяем, что в верхнем правом окошке появилась 1 позиция <br>
 * 6. Открываем корзину
 */
public class PetuniasPage extends Page {
    private static final String URL = "https://semena-partner.ru/catalog/tsvety/odnoletnie/petuniya/";
    private static final SelenideElement ADD_TO_CART_BUTTON = $x("//div[@class=\"catalog-wrap\"]/div[@class=\"Product\"]/div[1]//a[@class=\"Product_link add-btn ee\"]"),
            CART_ITEMS_COUNTER = $("[id=num_products]"),
            OPEN_CART_BUTTON = $x("//*[@id=\"bottom-wrapper\"]/a[1]"),
            PRODUCT_NAME = $x("//div[@class=\"catalog-wrap\"]/div[@class=\"Product\"]/div[1]/div[@class=\"Product_content\"]/a/div[@itemprop=\"name\"][text()[contains(.,\"Петуния\")]]");

    @Override
    public Page openUrl() {
        Selenide.open(URL);

        return this;
    }

    /**
     * Проверить загрузилась ли страница после выбора петуний в фильтре
     */
    public PetuniasPage checkIfPageHasLoaded() {
        PRODUCT_NAME.shouldBe(exist);
        return this;
    }

    /**
     * Клик по кнопке добавить в корзину
     */
    public PetuniasPage clickAddToCartButton() {
        ADD_TO_CART_BUTTON.click();

        return this;
    }

    /**
     * Проверить счётчик товаров в корзине
     */
    public PetuniasPage checkCartQuantity() {
        CART_ITEMS_COUNTER.shouldHave(text("1"));

        return this;
    }

    /**
     * Кликнуть по кнопке открытия корзины
     */
    public PetuniasPage clickCartButton() {
        OPEN_CART_BUTTON.click();

        return this;
    }
}
