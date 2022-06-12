package itstep_aqa.ui.day_14;

import day_12.BaseUITest;
import day_12.BrowserFactory;
import day_12.ColorPaletteFactoryBO;
import day_12.day_13.CustomSuiteListener;
import day_12.day_13.CustomTestListener;
import day_14.AllureTestListener;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.time.Duration;
import java.time.temporal.ChronoUnit;


@Listeners({
        CustomTestListener.class,
        CustomSuiteListener.class,
        AllureTestListener.class
//        UniversalVideoListener.class

})
public class ColorPalettePO extends BaseUITest {
    private ThreadLocal<WebDriver> driver = new InheritableThreadLocal<>();
    @Test
    void ColorPaletteTest(){
        WebDriver driver = BrowserFactory.getChromedriver();
        driver.manage().timeouts().implicitlyWait(Duration.of(10, ChronoUnit.SECONDS));
        ColorPaletteFactoryBO ColorPaletteFactoryBO = new ColorPaletteFactoryBO(
                driver
        );

        // Step 1 "Go to website"
        ColorPaletteFactoryBO.goToHome();


        // Step 2 "Click"
        ColorPaletteFactoryBO.Generateclick();


        // Step 3 "verify"
        ColorPaletteFactoryBO.verify();

        // Step 4 put Login
        ColorPaletteFactoryBO.putLogin("userLogin", "12");


    }

        @AfterTest
        void CloseDriver(){
            driver.get().close();
            driver.get().quit();
        }
}
