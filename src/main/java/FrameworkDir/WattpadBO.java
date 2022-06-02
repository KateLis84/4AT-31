package FrameworkDir;

import FrameworkDir.PO.BookPO;
import FrameworkDir.PO.HomeFactoryPO;
import FrameworkDir.PO.LoginPO;
import FrameworkDir.PO.SearchPO;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import FrameworkDir.PO.LibraryPO;

public class WattpadBO {
    public static WebDriver driver;
    private static HomeFactoryPO homePO;
    private static SearchPO searchPO;
    private static BookPO bookPO;

    private static LibraryPO libraryPO;
    public static void main(String[] args) {
    }

    static LoginPO loginPO;

    public WattpadBO(WebDriver chromeDriver){
        this.driver = chromeDriver;
    }

    @Step
    public static void goToHome() {
        homePO = new HomeFactoryPO(driver);
        homePO.goToHome();
    }

    @Step
    public void loginClick() {
        loginPO = homePO.clickLogin();
    }

    @Step
    public void verify() {
        Assert.assertTrue(LoginPO.isOpen());
    }

    @Step
    public void putLogin(String userLogin, String password) {
        loginPO
                .insertLogin(userLogin, password)
                .clickEnter();
    }
    @Step
    public void search() {
        searchPO = loginPO.Search();
    }

    @Step
    public void ClickGanre(){
        searchPO.ClickGanre();
    }

    @Step
    public void verifyGanre(){
        Assert.assertTrue(searchPO.LabelCheck());
    }

    @Step
    public void inputSearch(String searchWord){
        loginPO.inputSearch(searchWord);
    }

    @Step
    public void verifySearch(){
        Assert.assertTrue(searchPO.SearchResultCheck());
    }

    @Step
    public void chooseBook(){
        bookPO = SearchPO.clickBook();
    }

    @Step
    public void AddBookToLibrary(){
        bookPO.bookOptions();
        bookPO.AddBookToLibrary();
        bookPO.SaveChanges();
    }

    @Step
    public void CheckTheBookInLibrary(){
        loginPO.MyProfileClick();
        libraryPO = loginPO.LibraryClick();
        Assert.assertTrue(libraryPO.IsBook());
    }

    @Step
    public void DeleteBook(){
        libraryPO.BookElementHover();
        libraryPO.DeleteClick();
        Assert.assertTrue(libraryPO.IsBook());
    }

}
