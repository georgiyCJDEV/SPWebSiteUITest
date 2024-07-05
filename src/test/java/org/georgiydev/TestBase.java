package org.georgiydev;

import org.georgiydev.configuration.SelenideSetup;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    // Путь до файла конфигураций в директории resources
    protected static final String propertiesFilePath = "./src/test/resources/testConfig.properties";
    protected static SelenideSetup selenideSetup;
    /**
     * Конфигурация Selenide перед всеми тестами
     */
    @BeforeAll
    public static void setUpProperties() {
        // Загрузка конфигураций для Selenide из файла
        selenideSetup = new SelenideSetup(propertiesFilePath);
    }
}
