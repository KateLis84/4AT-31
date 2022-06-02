package FrameworkDir.PO;

import day_12.decorator.MyFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookPO {

    private static WebDriver driver;
    public BookPO(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new MyFieldDecorator(driver), this);
    }
    @FindBy(xpath = "//*[@id=\"component-storydetails-story-details-landing-%2fstory%2f70206397\"]/div/div[1]/div[2]/div[3]/button")
    private static WebElement bookOptions;

    @FindBy(xpath = "//*[@id=\"react-popover\"]/div/div[1]/ul/li[1]/button/span[2]")
    private static WebElement addToLibrary;

    @FindBy(xpath = "//*[@id=\"react-popover\"]/div/div[1]/div/button")
    private static WebElement saveChanges;

    public void bookOptions(){
        bookOptions.click();
    }

    public void AddBookToLibrary(){
        addToLibrary.click();
    }

    public void SaveChanges(){
        saveChanges.click();
    }

}
