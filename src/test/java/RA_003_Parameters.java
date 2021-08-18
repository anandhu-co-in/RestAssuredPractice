import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RA_003_Parameters {

    @Test
    public void simpleGetWithQueryParameters(){

        baseURI="https://reqres.in/api/";

        given().
                param("page","2"). //This will append at end with that questions mark -- querry parameter something
                get("users").
        then().
                statusCode(200).
                body("data.first_name",hasItems("Michael")).//There should be an item in data with firstname Michael
                log().all();
    }


    @Test
    public void PostRequetHereWeneedtoAddaBody(){

        baseURI="https://reqres.in/api/";
        JSONObject request=new JSONObject();
        request.put("name","Raghav");
        request.put("job","Teacher");
        String bodyJSONasString=request.toJSONString();
        System.out.println(bodyJSONasString);

        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(bodyJSONasString).
        when().
                post("users").
        then().
                statusCode(201).
                body("name",equalTo("Raghav")).
                log().all();
    }

}
