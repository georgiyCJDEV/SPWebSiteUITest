package org.georgiydev.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.georgiydev.pages.PagesComponents.Catalog;

import static com.codeborne.selenide.Selenide.$;

/**
 * 1. Открываем интернет магазин
 * 2. Выбираем Цветы в левом меню
 */
public class MainPage extends Page {
    private static final String URL = "https://semena-partner.ru/";
    private static final SelenideElement FLOWERS_SECTION = $(".flowers-icon");

    // Открываем сайт
    @Override
    public MainPage openUrl() {
        Selenide.open(URL);

        return this;
    }

    // Выбираем Цветы
    public MainPage chooseFlowers() {
        Catalog catalog = new Catalog();
        // Переход к цветам и клик по иконке цветов в каталоге
        catalog.proceedToSection(FLOWERS_SECTION)
                .sectionClick(FLOWERS_SECTION);

        return this;
    }
}
