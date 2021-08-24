import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class RA_004_JSONSchemaValidating {

    @Test
    public void test(){

        given().
                get("https://reqres.in/api/users?page=2").
                then().
                statusCode(200).
                assertThat().body(matchesJsonSchemaInClasspath("scheme.json")); //thils file is in target/text-classes, converted json response to schema using online site
    }

}

//Coudn't make it work, I am getting some error, resolving dependenies, related to some joda-time etc. Skipping for now
