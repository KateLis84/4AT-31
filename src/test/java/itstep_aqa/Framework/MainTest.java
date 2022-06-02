package itstep_aqa.Framework;

import FrameworkDir.WattpadBO;
import com.automation.remarks.testng.UniversalVideoListener;
import com.automation.remarks.video.annotations.Video;
import day_12.BaseUITest;
import day_12.BrowserFactory;
import day_13.CustomSuiteListener;
import day_13.CustomTestListener;
import day_14.AllureTestListener;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import java.time.Duration;
import java.time.temporal.ChronoUnit;


@Listeners({
        CustomTestListener.class,
        CustomSuiteListener.class,
        //UniversalVideoListener.class,
        AllureTestListener.class
})
public class MainTest extends BaseUITest {
    private ThreadLocal<WebDriver> driver = new InheritableThreadLocal<>();
    @Test
    @Video
    void LoginCatlifeTest() {
        driver.set(new ChromeDriver());
        WebDriver driver = BrowserFactory.getChromedriver();
        driver.manage().timeouts().implicitlyWait(Duration.of(10, ChronoUnit.SECONDS));
        WattpadBO catLifeBO = new WattpadBO(
                driver
        );
        // Step 1 "Go to website"
        catLifeBO.goToHome();

        // Step 2 "Click"
        catLifeBO.loginClick();

        // Step 3 "verify"
        catLifeBO.verify();

        // Step 4 put Login
        catLifeBO.putLogin("kate_newAT", "12022002kate");
    }
    @Test
    void SearchCategoryTest() {
        driver.set(new ChromeDriver());
        WebDriver driver = BrowserFactory.getChromedriver();
        driver.manage().timeouts().implicitlyWait(Duration.of(10, ChronoUnit.SECONDS));
        WattpadBO catLifeBO = new WattpadBO(
                driver
        );
        // Step 1 "Go to website"
        catLifeBO.goToHome();
        // Step 2 "Click"
        catLifeBO.loginClick();
        // Step 3 "verify"
        catLifeBO.verify();
        // Step 4 put Login and password
        catLifeBO.putLogin("kate_newAT", "12022002kate");
        // Step 5 Search button
        catLifeBO.search();
        // Step 6 search genre
        catLifeBO.ClickGanre();
        //Step 7 varify search
        catLifeBO.verifyGanre();
    }
    @DataProvider()
    public static Object[][] SearchDataProvider() {
        return new Object[][]{
                {"Warrior cats"},
                {"She-ra"},
                {"[hgpegwgjdsjicjcnvue"}
        };
    }
    @Test(dataProvider = "SearchDataProvider")
    void SearchWattpadTest(String searchWord) {
        driver.set(new ChromeDriver());
        WattpadBO catLifeBO = new WattpadBO(
                driver.get()
        );
        // Step 1 "Go to website"
        catLifeBO.goToHome();
        // Step 2 "Click"
        catLifeBO.loginClick();
        // Step 3 "verify"
        catLifeBO.verify();
        // Step 4 put Login
        catLifeBO.putLogin("kate_newAT", "12022002kate");
        //Step 5 Input search word
        catLifeBO.inputSearch(searchWord);
        //Step 6 click search
        catLifeBO.search();

    }

    @Test
    void AddBook(){
        driver.set(new ChromeDriver());
        WebDriver driver = BrowserFactory.getChromedriver();
        driver.manage().timeouts().implicitlyWait(Duration.of(10, ChronoUnit.SECONDS));
        WattpadBO catLifeBO = new WattpadBO(
                driver
        );
        // Step 1 "Go to website"
        catLifeBO.goToHome();
        // Step 2 "Click"
        catLifeBO.loginClick();
        // Step 3 "verify"
        catLifeBO.verify();
        // Step 4 put Login
        catLifeBO.putLogin("kate_newAT", "12022002kate");
        //Step 5 Input search word
        catLifeBO.inputSearch("Warrior cats");
        //Step 6 click search
        catLifeBO.search();
        //Step 7 click on the book
        catLifeBO.chooseBook();
        //Step 8 Adding book to library
        catLifeBO.AddBookToLibrary();
        //Step 9 check if the book in the library
        catLifeBO.CheckTheBookInLibrary();
    }

    @Test
    void DeleteBook(){
        driver.set(new ChromeDriver());
        WebDriver driver = BrowserFactory.getChromedriver();
        driver.manage().timeouts().implicitlyWait(Duration.of(10, ChronoUnit.SECONDS));
        WattpadBO catLifeBO = new WattpadBO(
                driver
        );
        // Step 1 "Go to website"
        catLifeBO.goToHome();
        // Step 2 "Click"
        catLifeBO.loginClick();
        // Step 3 "verify"
        catLifeBO.verify();
        // Step 4 put Login
        catLifeBO.putLogin("kate_newAT", "12022002kate");
        //Step 9 check if the book in the library
        catLifeBO.CheckTheBookInLibrary();
        //Step 10 Delete the Book from library
        catLifeBO.DeleteBook();
    }
    @AfterTest
    void CloseDriver(){
        driver.get().quit();
        //driver.quit();
    }

    @Test
    void apiGetTest(){
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println("Response body: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(), 200);

    }
    @Test
    void apiPostTest(){
        Response response = given().when().contentType(ContentType.JSON)
                        .with().body("{\"name\": \"Kate\",\"job\": \"developer\"\n" +"}")
                        .when().post("https://reqres.in/api/users");

        response.then().assertThat().statusCode(201);
        System.out.println("Response: " + response.getBody().asString());
    }
    @Test
    void apiPutTest(){
        Response response = given().when().contentType(ContentType.JSON)
                .with().body("{\"name\": \"Kate\",\"job\": \"new_job\"\n" +"}")
                .when().put("https://reqres.in/api/users/2");

        response.then().assertThat().statusCode(200);
        System.out.println("Response: " + response.getBody().asString());
    }
    @Test
    void apiDeleteTest(){
        Response response = given().when().contentType(ContentType.JSON)
                .when().delete("https://reqres.in/api/users/2");

        response.then().assertThat().statusCode(204);
        System.out.println("Response: " + response.getBody().asString());
        System.out.println("StatusCose: " + response.getStatusCode());
    }
    @Test
    void apiGetSingleTest(){
        Response response = RestAssured.get("https://reqres.in/api/users/2");
        System.out.println("Response body: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
