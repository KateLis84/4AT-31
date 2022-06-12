package FrameworkDir.decorator;

import org.openqa.selenium.WebElement;

public class MyInputWE extends Element {

    public MyInputWE(WebElement webElement) {
        super(webElement);
        this.webElement = webElement;
    }

    public void input(String inputText){
        System.out.println("My input '"+inputText+"' worked");
        webElement.sendKeys(inputText);
    }

    public void inputNotNull(String inputText){
        if(inputText == ""){
            System.out.println("You inputed not null");
        }
        else{
            System.out.println("My input '"+inputText+"' worked");
        }
        webElement.sendKeys(inputText);
    }

    public void inputPassword(String inputText){
        if(inputText.length() < 4){
            System.out.println("Sorry password is to short");
        }
        else{
            webElement.sendKeys(inputText);
        }
    }

}
