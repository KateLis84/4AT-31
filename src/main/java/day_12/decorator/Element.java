package day_12.decorator;

import day_12.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.function.Function;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Element {
    WebElement webElement;

    public Element(WebElement webElement){
        this.webElement = webElement;
    }

    void waitForMe(){
        long start=new Date().getTime();
        Wait wait = new FluentWait(BrowserFactory.getChromedriver())
                .withTimeout(Duration.of(10, ChronoUnit.SECONDS))
                .pollingEvery(Duration.of(1, ChronoUnit.SECONDS))
                .ignoring(Exception.class);

        webElement= (WebElement) wait.until((Function<WebDriver, WebElement>) driver -> webElement);
        System.out.println("wait for me : "+(new Date().getTime()-start));
    }
}


