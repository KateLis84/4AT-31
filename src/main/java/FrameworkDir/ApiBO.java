package FrameworkDir;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import FrameworkDir.ApiRequests;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import static io.restassured.RestAssured.given;

public class ApiBO {

    private static ApiRequests apiRequests = new ApiRequests();
    private static Integer listSize = 0;

    @Step
    public Integer apiGet(String url){
        Response response =  apiRequests.getMethod(url);
        JsonPath jsnPath = response.jsonPath();
        ArrayList arrayList = jsnPath.get();
        return arrayList.size();
    }

    @Step
    public void apiAdd(String newUser){
        apiRequests.postMethod(newUser);
    }

    @Step
    public void checkLength(Integer expected, Integer actual){
        Assert.assertEquals(expected, actual);
    }

    @Step
    public void deleteUser(Integer id){
        apiRequests.deleteMethod(id);
    }

    @Step
    public Response getOneUser(Integer id){
        return apiRequests.getMethod("http://localhost:8000/users/"+id);
    }

    @Step
    public void  updateUser(String info, Integer id){
        apiRequests.updateMethod(info, id);
    }

    @Step
    public String getKey(String key, Response newUser){
        JsonPath jsnPath = newUser.jsonPath();
        String keyValue = jsnPath.get(key);
        return keyValue;
    }

}
