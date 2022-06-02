package FrameworkDir.PO;

import day_12.decorator.MyFieldDecorator;
import FrameworkDir.PO.BookPO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPO {

    private static WebDriver driver;
    public SearchPO(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new MyFieldDecorator(driver), this);
    }

    @FindBy(xpath = "//*[@id=\"component-browsecategories-browse-categories-%2fsearch\"]/div/a[7]")
    private WebElement fanfictionButton;

    @FindBy(xpath = "//*[@id=\"browse-container\"]/div/header/h1")
    private WebElement FanfictionLabel;

    @FindBy(xpath = "//*[@id=\"component-searchnoresults-search-no-results-stories-%2fsearch%2fqfoj%255depgj\"]/div/div/h4")
    private WebElement notFoundLabel;

    @FindBy(xpath = "//*[@id=\"component-storycardcontainer-story-card-container-%2fsearch%2fwarrior%2520cats\"]/div/div[1]/ul/li[1]/a/div[2]/div[2]/div[1]")
    private static WebElement chosenBook;

    public void ClickGanre(){
        fanfictionButton.click();
    }

    public boolean LabelCheck(){
        return FanfictionLabel.isDisplayed();
    }

    public boolean SearchResultCheck(){
        return notFoundLabel.isDisplayed();
    }

    public static BookPO clickBook(){
        chosenBook.click();
        return new BookPO(driver);
    }
}
