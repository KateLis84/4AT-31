package day_14;

import day_12.BrowserFactory;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;
import java.io.File;

public class AllureTestListener implements ITestListener {

    @Attachment(value = "Page Screen", type="image/png")
    byte[] getScreenshot(){
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) BrowserFactory.getChromedriver()).getScreenshotAs(OutputType.BYTES)));
        return ((TakesScreenshot) BrowserFactory.getChromedriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        getScreenshot();
        getDom();
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
