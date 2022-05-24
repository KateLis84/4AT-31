package day_12.po;
import day_12.decorator.MyButtonWE;
import day_12.decorator.MyFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public GenerateFactoryPO clickGenerate() {
        signUpButton.myClick();
        return new GenerateFactoryPO(driver);
    }

}
