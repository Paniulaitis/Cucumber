package steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import web.drivers.WebDriverFactory;
import web.pages.StartPage;

public class StartPageSteps {

    private static Logger logger = LogManager.getLogger(StartPageSteps.class);
    private StartPage startPage;

    @Дано("Открыта страница \"Стартовая страница сайта DNS\"")
    public void openStartPage() {
        startPage = new StartPage(WebDriverFactory.getCurrentDriver());
        startPage.openPage();
        logger.info("Страница [Стартовая страница DNS]: Открыта \"Стартовая страница сайта DNS\"");
    }

    @Когда("Скрыт блок подтверждения города")
    public void hideSityСonfirmation() {
        startPage.blockYes().hide();
        logger.info("Страница [Стартовая страница DNS]: Скрыт блок подтверждения города");
    }

    @Когда("Выполнен переход на страницу \"Смартфоны\"")
    public void goToSmartphonesPage() {
        startPage.linkSmartsAndGadgets().focusOnLink();
        startPage.linkSmarts().click();
        logger.info("Страница [Стартовая страница DNS]: Выполнен переход на страницу \"Смартфоны\"");
    }

    @Когда("Выполнен переход на страницу \"Ноутбуки\"")
    public void goToLaptopsPage() {
        startPage.linkPCLaptopsPeripherals().focusOnLink();
        startPage.linkLaptops().click();
        logger.info("Страница [Стартовая страница DNS]: Выполнен переход на страницу \"Ноутбуки\"");
    }

    @Когда("Выполнен переход на страницу \"Бытовая техника\"")
    public void goToAppliancesPage() {
        // Нажатие на ссылку "Бытовая техника"
        startPage.linkAppliances().click();
        logger.info("Страница [Стартовая страница DNS]: Выполнен переход на страницу \"Бытовая техника\"");
    }

    @Когда("Наведен курсор на \"Бытовая техника\"")
    public void focusToAppliances() {
        startPage.linkAppliances().focusOnLink();
        logger.info("Страница [Стартовая страница DNS]: Наведен курсор на \"Бытовая техника\"");
    }

    @Когда("Наведен курсор на \"Приготовление напитков\"")
    public void focusToLinkCookingDrinks() {
        startPage.linkCookingDrinks().focusOnLink();
        logger.info("Страница [Стартовая страница DNS]: Наведен курсор на \"Приготовление напитков\"");
    }

    @Когда("Наведен курсор на \"Плиты и печи\"")
    public void focusToLinkStoveAndOvens() {
        startPage.linkStoveAndOvens().focusOnLink();
        logger.info("Страница [Стартовая страница DNS]: Наведен курсор на \"Плиты и печи\"");
    }

    @Когда("Выполнен переход на страницу \"Бытовая техника. Плиты и печи\"")
    public void goToStoveAndOvensPage() {
        startPage.linkAppliances().focusOnLink();
        startPage.linkStoveAndOvens().click();
        logger.info("Страница [Стартовая страница DNS]: Выполнен переход на страницу \"Плиты и печи\"");
    }

    @Тогда("Проверка: Выпадающее меню \"Бытовая техника\" содержит текст {string}")
    public void assertFirstLvlCategories(String text) {
        String appliancesCategoriesText="";
        for (WebElement element : startPage.listAppliancesFirsLvl().getListWebElements()) {
            appliancesCategoriesText+=element.getText();
        }
        Assertions.assertEquals(appliancesCategoriesText, text,
                "Страница [Стартовая страница DNS]: Ошибка! Выпадающее меню \"Бытовая техника\" не содержит текст \"" + text + "\"!");
        logger.info("Страница [Стартовая страница DNS]: Выпадающее меню \"Бытовая техника\" содержит текст \"" + text + "\"");
    }

    @Тогда("Проверка: На странице \"Стартовая страница DNS\" количество категорий \"Приготовление напитков\" больше \"{int}\"")
    public void assertCookingDrinksCount(int count) {
        Assertions.assertTrue(startPage.listCookingDrinks().getListWebElements().size() > count,
                "Страница [Стартовая страница DNS]: Ошибка! Количество категорий \"Приготовление напитков\" не больше \"" + count + "\"!");
        logger.info("Страница [Стартовая страница DNS]: Количество категорий \"Приготовление напитков\" больше \"" + count + "\"");
    }
}