package example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class RequestExecutor {
    public void executeParallelRun(int threadNumber, String phoneNumber) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executor = Executors.newFixedThreadPool(threadNumber);

        RequestBuilder requestBuilder = new RequestBuilder();
        List<Future<Response>> futures = new ArrayList<>();

        for (int i=1; i<=threadNumber;i++) {
            Callable<Response> apiCall = () -> requestBuilder.buildGetPhoneRequest(phoneNumber);
            futures.add(executor.submit(apiCall));
        }

        for (Future<Response> future : futures) {
            Response response = future.get();
            System.out.println("Response: " + response.getBody().asString());
        }

        executor.shutdown();
    }
}
