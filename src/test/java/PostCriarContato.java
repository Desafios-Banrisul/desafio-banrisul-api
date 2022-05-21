import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import testBases.CriarContatoTestBase;
import utilitarios.FileOperations;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class PostCriarContato extends CriarContatoTestBase {
    @Test
    public void criarContatoExtraindoId() throws IOException {
        id =
                given()
                        .spec(requestSpec)
                        .log().all()
                        .when()
                        .post()
                        .then()
                        .log().all()
                        .spec(responseSpec).extract().path("data.id");

        FileOperations.setPropriedade("contact", "id", id);

        deletaContato();
    }

    @Test
    public void criarContatoFazendoTesteDeContrato(){
        Response payload =
                given()
                        .spec(requestSpec)
                        .log().all()
                        .when()
                        .post()
                        .then()
                        .log().all()
                        .spec(responseSpec).extract().response();

        id = payload.then().extract().path("data.id");
        String nomeDaResposta = payload.then().extract().path("data.attributes.name");
        String nomeGuardado = FileOperations.getPropriedade("contact").getProperty("name");
        Assertions.assertEquals(nomeGuardado,nomeDaResposta);

        deletaContato();

//        payload.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("resouces/test/resources/schemas/CriarContatoJsonSchema.json"));
    }

    public void deletaContato(){
        given().when().delete("https://api-de-tarefas.herokuapp.com/contacts/" + id).then();
    }
}
