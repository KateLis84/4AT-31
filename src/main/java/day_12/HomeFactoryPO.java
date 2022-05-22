package day_12;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeFactoryPO {

    @FindBy(xpath = "//*[@id=\"header_nav\"]/ul/li[4]/a")
    private WebElement generateButton;

//    @FindBy(xpath = "//*[@id=\"iubenda-cs-banner\"]/div/div/div/div[3]/div[2]/button")
//    private WebElement coockies;

    private WebDriver driver;
    public HomeFactoryPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToHome() {
        driver.get("https://coolors.co/");
    }

    public GenerateFactoryPO clickGenerate() {
        //if(coockies.isDisplayed()){coockies.click();}
        generateButton.click();
        return new GenerateFactoryPO(driver);
    }

}
