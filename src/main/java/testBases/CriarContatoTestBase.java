package testBases;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import models.CriarContatoModel;
import org.junit.jupiter.api.BeforeAll;
import utilitarios.FakerGenerator;
import utilitarios.FileOperations;

import java.io.IOException;

public class CriarContatoTestBase {
    protected static RequestSpecification requestSpec;
    protected static ResponseSpecification responseSpec;
    private static CriarContatoModel objeto;
    protected String id;

    @BeforeAll
    public static void setUp() throws IOException {
        buildPojoObjetc();
        buildRequestSpec();
        buildResponseSpec();
    }

    public static void buildRequestSpec() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://api-de-tarefas.herokuapp.com")
                .setBasePath("/contacts")
                .addHeader("Content-Type", "application/json")
                .setBody(objeto)
                .build();
    }

    public static void buildResponseSpec() {
        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(201)
                .expectContentType(ContentType.JSON)
                .build();
    }

    public static void buildPojoObjetc() throws IOException {

        String name = FakerGenerator.getName();
        String lastName = FakerGenerator.getLastName();
        String email = FakerGenerator.getEmail();
        String age = FakerGenerator.getAge();
        String phone = FakerGenerator.getPhone();
        String address = FakerGenerator.getAddress();
        String state = FakerGenerator.getState();
        String city = FakerGenerator.getCity();

        objeto = new CriarContatoModel(
                name,
                lastName,
                email,
                age,
                phone,
                address,
                state,
                city
        );

        FileOperations.setPropriedade("contact", "name", name);
        FileOperations.setPropriedade("contact", "lastName", lastName);
        FileOperations.setPropriedade("contact", "email", email);
        FileOperations.setPropriedade("contact", "age", age);
        FileOperations.setPropriedade("contact", "phone", phone);
        FileOperations.setPropriedade("contact", "address", address);
        FileOperations.setPropriedade("contact", "state", state);
        FileOperations.setPropriedade("contact", "city", city);
    }
}
