package org.georgiydev.configuration;

import com.codeborne.selenide.*;

import lombok.Getter;
import org.georgiydev.utils.PropertiesParser;

/**
 * Класс для взаимодействия с конфигурационным файлом и прочими
 * параметрами заданными через ресурс-файл testConfig.properties
 */
@Getter
public class SelenideSetup {
    private String url;
    private String browser;
    private Boolean holdBrowserOpen;
    private String browserSize;

    /**
     * В конструкторе вызывается метод loadProperties()
     * для загрузки значений для тестирования из файла и конфигурации Selenide
     */
    public SelenideSetup(String filepath)
    {
        this.loadProperties(filepath);
        this.configure();
    }

    /**
     * Метод для загрузки свойств из файла свойств для тестирования
     * @param filepath путь до properties файла
     */
    private void loadProperties(String filepath) {
        PropertiesParser propertiesParser = new PropertiesParser(filepath);

        // Установление значения статическому полю browser
        browser = propertiesParser.parseBrowser();
        // Установление значения статическому булевому полю holdBrowserOpen
        holdBrowserOpen = propertiesParser.parseHoldBrowserOpen();
        // Установление значения статическому полю browserSize
        browserSize = propertiesParser.parseBrowserSize();
        // Установление значение статическому полю url
        url = propertiesParser.parseUrl();
    }

    /**
     * Конфигурация Selenide, поля класса Configuration заполняются
     * полученными из файла значениями
     */
    private void configure()
    {
        Configuration.browser = browser;
        Configuration.holdBrowserOpen = holdBrowserOpen;
        Configuration.browserSize = browserSize;
    }

    /**
     * Открывает сайт по ссылке заданной в файле свойств для тестирования
     */
    public void openUrl()
    {
        Selenide.open(url);
    }
}
