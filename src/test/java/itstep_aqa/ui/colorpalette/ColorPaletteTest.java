package itstep_aqa.ui.colorpalette;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ColorPaletteTest {
    WebDriver driver;

    @BeforeTest
    void initDriver(){
        String driverPath = "driver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();

    }

    @Test
    void ColorPaletteTest(){

        // Step 1 "Go to website"
        driver.get("https://coolors.co");

        // Step 2 "Click"
        driver.findElement(By.xpath("//*[@id=\"homepage_hero_text_btns\"]/a[1]")).click();


        // Step 3 "verify"
        driver.findElement(By.xpath("//*[@id=\"generator_spacebar-suggestion\"]")).isDisplayed();

    }

    @AfterTest
    void CloseDriver(){
        driver.close();
        driver.quit();
    }
}
