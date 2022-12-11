package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import web.drivers.WebDriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import web.helpers.WaitHelper;
import web.pages.ProductPage;


public class EStovePageSteps {
    // Логгер
    private static Logger logger = LogManager.getLogger(EStovePageSteps.class);


    private ProductPage eStovePage;

    @И("Открыта страница \"Бытовая техника. Плиты и печи. Плиты электрические\"")
    public void openEStovePagePage() {
        eStovePage = new ProductPage(WebDriverFactory.getCurrentDriver());
        logger.info("Страница [Бытовая техника. Плиты и печи. Плиты электрические]: Открыта страница \"Бытовая техника. Плиты и печи. Плиты электрические\"");
    }

    @Тогда("Проверка: На странице \"Бытовая техника. Плиты и печи. Плиты электрические\" товаров больше \"{int}\"")
    public void assertKitchenCategoriesCount(int count) {
        String countText = eStovePage.labelProductsCount().getText();
        int actualCount = Integer.parseInt(countText.replaceAll("[^0-9]", ""));
        Assertions.assertTrue(actualCount > count,
                "Страница [Бытовая техника. Плиты и печи. Плиты электрические]: Ошибка! Товаров не больше \"" + count + "\"!");
        logger.info("Страница [Бытовая техника. Плиты и печи. Плиты электрические]: Товаров больше \"" + count + "\"");
    }
}