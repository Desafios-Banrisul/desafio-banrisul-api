import org.junit.jupiter.api.Test;
import testBases.ListarContatosTestBase;

import static io.restassured.RestAssured.given;

public class GetListarContatos extends ListarContatosTestBase {
    @Test
    public void deletarContato(){
        given()
                .spec(requestSpec)
                .when()
                .get()
                .then()
                .log().all()
                .spec(responseSpec);
    }
}
