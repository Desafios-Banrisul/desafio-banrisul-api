import static io.restassured.RestAssured.given;
import org.junit.jupiter.api.Test;
import testBases.EditarContatoTestBase;

public class PutEditarContato extends EditarContatoTestBase {
    @Test
    public void editarContato(){
        given()
                .spec(requestSpec)
                .log().all()
                .when()
                .put()
                .then()
                .log().all()
                .spec(responseSpec);
    }
}
