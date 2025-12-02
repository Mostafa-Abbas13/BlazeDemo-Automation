# BlazeDemo Automation Project

## Project Overview

This project is a QA Automation framework for BlazeDemo (https://blazedemo.com/) implementing an End-to-End flight purchase test.
The framework uses Java + Selenium WebDriver + TestNG + ExtentReports and follows the Page Object Model (POM) design pattern.

### Goal:
Automatically validate the flight purchase workflow including:
- Selecting departure and destination cities.
- Choosing a flight (specific or random).
- Filling the purchase form with randomly generated dummy data.
- Verifying confirmation status and price.

## Project Structure

```text
src/main/java/
    base/
        BaseTest.java           → Base class with setup, teardown, and ExtentReports
    pages/
        HomePage.java           → Page Object for the home page
        FlightsPage.java        → Page Object for flights selection page
        PurchasePage.java       → Page Object for purchase form page
        ConfirmationPage.java   → Page Object for confirmation page
    utils/
        RandomData.java         → Utility class to generate random data

src/test/java/
    tests/
        PurchaseTest.java       → End-to-End TestNG test for flight purchase


Setup Instructions
Clone Repository
git clone https://github.com/your-username/BlazeDemo-Automation.git
cd BlazeDemo-Automation

Install Java & Maven

Java 11 or higher is recommended.

Maven should be installed and added to PATH.

Install ChromeDriver

Ensure ChromeDriver matches your Chrome browser version.

Download from: https://sites.google.com/chromium.org/driver/

Add ChromeDriver to system PATH.

Install Dependencies

Run the following command to install the necessary dependencies:
mvn clean install

This will download Selenium, TestNG, and ExtentReports dependencies.

Running the Tests
Run all tests:
mvn test
Run a specific TestNG test suite:
mvn test -DsuiteXmlFile=testng.xml

Test Scenarios

The purchaseEndToEnd test runs multiple scenarios using TestNG DataProvider:

Scenario	Departure	Destination	FlightSeq	Description
1	Boston	Berlin	2	Predefined cities and flight number
2	Random	Random	Random	Fully random cities and flight
3	Boston	Boston	1	Invalid: same departure & destination (throws exception)
4	Paris	Berlin	0	Invalid flightSeq (throws exception)
5	Rome	Paris	Random	Mixed input scenario
Reporting

ExtentReports generates an HTML report for each test run.
