/*
 * package pages;
 * 
 * import java.time.Duration;
 * 
 * import org.openqa.selenium.By; import org.openqa.selenium.WebDriver; import
 * org.openqa.selenium.support.ui.ExpectedConditions; import
 * org.openqa.selenium.support.ui.WebDriverWait;
 * 
 * public class ConfirmationPage {
 * 
 * private final WebDriver driver; private WebDriverWait wait;
 * 
 * private static final By STATUS_TEXT =
 * By.xpath("//td[contains(text(),'PendingCapture')]"); private static final By
 * PRICE_TEXT = By.xpath("//td[contains(text(),'USD')]");
 * 
 * public ConfirmationPage(WebDriver driver) { this.driver = driver; this.wait =
 * new WebDriverWait(driver, Duration.ofSeconds(10)); }
 * 
 * public String getStatus() { return
 * wait.until(ExpectedConditions.visibilityOfElementLocated(STATUS_TEXT)).
 * getText(); }
 * 
 * public double getPrice() { String priceString =
 * wait.until(ExpectedConditions.visibilityOfElementLocated(PRICE_TEXT)).getText
 * (); return Double.parseDouble(priceString.replaceAll("[^0-9.]", "")); } }
 */