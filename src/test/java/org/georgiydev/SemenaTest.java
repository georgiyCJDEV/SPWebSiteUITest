package org.georgiydev;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.georgiydev.pages.CatalogPage;
import org.georgiydev.pages.MainPage;
import org.georgiydev.pages.PetuniasPage;
import org.georgiydev.pages.ShoppingCartPage;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

/**
 * Класс для теста последовательности действий:
 * 1. Открываем интернет магазин
 * 2. Выбираем Цветы в левом меню
 * 3. В фильтре выбираем Категория = Петунья
 * 4. Добавляем в корзину любую петунью
 * 5. Проверяем, что в верхнем правом окошке появилась 1 позиция
 * 6. Открываем корзину
 * 7. Удаляем через иконку мусорки
 * 8. Проверяем информацию, что товар был удален и есть кнопка восстановить
 */
public class SemenaTest extends TestBase {
    /**
     * Подготовка перед каждым тестом
     * Закрытие браузера если он открыт
     */
    @BeforeEach
    public void closeBeforeTests() {
        // Если браузер открыт, закрываем его перед запуском теста
        if (WebDriverRunner.hasWebDriverStarted()) {
            Selenide.closeWebDriver();
        }
    }

    /**
     * Тест веб-сайта
     */
    @Test
    public void websiteTest() {
        // Основная страница
        MainPage mainPage = new MainPage();
        // Открытие сайта, выбор цветов в каталоге
        mainPage.openUrl()
                .chooseFlowers();

        // Страница каталога
        CatalogPage catalogPage = new CatalogPage();
        // Выбор категории петунии в каталоге
        catalogPage.selectCategoryPetunias();

        // Страница петуний
        PetuniasPage petuniasPage = new PetuniasPage();
        // Проверка что страница загружена, добавление товара в корзину, проверка счётчика товаров возле иконки корзины,
        //                                                              открытие корзины
        petuniasPage.checkIfLoaded()
                .addToCart()
                .checkCount()
                .openCart();

        // Страница корзины
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        // Удаление из корзины, проверка удаления, проверка сообщения об удалении, проверка наличия кнопки восстановления
        shoppingCartPage.removeFromCart()
                .checkIfRemoved()
                .checkIfNotified()
                .checkRecoverBtnAppears();
    }

    /**
     * Закрытие браузера после выполнения каждого теста
     */
    @AfterEach
    public void closeBrowserInstance() {
        Selenide.closeWebDriver();
    }
}
