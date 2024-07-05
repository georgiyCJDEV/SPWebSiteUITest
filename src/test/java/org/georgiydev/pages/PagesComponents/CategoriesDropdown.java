package org.georgiydev.pages.PagesComponents;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CategoriesDropdown {
    private static final SelenideElement categoriesDropdown = $("[class=jq-selectbox__select-text]");

    public CategoriesDropdown clickCategories() {
        categoriesDropdown.click();

        return this;
    }

    public CategoriesDropdown selectCategory(SelenideElement neededCategory) {
        neededCategory.click();

        return this;
    }
}
