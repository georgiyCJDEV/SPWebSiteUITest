package org.georgiydev;

import com.codeborne.selenide.Selenide;
import org.georgiydev.configuration.SelenideSetup;
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
public class SemenaTest {
    private static SelenideSetup selenideSetup;
    /**
     * Подготовка к тестам
     */
    @BeforeAll
    public static void setUp() {
        // Загрузка конфигураций для Selenide из файла testConfig.properties
        // в директории resources
        selenideSetup = SelenideSetup.getInstance();

        // Закрытие открытого браузера перед запуском тестов
        Selenide.closeWebDriver();
    }

    /**
     * Тест веб-сайта
     */
    @Test
    public void websiteTest()
    {
        // Открываем сайт https://semena-partner.ru/,
        // ссылку парсим из .src/test/resources/testConfig.properties
        selenideSetup.openUrl();

        // В каталоге товаров кликаем по иконке цветов
        $(".flowers-icon").click();

        // На открывшейся странице кликаем по дропдауну "Выберите категорию"
        $("[class=jq-selectbox__select-text]").click();
        // В появившемся дропдауне кликаем на категорию "Петуния"
        $x("//*[@id='VID-styler']/div[2]/ul/li[3]").click();

        // Нажимаем кпопку "Добавить в корзину" под одним из товаров
        $x("//a[@data-id=\"53377\"][@class=\"Product_link add-btn ee\"]").click();
        // Проверяем что возле иконки корзины появилась 1 позиция
        $("[id=num_products]").shouldHave(text("1"));
        // Кликаем по иконке корзины для перехода в корзину
        $x("//*[@id=\"bottom-wrapper\"]/a[1]").click();

        // Кликаем по иконке мусорного бака для удаления товара из корзины
        $("span.basket-item-actions-remove").click();
        // Проверяем удалился ли товар (Не существует ли товар после нажатия иконки удаления)
        $x("//*[@data-entity=\"basket-item-name\"]").shouldNotBe(exist);
        // Проверяем существует ли элемент, показывающий то, что товар был удалён из корзины
        $(".basket-items-list-item-notification-removed").shouldBe(exist);

        // Проверяем появилась ли кнопка восстановить
        $x("//*[@data-entity=\"basket-item-restore-button\"]").shouldBe(exist);
    }

    /**
     * Закрытие браузера после выполнения каждого теста
     */
    @AfterEach
    public void closeBrowser()
    {
        Selenide.closeWebDriver();
    }
}
