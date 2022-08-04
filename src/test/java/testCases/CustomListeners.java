package testCases;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import pages.ElementsPage;

import java.io.IOException;

public class CustomListeners implements ITestListener {
    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test Started");
        ITestListener.super.onStart(context);
    }
    @Override
    public void onTestFailure(ITestResult result) {
        try {System.out.println("Test Failed find the screenshot");
        ElementsPage ele=new ElementsPage();
            ele.getScreenShot();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ITestListener.super.onTestFailure(result);
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test Ended");
        ITestListener.super.onFinish(context);
    }
}
