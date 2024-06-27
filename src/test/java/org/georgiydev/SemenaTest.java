package org.georgiydev;

/*1. Открываем интернет магазин
  2. Выбираем Цветы в левом меню
  3. В фильтре выбираем Категория = Петунья
  4. Добавлям в корзину любую петунью
  5. Проверяем, что в верхнем правом окошке появилась 1 позиция
  6. Открываем корзину
  7. Удаляем через иконку мусорки
  8. Проверяем информацию, что товар был удален и есть кнопка восстановить
 */

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SemenaTest {

    @BeforeAll
    public static void openBrowser() {
        Configuration.browser = "edge";

        Selenide.open("https://semena-partner.ru/");
    }
    @Test
    public void filterTest()
    {
        // Выбираем цветы
        $(".flowers-icon").click();
        // Клик по категориям
        $("[class=jq-selectbox__select-text]").click();
        // Клик по петуниям
        $x("//*[@id='VID-styler']/div[2]/ul/li[3]").click();
    }

    @Test
    public void shoppingCartTest()
    {
        // Добавляем в корзину петунью
        $x("//*[@id=\"product-item-53377\"]/div[2]/a[2]").click();
        // Проверяем что появилась 1 позиция
        $("[id=num_products]").shouldHave(text("1"));

        // Переходим в корзину
        $x("//*[@id=\"bottom-wrapper\"]/a[1]").click();
        // Сохраняем название товара
        String checkStr = $x("//span[@data-entity=\"basket-item-name\"]").getText();

        // Удаляем товар
        $x("//span[@class=\"basket-item-actions-remove \"]").click();

        // Проверяем информацию, что товар был удалён
        $x("//div[@class=\"basket-items-list-item-removed-container\"]/div/strong").shouldHave(text(checkStr));

        // Проверяем есть ли кнопка восстановить
        $x("//*[@class=\"basket-items-list-item-removed-container\"]/div[2]").exists();
    }

    @AfterAll
    public static void closeBrowser()
    {
        Selenide.closeWebDriver();
    }
}
