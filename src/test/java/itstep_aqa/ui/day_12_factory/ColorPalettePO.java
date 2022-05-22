package itstep_aqa.ui.day_12_factory;

import day_11.ColorPaletteBO;
import day_12.BaseUITest;
import day_12.ColorPaletteFactoryBO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ColorPalettePO extends BaseUITest {

    private ThreadLocal<WebDriver> driver = new InheritableThreadLocal<>();


    @Test
    void ColorPaletteTest(){

        driver.set(new ChromeDriver());

        ColorPaletteBO ColorPaletteBO = new ColorPaletteBO(driver.get());

        // Step 1 "Go to website"
        ColorPaletteBO.goToHome();

        // Step 2 "Click"
        ColorPaletteBO.Generateclick();


        // Step 3 "verify"
        ColorPaletteBO.verify();

        // Step 4 put Login
        ColorPaletteBO.putLogin("userLogin");


    }

    @AfterTest
    void CloseDriver(){
        driver.get().quit();
        //driver.quit();
    }
}
