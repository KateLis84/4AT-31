package day_12.po;

import day_12.decorator.MyFieldDecorator;
import day_12.decorator.MyInputWE;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GenerateFactoryPO {

    @FindBy(xpath = "//*[@id=\"authentication-panel\"]/p")
    private static WebElement textLabel;

    @FindBy(xpath="//*[@id=\"login-username\"]")
        private MyInputWE loginInput;

    @FindBy(xpath = "//*[@id=\"login-password\"]")
    private MyInputWE passwordInput;

    @FindBy(xpath = "//*[@id=\"signup-form\"]/input")
    private WebElement signUpButton;


    private static WebDriver driver;

    public GenerateFactoryPO(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(new MyFieldDecorator(driver), this);
    }

    public static boolean isOpen() {
        return textLabel.isDisplayed();
    }

    public GenerateFactoryPO insertLogin(String userLogin, String password) {
        loginInput.input(userLogin);
        passwordInput.input(password);
        return this;
    }

    public GenerateFactoryPO clickGenerate() {
        signUpButton.click();
        return this;
    }
}
