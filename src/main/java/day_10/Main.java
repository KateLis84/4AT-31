package day_10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        String driverPath = "driver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        WebDriver driver = new ChromeDriver();
        driver.get("https://coolors.co");

        //*[@id="homepage_hero_text_btns"]/a[1]
        WebElement generatePaletteButton = driver.
                findElement(By.xpath("//*[@id=\"homepage_hero_text_btns\"]/a[1]"));
        System.out.println(generatePaletteButton);

        System.out.println(generatePaletteButton.getText());
        System.out.println(generatePaletteButton.getAccessibleName());
        System.out.println(generatePaletteButton.getRect().x + " " +generatePaletteButton.getRect().y);
        generatePaletteButton.click();

        driver.close();
        driver.quit();
    }
}
