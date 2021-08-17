import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class RA_001_Helloworld {

    @Test
    public void helloWorld(){

        Response response= RestAssured.get("https://jsonplaceholder.typicode.com/todos/1");
        System.out.println(response.asString());
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));
        System.out.println(response.getTime());
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test
    public void test2(){
        RestAssured.get("https://jsonplaceholder.typicode.com/todos/1").then().body("userId", equalTo(1));
    }

}
