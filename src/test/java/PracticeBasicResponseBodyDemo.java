import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PracticeBasicResponseBodyDemo {


        public static final String URL = ("https://api.github.com/");

        @Test
        public void matcherExample() {

                RestAssured.get(URL + "users/Pavlov83")
                        .then()
                        .body("url", response -> Matchers.containsString(
                                response.body().jsonPath().get("login")));

        }

        @DataProvider
        public Object[][] names(){
                return new Object[][]{
                        {"cultaudio"},
                        {"Pavlov83"}
                };
        }

        @Test(dataProvider = "names")
        public void complexBodyExampleWithDP(String name){
                RestAssured.get(URL + "users/" + name)
                        .then()
                        .body("url",response ->
                                Matchers.containsString(response.body()
                                        .jsonPath()
                                        .get("login")));
        }

}
