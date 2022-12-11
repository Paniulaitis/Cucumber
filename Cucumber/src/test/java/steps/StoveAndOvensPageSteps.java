package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

import org.junit.jupiter.api.Assertions;
import web.drivers.WebDriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import web.helpers.WaitHelper;
import web.pages.FirstLvlCategoriesPage;


public class StoveAndOvensPageSteps {
    // Логгер
    private static Logger logger = LogManager.getLogger(StoveAndOvensPageSteps.class);

    private FirstLvlCategoriesPage stoveAndOvensPage;

    @Дано("Открыта страница \"Бытовая техника. Плиты и печи\"")
    public void openStoveAndOvensPage() {
        stoveAndOvensPage = new FirstLvlCategoriesPage(WebDriverFactory.getCurrentDriver());
        logger.info("Страница [Бытовая техника]: Открыта страница \"Бытовая техника. Плиты и печи\"");
    }

    @Когда("Выполнен переход на страницу \"Бытовая техника. Плиты и печи. Плиты электрические\"")
    public void goToEStovePage() {
        stoveAndOvensPage.linkEStove().click();
        logger.info("Страница [Бытовая техника]: Выполнен переход на страницу \"Бытовая техника. Техника для кухни\"");
    }
}