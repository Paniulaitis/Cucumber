package web.elements;

import web.helpers.*;
import org.openqa.selenium.WebElement;

public class Label extends BaseElement {
    // Конструктор
    public Label(WebElement webElement) {
        super(webElement);
    }

    // Наведение курсора мыши
    public void focusOnLabel() {
        ActionHelper.moveToElement(webElement);
    }

    // Получение текста
    public String getText() {
        WaitHelper.visibilityOfElement(webElement);
        return webElement.getText();
    }
}
