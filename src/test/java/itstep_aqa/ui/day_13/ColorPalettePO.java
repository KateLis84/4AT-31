package itstep_aqa.ui.day_13;

import com.automation.remarks.testng.UniversalVideoListener;
import com.automation.remarks.video.annotations.Video;
import day_12.BaseUITest;
import day_12.BrowserFactory;
import day_12.ColorPaletteFactoryBO;
import day_13.CustomSuiteListener;
import day_13.CustomTestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;


@Listeners({
        CustomTestListener.class,
        CustomSuiteListener.class,
        UniversalVideoListener.class
})
public class ColorPalettePO extends BaseUITest {
    private ThreadLocal<WebDriver> driver = new InheritableThreadLocal<>();

    @Test
    @Video
    void ColorPaletteTest(){

        driver.set(new ChromeDriver());

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
        ColorPaletteFactoryBO.putLogin("userLogin");


    }

        @AfterTest
        void CloseDriver(){
            driver.get().close();
            driver.get().quit();
        }
}
