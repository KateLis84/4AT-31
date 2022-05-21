package day_11;
import org.openqa.selenium.By;
import org.testng.Assert;

import static day_11.ColorPaletteBO.driver;

public class HomePO {

    public void goToHome() {
        driver.get("https://coolors.co/");
    }

    public GeneratePO clickGenerate() {
        driver.findElement(By.xpath("//*[@id=\"homepage_hero_text_btns\"]/a[1]")).click();
        return new GeneratePO();
    }

}
