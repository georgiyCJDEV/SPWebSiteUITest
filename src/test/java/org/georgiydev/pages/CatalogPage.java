package org.georgiydev.pages;

import com.codeborne.selenide.Selenide;
import org.georgiydev.pages.PagesComponents.CategoriesDropdown;

/**
 * 3. В фильтре выбираем Категория = Петунья
 */
public class CatalogPage extends Page {
    private static final String url = "https://semena-partner.ru/catalog/tsvety/";

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
                .selectCategory();

        return this;
    }
}
