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

// Шаги и проверки на странице "Бытовая техника"
public class AppliancesSteps {
    // Логгер
    private static Logger logger = LogManager.getLogger(AppliancesSteps.class);

    // Страница "Бытовая техника"
    private FirstLvlCategoriesPage appliancesPage;

    @Дано("Открыта страница \"Бытовая техника\"")
    public void openAppliancesPage() {
        appliancesPage = new FirstLvlCategoriesPage(WebDriverFactory.getCurrentDriver());
        logger.info("Страница [Бытовая техника]: Открыта страница \"Бытовая техника\"");
    }

    @Когда("Выполнен переход на страницу \"Бытовая техника. Техника для кухни\"")
    public void goToKitchenAppliancesPage() {
        appliancesPage.linkAppliancesKitchen().click();
        logger.info("Страница [Бытовая техника]: Выполнен переход на страницу \"Бытовая техника. Техника для кухни\"");
    }

    @Тогда("Проверка: Заголовок страницы \"Бытовая техника\" содержит текст {string}")
    public void assertPageTitle(String text) {
        Assertions.assertTrue(appliancesPage.labelAppliances().getText().contains(text),
                "Страница [Бытовая техника]: Ошибка! Заголовок страницы \"Бытовая техника\" не содержит текст \"" + text + "\"!");
        logger.info("Страница [Бытовая техника]: Заголовок страницы \"Бытовая техника\" содержит текст \"" + text + "\"");
    }
}