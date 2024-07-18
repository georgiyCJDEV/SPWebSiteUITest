package org.georgiydev.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.georgiydev.pages.PagesComponents.Catalog;

import static com.codeborne.selenide.Selenide.$;

/**
 * Начальная страница сайта <hr>
 * 1. Открываем интернет магазин <br>
 * 2. Выбираем Цветы в левом меню
 */
public class MainPage extends Page {
    private static final String URL = "https://semena-partner.ru/";
    private static final SelenideElement FLOWERS_SECTION = $(".flowers-icon");

    // Элемент каталог с секциями
    private static final Catalog catalog = new Catalog();

    @Override
    public MainPage openUrl() {
        Selenide.open(URL);

        return this;
    }

    /**
     * Выбрать Цветы в левом меню
     */
    public MainPage openFlowersSection() {
        catalog.proceedToSection(FLOWERS_SECTION)
                .clickSection(FLOWERS_SECTION);

        return this;
    }
}
