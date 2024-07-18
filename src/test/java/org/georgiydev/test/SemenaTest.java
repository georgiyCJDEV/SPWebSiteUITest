package org.georgiydev.test;

import org.junit.jupiter.api.Test;

/**
 * Класс для автоматизации чеклиста: <br>
 *      1. Открываем интернет магазин <br>
 *      2. Выбираем Цветы в левом меню <br>
 *      3. В фильтре выбираем Категория = Петунья <br>
 *      4. Добавляем в корзину любую петунью <br>
 *      5. Проверяем, что в верхнем правом окошке появилась 1 позиция <br>
 *      6. Открываем корзину <br>
 *      7. Удаляем через иконку мусорки <br>
 *      8. Проверяем информацию, что товар был удален и есть кнопка восстановить
 */
public class SemenaTest extends TestBase {
    /**
     * Тест удаления товара из корзины
     */
    @Test
    public void checkProductRemovalFromCart() {
        mainPage.openUrl()
                .openFlowersSection();

        catalogPage.openPetuniasCategory();

        petuniasPage.checkIfPageHasLoaded()
                .clickAddToCartButton()
                .checkCartQuantity()
                .clickCartButton();

        shoppingCartPage.checkIfItemIsInCart()
                .clickRemoveFromCartButton()
                .checkIfItemRemoved()
                .checkIfNotificationAppeared()
                .checkIfRecoverButtonAppeared();
    }
}
