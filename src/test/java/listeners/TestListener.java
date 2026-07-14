package listeners;

import factory.DriverFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import reports.ExtentReportManager;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    private static ExtentReports extent;
    private static ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.pass("Test Passed");

        System.out.println("Test Passed : " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        String path = ScreenshotUtil.takeScreenshot(
                DriverFactory.getDriver(),
                result.getName()
        );

        test.fail(result.getThrowable());
        test.addScreenCaptureFromBase64String(path);
        System.out.println("Test Failed : " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped : " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Execution Started");
        extent = ExtentReportManager.getExtentReporter();
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Execution Finished");
        extent.flush();
    }

}
