package day_11;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static day_11.ColorPaletteBO.driver;

public class HomePO {

    private WebDriver driver;
    public HomePO(WebDriver driver) {
        this.driver = driver;
    }

    public void goToHome() {
        driver.get("https://coolors.co/");
    }

    public GeneratePO clickGenerate() {
        driver.findElement(By.xpath("//*[@id=\"homepage_hero_text_btns\"]/a[1]")).click();
        return new GeneratePO(driver);
    }

}
