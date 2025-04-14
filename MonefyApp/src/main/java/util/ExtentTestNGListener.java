package util;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.testng.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentTestNGListener implements ITestListener {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public static ExtentTest getTest() {
        return test.get();
    }

    @Override
    public void onStart(ITestContext context) {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String reportPath = "test-output/ExtentReport_" + timeStamp + ".html";

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setReportName("Monefy Automation Report");
        sparkReporter.config().setDocumentTitle("Monefy Test Results");
        sparkReporter.config().setTimeStampFormat("yyyy-MM-dd HH:mm:ss");

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("Platform", "Android");
        extent.setSystemInfo("Tester", "Nishit");
        extent.setSystemInfo("Environment", "QA");
    }

    @Override
    public void onTestStart(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        String description = result.getMethod().getDescription();

        ExtentTest extentTest = extent.createTest(methodName, description != null ? description : "No Description");
        extentTest.assignAuthor("Nishit");
        extentTest.assignCategory("Smoke");
        extentTest.assignDevice("Android Emulator");

        // Add test parameters (if any)
        Object[] parameters = result.getParameters();
        if (parameters.length > 0) {
            StringBuilder paramStr = new StringBuilder("Parameters: ");
            for (Object param : parameters) {
                paramStr.append(param).append(" | ");
            }
            extentTest.info(paramStr.toString());
        }

        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        getTest().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        getTest().fail(result.getThrowable());

        // Optionally attach a screenshot if available
        try {
            String screenshotPath = captureScreenshot(result.getMethod().getMethodName());
            getTest().addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            getTest().warning("Screenshot not attached: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        getTest().skip("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

    // TODO: Plug this into your Appium setup
    private String captureScreenshot(String testName) throws IOException {
        // Replace with your actual Appium driver screenshot logic
        // Example:
        // File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // String path = "screenshots/" + testName + ".png";
        // File dest = new File(path);
        // FileUtils.copyFile(srcFile, dest);
        // return path;

        return "screenshots/" + testName + ".png"; // placeholder
    }
}
