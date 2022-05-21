package testBases;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;

public class DeletarContatoTestBase {
    protected static RequestSpecification requestSpec;
    protected static ResponseSpecification responseSpec;
    private static final String id = "1317";

    @BeforeAll
    public static void setUp(){
        buildRequestSpec();
        buildResponseSpec();
    }

    public static void buildRequestSpec() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://api-de-tarefas.herokuapp.com")
                .setBasePath("/contacts/" + id)
                .build();
    }

    public static void buildResponseSpec() {
        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(204)
                .build();
    }
}
