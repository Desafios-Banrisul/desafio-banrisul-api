package testBases;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import models.EditarContatoModel;
import org.junit.jupiter.api.BeforeAll;
import utilitarios.FakerGenerator;

public class EditarContatoTestBase {
    protected static RequestSpecification requestSpec;
    protected static ResponseSpecification responseSpec;
    private static EditarContatoModel pojoObjeto;

    @BeforeAll
    public static void setUp() {
        buildPojoObjetc();
        buildRequestSpec();
        buildResponseSpec();
    }
    public static void buildRequestSpec() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://api-de-tarefas.herokuapp.com")
                .setBasePath("/contacts/1301")
                .addHeader("Content-Type", "application/json")
                .setBody(pojoObjeto)
                .build();
    }

    public static void buildResponseSpec() {
        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();
    }

    public static void buildPojoObjetc() {
        pojoObjeto = new EditarContatoModel(

                FakerGenerator.getName(),
                FakerGenerator.getLastName(),
                FakerGenerator.getEmail(),
                "35",
                FakerGenerator.getPhone(),
                FakerGenerator.getAddress(),
                FakerGenerator.getState(),
                FakerGenerator.getCity()
        );
    }
}
