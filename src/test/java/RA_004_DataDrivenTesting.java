import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

//Run same test multiple times, with different data rows, provided by data provider function

public class RA_004_DataDrivenTesting {

    @DataProvider(name="mydataProvider")
    public Object[][] dataForTest(){

        return new Object[][] {
                {"ragav","teacher"},
                {"suresh","artist"}
        };
    }


    @Test(dataProvider = "mydataProvider")
    public void PostRequetHereWeneedtoAddaBody(String name, String job){

        baseURI="https://reqres.in/api/";
        JSONObject request=new JSONObject();
        request.put("name",name);
        request.put("job",job);
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
                body("name",equalTo(name)).
                log().all();
    }


}
