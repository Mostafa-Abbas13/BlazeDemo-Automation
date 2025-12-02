package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.RandomData;
import java.time.Duration;

public class PurchasePage {
    WebDriver driver;
    WebDriverWait wait;

    By nameField = By.id("inputName");
    By addressField = By.id("address");
    By cityField = By.id("city");
    By stateField = By.id("state");
    By zipField = By.id("zipCode");
    By cardField = By.id("creditCardNumber");
    By monthField = By.id("creditCardMonth");
    By yearField = By.id("creditCardYear");
    By nameOnCardField = By.id("nameOnCard");
    By rememberMeCheckbox = By.id("rememberMe");
    By purchaseButton = By.cssSelector("input[type='submit']");

    By statusText = By.xpath("//td[contains(text(),'PendingCapture')]");
    By priceText = By.xpath("//td[contains(text(),'USD')]");

    public PurchasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void fillRandomDataAndPurchase() {
        driver.findElement(nameField).sendKeys(RandomData.randomName());
        driver.findElement(addressField).sendKeys(RandomData.randomAddress());
        driver.findElement(cityField).sendKeys(RandomData.randomCity());
        driver.findElement(stateField).sendKeys(RandomData.randomState());
        driver.findElement(zipField).sendKeys(RandomData.randomZip());
        driver.findElement(cardField).sendKeys(RandomData.randomCard());
        driver.findElement(monthField).clear();
        driver.findElement(monthField).sendKeys(RandomData.randomMonth());
        driver.findElement(yearField).clear();
        driver.findElement(yearField).sendKeys(RandomData.randomYear());
        driver.findElement(nameOnCardField).sendKeys(RandomData.randomName());

        if (RandomData.randomRememberMe()) {
            driver.findElement(rememberMeCheckbox).click();
        }

        driver.findElement(purchaseButton).click();
    }

    public String getStatus() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(statusText)).getText();
    }

    public double getPrice() {
        String priceTextValue = wait.until(ExpectedConditions.visibilityOfElementLocated(priceText)).getText();
        return Double.parseDouble(priceTextValue.replaceAll("[^0-9.]", ""));
    }
}
