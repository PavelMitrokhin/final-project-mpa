package by.fixprice.api.requests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class SearchRequest {
    public static RequestSpecification requestSpecification;
    public static String searchUrl = "https://api.fix-price.by/buyer/v2/product/filter";

    public static void initRequestSpecification() {
        requestSpecification = new RequestSpecBuilder()

                .setBaseUri("https://api.fix-price.by/")
                .setBasePath("/buyer/v2/product/filter")
                .setContentType("application/json")
                .addHeader("x-city", "14")
                .build();
    }

    public ValidatableResponse getResponseForRequestedData() {
        ValidatableResponse response = given()
                .spec(SearchRequest.requestSpecification)
                .body("{\n" +
                        "    \"category\": [],\n" +
                        "    \"searchText\": \"стиральный порошок мара\",\n" +
                        "    \"filter\": {\n" +
                        "        \"brand\": [],\n" +
                        "        \"price\": []\n" +
                        "    }\n" +
                        "}")
                .when()
                .post()
                .then();
        return response;
    }
}
