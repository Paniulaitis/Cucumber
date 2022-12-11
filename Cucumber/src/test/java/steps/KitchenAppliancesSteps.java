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
import web.pages.FirstLvlCategoriesPage;

// Шаги и проверки на странице "Бытовая техника"
public class KitchenAppliancesSteps {
    // Логгер
    private static Logger logger = LogManager.getLogger(KitchenAppliancesSteps.class);

    private FirstLvlCategoriesPage kitchenAppliancesPage;

    @И("Открыта страница \"Бытовая техника. Техника для кухни\"")
    public void openKitchenAppliancesPage() {
        kitchenAppliancesPage = new FirstLvlCategoriesPage(WebDriverFactory.getCurrentDriver());
        logger.info("Страница [Бытовая техника. Техника для кухни]: Открыта страница \"Бытовая техника. Техника для кухни\"");
    }


    @Тогда("Проверка: Заголовок страницы \"Бытовая техника. Техника для кухни\" содержит текст {string}")
    public void assertPageTitle(String text) {
        Assertions.assertTrue(kitchenAppliancesPage.labelAppliances().getText().contains(text),
                "Страница [Бытовая техника]: Ошибка! Заголовок страницы \"Бытовая техника. Техника для кухни\" не содержит текст \"" + text + "\"!");
        logger.info("Страница [Бытовая техника]: Заголовок страницы \"Бытовая техника. Техника для кухни\" содержит текст \"" + text + "\"");
    }

    @Тогда("Проверка: На странице \"Бытовая техника. Техника для кухни\" есть кнопка содеращая текст {string}")
    public void assertAssembleKitchenButton(String text) {
        Assertions.assertTrue(kitchenAppliancesPage.linkAssembleYourKitchen().getText().contains(text),
                "Страница [Бытовая техника. Техника для кухни]: Ошибка! Нет кнопки содержащей текст \"" + text + "\"!");
        logger.info("Страница [Бытовая техника. Техника для кухни]: Кнопка содержит текст \"" + text + "\"");
    }

    @Тогда("Проверка: На странице \"Бытовая техника. Техника для кухни\" количество категорий больше \"{int}\"")
    public void assertKitchenCategoriesCount(int count) {
        for (WebElement element : kitchenAppliancesPage.listSubcategoryItemContainer().getListWebElements()) {
            logger.info("WebElement: " + element.getTagName() + " = " + element.getText());
        }
        Assertions.assertTrue(kitchenAppliancesPage.listSubcategoryItemContainer().getListWebElements().size() > count,
                "Страница [Бытовая техника. Техника для кухни]: Ошибка! Количество категорий не больше \"" + count + "\"!");
        logger.info("Страница [Бытовая техника. Техника для кухни]: Количество категорий больше \"" + count + "\"");
    }
}