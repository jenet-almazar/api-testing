package catalogueTest;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.IsEqual.equalTo;


public class catalogueTest {

    String name = "Carbon credits";

    @Test
    public void checkName ()
    {
        given().
        when().
                get("https://api.tmsandbox.co.nz/v1/Categories/6327/Details.json?catalogue=false").
        then().
                assertThat().
                body("Name", equalTo(name)).
                body("CanRelist",equalTo(true)).
                body("Promotions[1].Description", containsString("2x larger image"));
    }
}
