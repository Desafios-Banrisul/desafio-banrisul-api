import testBases.DeletarContatoTestBase;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class DeleteDeletarContato extends DeletarContatoTestBase {
    @Test
    public void deletarContato(){
        given()
                .spec(requestSpec)
                .when()
                .delete()
                .then()
                .log().all()
                .spec(responseSpec);
    }
}
