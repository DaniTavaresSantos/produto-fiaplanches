package br.com.fiaplanchesproduct.test.glue;

import br.com.fiaplanchesproduct.application.dtos.ProductDto;
import br.com.fiaplanchesproduct.application.dtos.RequestProductDto;
import br.com.fiaplanchesproduct.domain.Product;
import br.com.fiaplanchesproduct.domain.enums.Category;
import br.com.fiaplanchesproduct.infra.repository.PostGresProductRepository;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.core.Is;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.math.BigDecimal;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


public class ProductScenario extends BaseScenario{

    private final String PRODUCT_ENDPOINT = "http://localhost:8082/v1/product";
    private Response response;

    private Product product;

    @Autowired
    private PostGresProductRepository productRepository;

    @Dado("o produto {word} de Id {int} e preco {double} e Categoria {word}")
    public void oProdutoHamburguerDeIdEPrecoECategoriaLANCHE(String produto, long id, BigDecimal preco, Category categoria ) {
        product = new Product(id, produto, preco, categoria);
    }

    @Quando("for realizada a chamada no endpoint de registro de produto")
    public void forRealizadaAChamadaNoEndpointDeRegistroDeProduto() {

        cucumberContextHolder.setResponse(
                given()
                    .body(ProductDto.toProductDto(product))
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                .when()
                    .post(PRODUCT_ENDPOINT + "/register"));

        response.then().assertThat().statusCode(HttpStatus.OK.value());
        product = new Product();
    }

    @Entao("o produto deve ser registrado com sucesso na base")
    public void oProdutoDeveSerRegistradoComSucessoNaBase() {


    }

    @Quando("for realizada a chamada no endpoint de busca de produto por categoria")
    public void forRealizadaAChamadaNoEndpointDeBuscaDeProdutoPorCategoria() {
        cucumberContextHolder.setResponse(
                given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                .when()
                    .get(PRODUCT_ENDPOINT + "/" + product.getCategory()));

        response.then().assertThat().statusCode(HttpStatus.OK.value());
        product = new Product();
    }
}
