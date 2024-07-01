package org.georgiydev.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Класс для парсинга свойств из конфигурационного файла:
 * ./src/test/resources/testConfig.properties
 * Свойства в файле должны быть заданы в форме 'НазваниеСвойства=ЗначениеСвойства'
 */
public class PropertiesParser {
    // Путь до конфигурационного файла
   private static final String filepath = "./src/test/resources/testConfig.properties";

    /**
     * Парсинг строки браузера из конфигурационного файла
     * @return Название браузера
     */
    public static String parseBrowser()
    {
        return parse("browser");
    }

    /**
     * Парсинг строки со ссылкой на сайт из конфигурационного файла
      * @return Ссылка на сайт
     */
    public static String parseUrl()
    {
        return parse("url");
    }

    /**
     * Парсинг строки с булевым параметром удержания открытого браузера
     * @return Удерживать ли браузер открытым после выполнения тестов
     */
    public static Boolean parseHoldBrowserOpen()
    {
        return Boolean.parseBoolean(parse("holdBrowserOpen"));
    }

    /**
     * Парсинг размеров окна открываемого браузера
     * @return Размеры окна (Ширина x Высота)
     */
    public static String parseBrowserSize()
    {
        return parse("browserSize");
    }

    /**
     * Метод парсинга свойств из конфигурационного файла
     * @param propertyName Название свойства
     * @return Значение свойства
     */
    private static String parse(String propertyName)
    {
        try{
            // Поток ввода из файла
            FileInputStream fis = new FileInputStream(filepath);

            // Метод для парсинга свойств
            Properties properties = new Properties();
            properties.load(fis);

            // Возвращение значения свойства по заданному названию
            return properties.getProperty(propertyName);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
