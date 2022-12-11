package steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import web.drivers.WebDriverFactory;
import web.helpers.JavaScriptHelper;
import web.pages.LaptopProductPage;

public class LaptopProductPageSteps {
    // Логгер
    private static Logger logger = LogManager.getLogger(LaptopProductPageSteps.class);


    private LaptopProductPage laptopProductPage;

    @Дано("Открыта страница \"Продукт. Ноутбук\"")
    public void openLaptopProductPage() {
        laptopProductPage = new LaptopProductPage(WebDriverFactory.getCurrentDriver());
        logger.info("Страница [Продукт. Ноутбук]: Открыта страница \"Продукт. Ноутбук\"");
    }
    @Когда("Раскрыт блок характеристик")
    public void showCharacteristicsBlock() {
        JavaScriptHelper.scrollBy(0, 500);
        laptopProductPage.accordeonСharacteristics().show();
        logger.info("Страница [Продукт. Ноутбук]: Раскрыт блок характеристик");
    }

    @Тогда("Проверка: Заголовок страницы \"Продукт. Ноутбук\" содержит текст {string}")
    public void assertPageTitle(String text) {
        Assertions.assertTrue(laptopProductPage.getPageTitle().contains(text),
                "Страница [Продукт. Ноутбук]: Ошибка! Заголовок страницы \"Продукт. Ноутбук\" не содержит текст \"" + text + "\"!");
        logger.info("Страница [Продукт. Ноутбук]: Заголовок страницы \"Продукт. Ноутбук\" содержит текст \"" + text + "\"");
    }

    @Тогда ("Проверка: В блоке Характеристики страницы \"Продукт. Ноутбук\" заголовок содержит текст {string}")
    public void assertCharacteristicsTitle(String text) {
        Assertions.assertTrue(laptopProductPage.labelСharacteristicsHeader().getText().contains(text),
                "Страница [Продукт. Ноутбук]: Ошибка! Заголовок в блоке Характеристики страницы \"Продукт. Ноутбук\" не содержит текст \"" + text + "\"!");
        logger.info("Страница [Продукт. Ноутбук]: Заголовок в блоке Характеристики страницы \"Продукт. Ноутбук\" содержит текст \"" + text + "\"");
    }

    @Тогда ("Проверка: В блоке Характеристики страницы \"Продукт. Ноутбук\" значение Объем оперативной памяти содержит текст {string}")
    public void assertCharacteristicsRam(String text) {
        JavaScriptHelper.scrollBy(0, 500);
        Assertions.assertTrue(laptopProductPage.labelRam().getText().contains(text),
                "Страница [Продукт. Ноутбук]: Ошибка! В блоке Характеристики страницы \"Продукт. Ноутбук\" значение Объем оперативной памяти не содержит текст \"" + text + "\"!");
        logger.info("Страница [Продукт. Ноутбук]: В блоке Характеристики страницы \"Продукт. Ноутбук\" значение Объем оперативной памяти содержит текст \"" + text + "\"");
    }

}