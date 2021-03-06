package day_11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ColorPaletteBO {
    public static WebDriver driver;
    private HomePO homePO;
    public static void main(String[] args) {
    }GeneratePO generatePO;

    public ColorPaletteBO(WebDriver chromeDriver){
        this.driver = chromeDriver;
    }

    public void goToHome() {
        homePO = new HomePO(driver);
        homePO.goToHome();
    }

    public void Generateclick() {
        generatePO = homePO.clickGenerate();
    }

    public void verify() {
        Assert.assertTrue(GeneratePO.isOpen());
    }

    public void putLogin(String userLogin) {
        generatePO
                .insertLogin(userLogin)
                .clickGenerate();
    }
}
