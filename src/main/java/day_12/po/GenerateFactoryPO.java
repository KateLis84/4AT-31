package day_12.po;

import day_12.decorator.MyFieldDecorator;
import day_12.decorator.MyInputWE;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GenerateFactoryPO {

    @FindBy(xpath = "//*[@id=\"modal\"]/div/div/div/form/div[1]/h3")
    private static WebElement textLabel;

    @FindBy(xpath="//*[@id=\"modal\"]/div/div/div/form/div[2]/div[2]/div[1]/input")
        private MyInputWE loginInput;

    @FindBy(xpath = "//*[@id=\"modal\"]/div/div/div/form/div[2]/div[2]/div[4]/button")
    private WebElement signUpButton;


    private static WebDriver driver;

    public GenerateFactoryPO(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(new MyFieldDecorator(driver), this);
    }

    public static boolean isOpen() {
        return textLabel.isDisplayed();
    }

    public GenerateFactoryPO insertLogin(String userLogin) {
        loginInput.input(userLogin);
        return this;
    }

    public GenerateFactoryPO clickGenerate() {
        signUpButton.click();
        return this;
    }
}
