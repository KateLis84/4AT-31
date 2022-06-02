package FrameworkDir.PO;

import day_12.decorator.MyFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LibraryPO {
    private static WebDriver driver;
    public LibraryPO(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new MyFieldDecorator(driver), this);
    }
    @FindBy(xpath = "//*[@id=\"tab-content\"]/div/div[1]/div/div[1]/div/img")
    private WebElement bookElement;

    @FindBy(xpath = "//*[@id=\"tab-content\"]/div[2]/div[1]/div/div[1]/div/div/div[2]/button/span")
    private WebElement deleteButton;

    public boolean IsBook(){
        return bookElement.isDisplayed();
    }

    public void BookElementHover(){
        Actions action = new Actions(driver);
        action.moveToElement(bookElement).perform();
    }

    public void DeleteClick(){
        deleteButton.click();
        driver.switchTo().alert().accept();
    }
}
