package day_11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ColorPaletteBO {
    public static WebDriver driver;
    GeneratePO generatePO;
    HomePO homePO = new HomePO();
    public void goToHome() {
        homePO.goToHome();
    }

    public void Generateclick() {
        generatePO = homePO.clickGenerate();
    }

    public void verify() {
        Assert.assertTrue(GeneratePO.isOpen());
    }
}
