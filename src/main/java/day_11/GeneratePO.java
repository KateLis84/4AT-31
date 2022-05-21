package day_11;

import org.openqa.selenium.By;
import org.testng.Assert;

import static day_11.ColorPaletteBO.driver;

public class GeneratePO {
    public static boolean isOpen() {
        return driver.findElement(By.xpath("//*[@id=\"generator_spacebar-suggestion\"]")).isDisplayed();
    }
}
