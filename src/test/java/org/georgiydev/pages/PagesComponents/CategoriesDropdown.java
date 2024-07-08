package org.georgiydev.pages.PagesComponents;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CategoriesDropdown {
    private static final SelenideElement CATEGORIES_DROPDOWN = $("[class=jq-selectbox__select-text]");

    public CategoriesDropdown clickCategories() {
        CATEGORIES_DROPDOWN.click();

        return this;
    }

    public CategoriesDropdown selectCategory(SelenideElement neededCategory) {
        neededCategory.click();

        return this;
    }
}
