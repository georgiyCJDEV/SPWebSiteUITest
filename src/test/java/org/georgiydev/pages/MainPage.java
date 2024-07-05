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
    private static final String url = "https://semena-partner.ru/";
    private static final SelenideElement flowersSection = $(".flowers-icon");

    // Открываем сайт
    @Override
    public MainPage openUrl() {
        Selenide.open(url);

        return this;
    }

    // Выбираем Цветы
    public MainPage chooseFlowers() {
        Catalog catalog = new Catalog();
        // Переход к цветам и клик по иконке цветов в каталоге
        catalog.proceedToSection(flowersSection)
                .sectionClick(flowersSection);

        return this;
    }
}
