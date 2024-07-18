package org.georgiydev.pages.PagesComponents;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

/**
 * Класс для составного элемента - выпадающий список с категориями
 */
public class CategoriesDropdown {
    private static final SelenideElement CATEGORIES_DROPDOWN = $("[class=jq-selectbox__select-text]");

    /**
     * Клик по дропдауну категорий
     */
    public CategoriesDropdown clickCategoriesDropdown() {
        CATEGORIES_DROPDOWN.click();

        return this;
    }

    /**
     * Клик по выбранной категории
     * @param neededCategory Требуемая категория (Петунии)
     */
    public CategoriesDropdown clickCategory(SelenideElement neededCategory) {
        neededCategory.click();

        return this;
    }
}
