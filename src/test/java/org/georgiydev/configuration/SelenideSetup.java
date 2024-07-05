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
    @Deprecated
    private String url;
    private String browser;
    private Boolean holdBrowserOpen;
    private String browserSize;
    private Boolean maximize;

    private static PropertiesParser propertiesParser;

    /**
     * В конструкторе вызывается метод loadProperties()
     * для загрузки значений для тестирования из файла и конфигурации Selenide
     * @param filepath путь до файла конфигураций
     */
    public SelenideSetup(String filepath)
    {
        propertiesParser = new PropertiesParser(filepath);
        this.loadProperties();
        this.configure();
    }

    /**
     * Метод для загрузки свойств из файла свойств для тестирования
     */
    private void loadProperties() {
        // Установление значения полю browser
        browser = propertiesParser.parseBrowser();
        if(browser == null) {
            throw new RuntimeException("Browser property not found, the tests won't run.");
        }

        // Установление значения булевому полю holdBrowserOpen
        holdBrowserOpen = propertiesParser.parseHoldBrowserOpen();
        // Установление значения полю browserSize
        browserSize = propertiesParser.parseBrowserSize();

        // Устанаовление значения полю maximize
        maximize = propertiesParser.parseMaximize();
    }

    /**
     * Загрузка url
     */
    @Deprecated
    private void loadUrlProperty()
    {
        url = propertiesParser.parseUrl();
        if(url == null) {
            throw new RuntimeException("Url property not found, the tests won't run.");
        }
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
    @Deprecated
    public void openUrl()
    {
        Selenide.open(url);

        // Если maximize == true открываем браузер в полноэкранном режиме
        if(maximize) {
            WebDriverRunner.getWebDriver().manage().window().maximize();
        }
    }
}
