package org.georgiydev.pages.PagesComponents;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CategoriesDropdown {
    private static final SelenideElement categoriesDropdown = $("[class=jq-selectbox__select-text]"),
            neededCategory = $x("//*[@id='VID-styler']/div[2]/ul/li[3]");

    public CategoriesDropdown clickCategories() {
        categoriesDropdown.click();

        return this;
    }

    public CategoriesDropdown selectCategory() {
        neededCategory.click();

        return this;
    }
}
