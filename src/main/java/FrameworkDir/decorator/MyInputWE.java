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
}
