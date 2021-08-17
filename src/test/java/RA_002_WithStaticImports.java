import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RA_002_WithStaticImports {

    @Test
    public void test(){

        given().
                get("https://reqres.in/api/users?page=2").
        then().
                statusCode(200).
                body("data.first_name",hasItems("Michael"));
    }

}
