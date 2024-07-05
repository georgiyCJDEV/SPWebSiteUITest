package org.georgiydev.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.georgiydev.pages.PagesComponents.CategoriesDropdown;

import static com.codeborne.selenide.Selenide.$x;

/**
 * 3. В фильтре выбираем Категория = Петунья
 */
public class CatalogPage extends Page {
    private static final String url = "https://semena-partner.ru/catalog/tsvety/";
    private static final SelenideElement petuniasCategory = $x("//*[@id='VID-styler']/div[2]/ul/li[3]");

    @Override
    public Page openUrl() {
        Selenide.open(url);

        return this;
    }

    // Выбираем категорию петуния в фильтре
    public Page selectCategoryPetunias() {
        CategoriesDropdown dropdown = new CategoriesDropdown();
        // Клик по дропдауну и клик по категории
        dropdown.clickCategories()
                .selectCategory(petuniasCategory);

        return this;
    }
}
