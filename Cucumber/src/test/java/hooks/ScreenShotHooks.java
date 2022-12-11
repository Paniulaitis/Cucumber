package hooks;

import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import web.drivers.WebDriverFactory;
import web.helpers.JavaScriptHelper;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ScreenShotHooks {
    // Логгер
    private Logger logger = LogManager.getLogger(ScreenShotHooks.class);

    // Действия совершаемые перед каждым шагом
    @BeforeStep
    public void takeScreenShotBeforeStep(Scenario scenario) {
        // Сделать скриншот видимой области веб страницы
        try {
            Screenshot screenshot = new AShot().takeScreenshot(
                    WebDriverFactory.getCurrentDriver());
            String name = scenario.getName() + "-" + Timestamp.from(Instant.now()).getTime() + ".png";
            ImageIO.write(screenshot.getImage(), "png",
                    new File("temp\\" + name));
            logger.info("Скриншот сохранен в файле [temp\\" + name + "]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Действия совершаемые после каждого шага
    @AfterStep
    public void takeScreenShotAfterStep(Scenario scenario) {
        Long positionY = 0L;
        try {
            positionY = JavaScriptHelper.getPositionY();
        } catch (NullPointerException e) {}
        // Сделать скриншот веб страницы
        try {
            Screenshot screenshot = new AShot()
                    .shootingStrategy(ShootingStrategies.viewportPasting(100))
                    .takeScreenshot(
                            WebDriverFactory.getCurrentDriver());
            String name = scenario.getName() + "-" + Timestamp.from(Instant.now()).getTime() + ".png";
            ImageIO.write(screenshot.getImage(), "png",
                    new File("temp\\" + name));
            logger.info("        Скриншот сохранен в файле [temp\\" + name + "]");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            JavaScriptHelper.scroll(0L, positionY);
        } catch (NullPointerException e) {}
    }
}