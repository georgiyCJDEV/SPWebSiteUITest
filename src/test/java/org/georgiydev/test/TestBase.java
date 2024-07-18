package org.georgiydev.test;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.georgiydev.configuration.SelenideSetup;
import org.georgiydev.pages.CatalogPage;
import org.georgiydev.pages.MainPage;
import org.georgiydev.pages.PetuniasPage;
import org.georgiydev.pages.ShoppingCartPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

 public class TestBase {
    // Путь до файла конфигураций в директории resources
    protected static final String PROPERTIES_FILE_PATH = "./src/test/resources/testConfig.properties";
    protected static SelenideSetup selenideSetup;

    // Объекты страниц
    protected MainPage mainPage = new MainPage();
    protected CatalogPage catalogPage = new CatalogPage();
    protected PetuniasPage petuniasPage = new PetuniasPage();
    protected ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    protected TestBase() {}

    /**
     * Конфигурация Selenide перед всеми тестами
     */
    @BeforeAll
    protected static void setUpProperties() {
        // Загрузка конфигураций для Selenide из файла
        selenideSetup = new SelenideSetup(PROPERTIES_FILE_PATH);
    }

    /**
     * Подготовка перед каждым тестом
     * Закрытие браузера если он открыт
     */
    @BeforeEach
    protected void closeBeforeTests() {
        // Если браузер открыт, закрываем его перед запуском теста
        if (WebDriverRunner.hasWebDriverStarted()) {
            Selenide.closeWebDriver();
        }
    }

    /**
     * Закрытие браузера после выполнения каждого теста
     */
    @AfterEach
    protected void closeBrowserInstance() {
        Selenide.closeWebDriver();
    }
}
