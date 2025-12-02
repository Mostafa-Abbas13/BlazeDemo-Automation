package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener implements ITestListener {

    
    private WebDriver getDriver(ITestResult result) {
        try {
            Object testClass = result.getInstance();
            return (WebDriver) testClass.getClass().getField("driver").get(testClass);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = getDriver(result);
        if (driver != null) {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String testName = result.getName();
            try {
                Files.createDirectories(Paths.get("screenshots"));
                Files.copy(srcFile.toPath(), Paths.get("screenshots/" + testName + "_" + timestamp + ".png"));
                System.out.println("Screenshot saved: " + testName + "_" + timestamp + ".png");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onTestStart(ITestResult result) {}

    @Override
    public void onTestSuccess(ITestResult result) {}

    @Override
    public void onTestSkipped(ITestResult result) {}

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}

    @Override
    public void onStart(ITestContext context) {}

    @Override
    public void onFinish(ITestContext context) {}
}
