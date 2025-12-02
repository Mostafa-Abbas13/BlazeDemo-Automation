package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Random;

public class FlightsPage {
    WebDriver driver;

    public FlightsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void chooseFlight(int flightSeq) {
        List<WebElement> buttons = driver.findElements(By.cssSelector("table tr td input[type='submit']"));
        if (flightSeq <= 0 || flightSeq > buttons.size()) {
            flightSeq = new Random().nextInt(buttons.size()) + 1;
        }
        buttons.get(flightSeq - 1).click();
    }
}
