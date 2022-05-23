package day_14;

import day_12.BrowserFactory;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureTestListener implements ITestListener {


    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        getScreenshot();
        getDom();
    }

    @Attachment(value = "Page Screen", type="image/png")
    byte[] getScreenshot(){
        return ((TakesScreenshot) BrowserFactory.getChromedriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type="text/plain")
    String getDom(){
        return BrowserFactory.getChromedriver().getPageSource();
    }


    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        getScreenshot();
    }
}
