package itstep_aqa.Framework;

import day_13.CustomSuiteListener;
import day_13.CustomTestListener;
import day_14.AllureTestListener;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import FrameworkDir.ApiBO;


@Listeners({
        CustomTestListener.class,
        CustomSuiteListener.class,
        AllureTestListener.class
})
public class MainApiTest {

    ApiBO apiBO = new ApiBO();

    @Test
    void apiGetTest(){
        //Step 1 get all users
        Integer listSize = apiBO.apiGet("http://localhost:3000/users");
        //Step 2 check length
        apiBO.checkLength(listSize, 0);
    }

    @DataProvider()
    public static Object[][] newUsers() {
        return new Object[][]{
                {"{\"name\": \"Kate\", \"LastName\": \"Lias\", \"email\": \"Lias@gmail.com\", \"age\": 20}"},
                {"{\"name\": \"Nadia\", \"LastName\": \"Redik\", \"email\": \"red@gmail.com\", \"age\": 20}"},
                {"{\"name\": \"Tonik\", \"LastName\": \"Vas\", \"email\": \"they@gmail.com\", \"age\": 18}"},
                {"{\"name\": \"Maks\", \"LastName\": \"Chap\", \"email\": \"len@gmail.com\", \"age\": 19}"},
                {"{\"name\": \"Error\", \"LastName\": \"ToBeDeleted\", \"email\": \"delete@gmail.com\", \"age\": 0}"},
                {"{\"name\": \"M3\", \"LastName\": \"Tr\", \"email\": \"gy@gmail.com\", \"age\": 30}"},
        };
    }
    @Test(dataProvider = "newUsers")
    void apiAddTest(String newUser){
        //Step 1 get current lrngth
        Integer listSize = apiBO.apiGet("http://localhost:8000/users");
        //Step 2 add user
        apiBO.apiAdd(newUser);
        //Step 3 get updated length
        Integer newListSize = apiBO.apiGet("http://localhost:8000/users");
        //Step 4 check 2 lengths
        apiBO.checkLength(listSize+1, newListSize);
    }

    @Test
    void apiDeleteTest(){
        //Step 1 get current size
        Integer listSize = apiBO.apiGet("http://localhost:8000/users");
        //Step 2 delete User
        apiBO.deleteUser(5);
        //Step 3 get new size
        Integer newListSize = apiBO.apiGet("http://localhost:8000/users");
        //Step 4 compare sizes
        apiBO.checkLength(listSize-1, newListSize);
    }


    @Test
    void apiUpdateTest(){
        //Step 1 Updating info
        apiBO.updateUser("{\"name\": \"Daryna\"}", 1);
        //Step 2 getting new info
        String newName = apiBO.getKey("name", apiBO.getOneUser(6));
        //Step 3 checking new info
        Assert.assertEquals(newName, "Daryna");
    }

    @DataProvider()
    public static Object[][] UpdateData() {
        return new Object[][]{
                {"name", "NEW_NAME_3", 3},
                {"email", "NEW_EMAIL_4", 4},
                {"LastName", "NEW_LASTNAME_6", 6},
        };
    }
    @Test(dataProvider = "UpdateData")
    void updateManyTest(String key, String new_value, Integer id){
        //Step 1 Updating info
        apiBO.updateUser("{\""+key+"\": \""+new_value+"\"}", id);
        //Step 2 getting new info
        String updated = apiBO.getKey(key, apiBO.getOneUser(id));
        //Step 3 checking new info
        Assert.assertEquals(updated, new_value);
    }
}
