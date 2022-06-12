package day_12;

import day_12.po.GenerateFactoryPO;
import day_12.po.HomeFactoryPO;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.ByteArrayInputStream;

public class ColorPaletteFactoryBO {
    public static WebDriver driver;
    private static HomeFactoryPO homePO;
    public static void main(String[] args) {
    }

    static GenerateFactoryPO generatePO;

    public ColorPaletteFactoryBO(WebDriver chromeDriver){
        this.driver = chromeDriver;
    }

    @Step
    public static void goToHome() {
        homePO = new HomeFactoryPO(driver);
        homePO.goToHome();
    }

    @Step
    public void Generateclick() {
        generatePO = homePO.clickGenerate();
    }

    @Step
    public void verify() {
        Assert.assertTrue(GenerateFactoryPO.isOpen());
    }

    @Step
    public void putLogin(String userLogin, String password) {
        generatePO
                .insertLogin(userLogin, password)
                .clickGenerate();
    }

}
