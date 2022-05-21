package itstep_aqa.ui.colorpalettePO;

import day_11.ColorPaletteBO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ColorPalettePO {


    @BeforeTest
    void initDriver(){
        String driverPath = "driver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        day_11.ColorPaletteBO.driver = new ChromeDriver();

    }

    @Test
    void ColorPaletteTest(){

        ColorPaletteBO ColorPaletteBO = new ColorPaletteBO();

        // Step 1 "Go to website"
        ColorPaletteBO.goToHome();

        // Step 2 "Click"
        ColorPaletteBO.Generateclick();


        // Step 3 "verify"
        ColorPaletteBO.verify();

    }

    @AfterTest
    void CloseDriver(){
        day_11.ColorPaletteBO.driver.close();
        day_11.ColorPaletteBO.driver.quit();
    }
}
