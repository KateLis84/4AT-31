package day_12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GenerateFactoryPO {

    @FindBy(xpath = "//*[@id=\"generator_spacebar-suggestion\"]")
    private WebElement textLabel;

    private static WebDriver driver;

    public GenerateFactoryPO(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isOpen() {
        return textLabel.isDisplayed();
    }

    public GenerateFactoryPO insertLogin(String userLogin) {
        //TODO
        return this;
    }

    public void clickGenerate() {
        //TODO
    }
}
