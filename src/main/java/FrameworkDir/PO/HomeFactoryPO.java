package FrameworkDir.PO;
import FrameworkDir.decorator.MyButtonWE;
import FrameworkDir.decorator.MyFieldDecorator;
import FrameworkDir.PO.LoginPO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeFactoryPO {

    @FindBy(xpath = "//*[@id=\"authentication-panel\"]/div/button")
    private MyButtonWE signUpButton;


    private WebDriver driver;
    public HomeFactoryPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new MyFieldDecorator(driver), this);
    }

    public void goToHome() {
        driver.get("https://www.wattpad.com/login");
    }

    public LoginPO clickLogin() {
        signUpButton.myClick();
        return new LoginPO(driver);
    }
    }

