import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class BaseTest{

    public static final String BASE_URL = "https://api.github.com";

    @Test
    public void basicTest(){
        RestAssured.get(BASE_URL)
                   .then()
                   .statusCode(200);
    }

    @Test
    public void peek(){
        RestAssured.get(BASE_URL)
                .peek();
    }

    @Test
    public void prettyPeek(){
        RestAssured.get(BASE_URL)
                .prettyPeek();
    }

    public void genericHeader(){
        Response headerResponse = RestAssured.get(BASE_URL);
        assertEquals(headerResponse.getHeader("server"), "GitHub.com");
        assertEquals(headerResponse.getHeader("x-rateLimit-limit"),"60");

    }

    @Test
    public void convenienceMethods(){
        Response response = RestAssured.get(BASE_URL);
        assertEquals(response.getStatusCode(),200);
        assertEquals(response.getContentType(),"application/json; charset=utf-8");
    }

    @Test
    public void timeExample(){
        Response response = RestAssured.get(BASE_URL);
        System.out.println(response.getTime());
        System.out.println(response.getTimeIn(TimeUnit.MINUTES));
    }

    @Test
    public void basicValidatableExample(){
        RestAssured.get(BASE_URL)
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .assertThat()
                .header("x-rate-limit","60");
    }


}