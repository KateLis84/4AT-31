package day_12;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.EdgeDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class BrowserFactory {

    public static final ThreadLocal <WebDriver> INSTANCE = new InheritableThreadLocal<>();

    public static WebDriver getChromedriver() {
        if(null == INSTANCE.get()) {
//            System.setProperty("webdriver.chrome.driver", "driver"+ File.separator+"chromedriver");
            ChromeDriverManager.getInstance().setup();
            INSTANCE.set(new ChromeDriver());

        }
        return INSTANCE.get();
    }

    public static WebDriver getFirefoxdriver() {
        if(null == INSTANCE.get()) {
            EdgeDriverManager.getInstance().setup();
            INSTANCE.set(new EdgeDriver());

        }
        return INSTANCE.get();
    }
}
