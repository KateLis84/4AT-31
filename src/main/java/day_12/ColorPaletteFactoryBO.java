package day_12;

import day_11.GeneratePO;
import day_11.HomePO;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ColorPaletteFactoryBO {
    public static WebDriver driver;
    private static HomeFactoryPO homePO;
    public static void main(String[] args) {
    }

    static GenerateFactoryPO generatePO;

    public ColorPaletteFactoryBO(WebDriver chromeDriver){
        this.driver = chromeDriver;
    }

    public static void goToHome() {
        homePO = new HomeFactoryPO(driver);
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
