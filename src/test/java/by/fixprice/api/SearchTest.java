package by.fixprice.api;

import by.fixprice.api.requests.SearchRequest;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.containsString;

public class SearchTest {
    @BeforeEach
    public void setUp() {
        SearchRequest.initRequestSpecification();
    }

    @Test
    public void testSearch() {
        ValidatableResponse response = new SearchRequest().getResponseForRequestedData()
                .statusCode(200)
                .log().all()
                .body("title", containsString("Стиральный порошок"));
    }
}
