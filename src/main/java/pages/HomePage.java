package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
    WebDriver driver;
    By departureDropdown = By.name("fromPort");
    By destinationDropdown = By.name("toPort");
    By findFlightsBtn = By.cssSelector("input[type='submit']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectCities(String deptCity, String desCity) {
        if (deptCity.equals(desCity)) {
            throw new IllegalArgumentException("Departure and Destination can't be the same!");
        }
        Select from = new Select(driver.findElement(departureDropdown));
        Select to = new Select(driver.findElement(destinationDropdown));
        from.selectByVisibleText(deptCity);
        to.selectByVisibleText(desCity);
    }

    public void clickFindFlights() {
        driver.findElement(findFlightsBtn).click();
    }
}
