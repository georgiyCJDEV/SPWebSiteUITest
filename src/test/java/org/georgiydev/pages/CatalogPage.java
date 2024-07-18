package org.georgiydev.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.georgiydev.pages.PagesComponents.CategoriesDropdown;

import static com.codeborne.selenide.Selenide.$x;

/**
 * Страница каталога <hr>
 * 3. В фильтре выбираем Категория = Петунья
 */
public class CatalogPage extends Page {
    private static final String URL = "https://semena-partner.ru/catalog/tsvety/";
    private static final SelenideElement PETUNIAS_CATEGORY = $x("//*[@id='VID-styler']/div[2]/ul/li[3]");

    // Элемент дропдаун с категориями
    private static final CategoriesDropdown dropdown = new CategoriesDropdown();

    @Override
    public Page openUrl() {
        Selenide.open(URL);

        return this;
    }

    /**
     * Выбрать категорию - петуния в фильтре
     */
    public Page openPetuniasCategory() {
        dropdown.clickCategoriesDropdown()
                .clickCategory(PETUNIAS_CATEGORY);

        return this;
    }
}
