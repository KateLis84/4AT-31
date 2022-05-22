package day_11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static day_11.ColorPaletteBO.driver;

public class GeneratePO {

    private static WebDriver driver;

    public GeneratePO(WebDriver driver){
        this.driver = driver;
    }

    public static boolean isOpen() {
        return driver
                .findElement(By.xpath("//*[@id=\"generator_spacebar-suggestion\"]"))
                .isDisplayed();
    }

    public GeneratePO insertLogin(String userLogin) {
        //TODO
        return this;
    }

    public void clickGenerate() {
        //TODO
    }
}
