package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import models.Laptop;
import models.valueobjects.Company;
import models.valueobjects.Ram;
import org.junit.jupiter.api.Assertions;
import web.drivers.WebDriverFactory;
import web.helpers.JavaScriptHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import web.pages.LaptopsPage;

import java.util.List;
import java.util.Map;


public class LaptopsPageSteps {
    private static Logger logger = LogManager.getLogger(LaptopsPageSteps.class);

    private LaptopsPage laptopsPage;


    @Дано("Открыта страница \"Ноутбуки\"")
    public void openLaptopsPage() {
        laptopsPage = new LaptopsPage(WebDriverFactory.getCurrentDriver());
        logger.info("Страница [Ноутбуки]: Открыта страница \"Ноутбуки\"");
    }


    @Когда("Скрыт блок страницы")
    public void HidePageBlock() {
        // Скрыть блок страницы
        laptopsPage.blockHeader().hide();
        // Установка сортировки
        logger.info("Страница [Ноутбуки]: Скрыт блок страницы");
    }


    @Когда("Установлена сортировка {string}")
    public void orderBy(String type) {
        laptopsPage.accordeonSort().show();
        laptopsPage.radiobuttonSort(type).setSelected(true);
        logger.info("Страница [Ноутбуки]: Установлена сортировка \"" + type + "\"");
    }

    @Когда("В фильтре \"Производитель\" выбрано значение {string}")
    public void filterByCompany(String company) {
        // Прокрутка страницы вниз
        JavaScriptHelper.scrollBy(0, 600);
        // Установка фильтра "Производитель"
        laptopsPage.checkboxCompany(company).setChecked(true);
        logger.info("Страница [Ноутбуки]: В фильтре \"Производитель\" выбрано значение \"" + company + "\"");
    }

    @Когда("В фильтре \"Объем оперативной памяти\" выбрано значение \"{int} ГБ\"")
    public void filterByRAM(int ram) {
        JavaScriptHelper.scrollBy(0, 400);
        laptopsPage.accordeonRAM().show();
        JavaScriptHelper.scrollBy(0, 400);
        laptopsPage.checkboxRAM(ram + " ГБ").setChecked(true);
        logger.info("Страница [Ноутбуки]: В фильтре \"Объем оперативной памяти\" выбрано значение \"" + ram + " Гб\"");
    }

    @Когда("Применены фильтры")
    public void applyFilters() {
        JavaScriptHelper.scrollBy(0, 600);
        laptopsPage.buttonApply().click();
        logger.info("Страница [Ноутбуки]: Применены фильтры");
    }

    @Когда("Выполнен переход на страницу первого продукта в списке")
    public void goToFirstProduct() {
        // Прокрутка страницы вверх
        JavaScriptHelper.scrollBy(0, -2000);
        // Нажатие на ссылку первого продукта в списке
        laptopsPage.linkFirstProduct().openInNewWindow();
        logger.info("Страница [Ноутбуки]: Выполнен переход на страницу первого продукта в списке");
    }

    @И("Установлена сортировка и фильтры из таблицы")
    public void setFiltersAndSortFromTable(DataTable dataTable) {
        List<Map<String, String>> table = dataTable.asMaps(String.class, String.class);
        String sortBy = table.get(0).get("Сортировка");
        String filterByCompany = table.get(0).get("Производитель");
        String filterByRam = table.get(0).get("Объем оперативной памяти");

        Laptop laptop = new Laptop(
                new Ram(Integer.parseInt(filterByRam.split(" ")[0])),
                new Company(filterByCompany));

        laptopsPage.accordeonSort().show();
        laptopsPage.radiobuttonSort(sortBy).setSelected(true);
        logger.info("Страница [Ноутбуки]: Установлена сортировка \"" + sortBy + "\"");

        JavaScriptHelper.scrollBy(0,400);
        laptopsPage.checkboxCompany(laptop.getCompany().getCompany()).setChecked(true);
        logger.info("Страница [Ноутбуки]: В фильтре \"Производитель\" выбрано значение \"" + laptop.getCompany().getCompany() + "\"");

        JavaScriptHelper.scrollBy(0,400);
        laptopsPage.accordeonRAM().show();
        JavaScriptHelper.scrollBy(0,400);
        laptopsPage.checkboxRAM(laptop.getRam().getRam() + " ГБ").setChecked(true);
        logger.info("Страница [Ноутбуки]: В фильтре \"Объем оперативной памяти\" выбрано значение \"" + laptop.getRam().getRam() + " Гб\"");

        logger.info("Установлена сортировка и фильтры из таблицы");
    }


    // Проверка: Заголовок страницы "Ноутбуки" содержит текст "<Текст>"
    @Тогда("Проверка: Заголовок страницы \"Ноутбуки\" содержит текст {string}")
    public void assertPageTitle(String text) {
        Assertions.assertTrue(laptopsPage.getPageTitle().contains(text),
                "Страница [Ноутбуки]: Ошибка! Заголовок страницы \"Ноутбуки\" не содержит текст \"" + text + "\"!");
        logger.info("Страница [Ноутбуки]: Заголовок страницы \"Ноутбуки\" содержит текст \"" + text + "\"");
    }
}