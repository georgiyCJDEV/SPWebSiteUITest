package org.georgiydev.pages;

import com.codeborne.selenide.Selenide;
import org.georgiydev.pages.PagesComponents.Catalog;

/**
 * 1. Открываем интернет магазин
 * 2. Выбираем Цветы в левом меню
 */
public class MainPage extends Page {
    private static final String url = "https://semena-partner.ru/";

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
        catalog.proceedToFlowers()
                .flowersClick();

        return this;
    }
}
