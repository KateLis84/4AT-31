package FrameworkDir.PO;

import day_12.decorator.MyFieldDecorator;
import day_12.decorator.MyInputWE;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import FrameworkDir.PO.LibraryPO;

public class LoginPO {

    @FindBy(xpath = "//*[@id=\"authentication-panel\"]/p")
    private static WebElement textLabel;

    @FindBy(xpath="//*[@id=\"login-username\"]")
        private MyInputWE loginInput;

    @FindBy(xpath = "//*[@id=\"login-password\"]")
    private MyInputWE passwordInput;

    @FindBy(xpath = "//*[@id=\"signup-form\"]/input")
    private WebElement signUpButton;

    @FindBy(xpath = "//*[@id=\"header-item-search\"]/div/form/button/span")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"search-query\"]")
    private MyInputWE searchField;

    @FindBy(xpath = "//*[@id=\"profile-dropdown\"]/button")
    private WebElement myProfile;

    @FindBy(xpath = "//*[@id=\"profile-dropdown\"]/div[2]/ul/li[5]/a")
    private WebElement libraryButton;



    private static WebDriver driver;

    public void MyProfileClick(){
        myProfile.click();
    }

    public LibraryPO LibraryClick(){
        libraryButton.click();
        return new LibraryPO(driver);
    }
    public LoginPO(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new MyFieldDecorator(driver), this);
    }

    public static boolean isOpen() {
        return textLabel.isDisplayed();
    }

    public LoginPO insertLogin(String userLogin, String password) {
        loginInput.input(userLogin);
        passwordInput.input(password);
        //signUpButton.click();
        return this;
    }

    public LoginPO clickEnter() {
        signUpButton.click();
        return this;
    }

    public SearchPO Search(){
        searchButton.click();
        return new SearchPO(driver);
    }

    public void inputSearch(String searchWord){
        searchField.input(searchWord);
    }
}
