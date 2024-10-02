package example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.concurrent.*;


public class APITest{

    public APITest() throws ExecutionException, InterruptedException, TimeoutException {
    }

    @Test
    public void apiTest() throws Exception {

        RestAssured.baseURI = "https://apilayer.net/api/validate";
        String number = "+14158586273";

        RequestExecutor executor = new RequestExecutor();
        executor.executeParallelRun(3, number);

    }
}


