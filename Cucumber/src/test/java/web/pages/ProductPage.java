package web.pages;

import web.elements.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage{

    @FindBy(xpath = "//span[@class='products-count']")
    private WebElement labelProductsCount;

    @FindBy(xpath = "//span[contains(text(), \"Сортировка:\")]/following::a")
    private WebElement accordeonSort;

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public Label labelProductsCount() {
        return new Label(labelProductsCount);
    }

    public Accordeon accordeonSort() {
        return new Accordeon(accordeonSort);
    }

}
