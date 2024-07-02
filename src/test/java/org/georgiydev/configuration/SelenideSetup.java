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
    private Boolean maximize;

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

        // Установление значения полю browser
        browser = propertiesParser.parseBrowser();
        if(browser == null) {
            throw new RuntimeException("Browser property not found");
        }

        // Установление значения булевому полю holdBrowserOpen
        holdBrowserOpen = propertiesParser.parseHoldBrowserOpen();
        // Установление значения полю browserSize
        browserSize = propertiesParser.parseBrowserSize();
        // Установление значения полю url
        url = propertiesParser.parseUrl();
        if(url == null) {
            throw new RuntimeException("Url property not found");
        }

        // Устанаовление значения полю maximize
        maximize = propertiesParser.parseMaximize();
    }

    /**
     * Конфигурация Selenide, поля класса Configuration заполняются
     * полученными из файла значениями
     */
    private void configure()
    {
        Configuration.browser = browser;
        Configuration.holdBrowserOpen = holdBrowserOpen != null ? holdBrowserOpen : false;
        Configuration.browserSize = browserSize != null ? browserSize : "1920x1080";

        maximize = maximize != null ? maximize : false;
    }

    /**
     * Открывает сайт по ссылке заданной в файле свойств для тестирования
     */
    public void openUrl()
    {
        Selenide.open(url);

        // Если maximize == true открываем браузер в полноэкранном режиме
        if(maximize) {
            WebDriverRunner.getWebDriver().manage().window().maximize();
        }
    }
}
