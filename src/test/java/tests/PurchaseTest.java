package tests;
import tests.PurchaseTest;

import org.testng.annotations.*;
import org.testng.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.FlightsPage;
import pages.PurchasePage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PurchaseTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://blazedemo.com/");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) driver.quit();
    }

    public void purchaseEndToEnd(String deptCity, String desCity, Integer flightSeq) {
        if (deptCity == null) deptCity = utils.RandomData.randomCity();
        if (desCity == null) desCity = utils.RandomData.randomCity();
        if (flightSeq == null) flightSeq = 0;

        System.out.println("Selected cities: " + deptCity + " -> " + desCity);

        HomePage home = new HomePage(driver);
        home.selectCities(deptCity, desCity);
        home.clickFindFlights();

        FlightsPage flights = new FlightsPage(driver);
        flights.chooseFlight(flightSeq);

        PurchasePage purchase = new PurchasePage(driver);
        purchase.fillRandomDataAndPurchase();

        try {
            String status = purchase.getStatus();
            double price = purchase.getPrice();

            Assert.assertEquals(status, "PendingCapture", "Status validation failed!");
            Assert.assertTrue(price > 100, "Price validation failed! Price: " + price);

            System.out.println("Purchase complete. Status: " + status + ", Price: " + price);
        } catch (AssertionError e) {
            String screenshotPath = takeScreenshot(deptCity + "_" + desCity);
            System.out.println("Screenshot for failed test: " + screenshotPath);
            throw e;
        }
    }

    public String takeScreenshot(String name) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String path = "screenshots/" + name + "_" + timestamp + ".png";
            Files.createDirectories(Paths.get("screenshots"));
            Files.copy(src.toPath(), Paths.get(path));
            return path;
        } catch (IOException ex) {
            ex.printStackTrace();
            return "Failed to take screenshot!";
        }
    }

    @Test
    public void testCase1() { purchaseEndToEnd("Boston","Berlin",2); }

    @Test
    public void testCase2() { purchaseEndToEnd(null,null,null); }

    @Test
    public void testCase3() { purchaseEndToEnd("Boston","Boston",1); }

    @Test
    public void testCase4() { purchaseEndToEnd("Paris","Berlin",0); }

    @Test
    public void testCase5() { purchaseEndToEnd("Rome","Paris",1); }
}
