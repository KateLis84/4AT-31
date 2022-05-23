package day_12.decorator;

import org.openqa.selenium.WebElement;

public class MyButtonWE extends Element{

    public MyButtonWE(WebElement webElement) {
        super(webElement);
        this.webElement = webElement;
    }

    public void myClick(){
        System.out.println("click");
        waitForMe();
        webElement.click();
    }
}
