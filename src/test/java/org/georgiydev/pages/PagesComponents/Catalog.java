package org.georgiydev.pages.PagesComponents;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;

/**
 * Класс для составного элемента - каталог
 */
public class Catalog {
    private static final SelenideElement CATALOG_BUTTON = $x("//div[@class=\"Wrapper Bottom-header_wrapper\"]/button[1]");

    /**
     * Проверить доступна ли для клика требуемая секция("цветы"),
     * если нет, сперва вызываем список секций нажатием на кнопку каталога
     * @param neededSection Требуемая секция (Цветы)
     */
    public Catalog proceedToSection(SelenideElement neededSection) {
        if (!neededSection.is(exist) ||
                !neededSection.is(visible) ||
                !neededSection.is(clickable)) {
            clickCatalogButton();
        }

        return this;
    }

    /**
     * Клик по кнопке каталога
     */
    public void clickCatalogButton() {
        CATALOG_BUTTON.click();
    }

    /** Клик по иконке цветов (секии цветов)
     *
     * @param neededSection Требуемая секция (цветы)
     */
    public Catalog clickSection(SelenideElement neededSection) {
        neededSection.click();

        return this;
    }
}
