package org.georgiydev.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.Visible;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

/**
 * 4. Добавляем в корзину любую петунью
 * 5. Проверяем, что в верхнем правом окошке появилась 1 позиция
 * 6. Открываем корзину
 */
public class PetuniasPage extends Page {
    private static final String url = "https://semena-partner.ru/catalog/tsvety/odnoletnie/petuniya/";
    private static final SelenideElement addToCartButton = $x("//div[@class=\"catalog-wrap\"]/div[@class=\"Product\"]/div[1]//a[@class=\"Product_link add-btn ee\"]"),
            cartItemsCounter = $("[id=num_products]"),
            openCartButton = $x("//*[@id=\"bottom-wrapper\"]/a[1]"),
            productName = $x("//div[@class=\"catalog-wrap\"]/div[@class=\"Product\"]/div[1]/div[@class=\"Product_content\"]/a/div[@itemprop=\"name\"][text()[contains(.,\"Петуния\")]]");

    @Override
    public Page openUrl() {
        Selenide.open(url);

        return this;
    }

    // Проверка загрузилась ли страница после выбора петуний в фильтре
    public PetuniasPage checkIfLoaded() {
        productName.shouldBe(exist);
        return this;
    }

    // Клик по кнопке добавить в корзину
    public PetuniasPage addToCart() {
        addToCartButton.click();

        return this;
    }

    // Проверка счётчика товаров в корзине
    public PetuniasPage checkCount() {
        cartItemsCounter.shouldHave(text("1"));

        return this;
    }

    // Клик по кнопке открытия корзины
    public PetuniasPage openCart() {
        openCartButton.click();

        return this;
    }
}
