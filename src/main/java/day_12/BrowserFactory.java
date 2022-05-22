package day_12;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
}
