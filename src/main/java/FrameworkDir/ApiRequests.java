package FrameworkDir;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class ApiRequests {

    public Response getMethod(String url){
        return RestAssured.get(url);
    }

    public void postMethod(String newUser){
        Response response = given().when().contentType(ContentType.JSON)
                .with().body(newUser)
                .when().post("http://localhost:8000/users");

    }

    public void deleteMethod(Integer id){
        given().when().contentType(ContentType.JSON)
                .when().delete("http://localhost:8000/users/"+id);
    }

    public void updateMethod(String info, Integer id){
        Response response = given().when().contentType(ContentType.JSON)
                .with().body(info)
                .when().patch("http://localhost:8000/users/" + id);
    }
}
