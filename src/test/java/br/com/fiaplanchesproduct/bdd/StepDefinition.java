package br.com.fiaplanchesproduct.bdd;

import br.com.fiaplanchesproduct.application.dtos.ProductDto;
import br.com.fiaplanchesproduct.application.dtos.RequestProductDto;
import br.com.fiaplanchesproduct.domain.Product;
import br.com.fiaplanchesproduct.domain.enums.Category;
import br.com.fiaplanchesproduct.infra.repository.PostGresProductRepository;
import br.com.fiaplanchesproduct.infra.repository.entity.ProductEntity;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.math.BigDecimal;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class StepDefinition {

    @Autowired
    private PostGresProductRepository productRepository;

    private Response response;

    private ProductDto productDto;

    private ProductDto newProductDto;

    private final String ENDPOINT = "http://localhost:8082/v1/product";

    @Before
    public void setUp() {
        RestAssured.baseURI = "http://localhost:" + 8082;
        productRepository.deleteAll();

        System.out.println("Including Data.....");

        ProductEntity p1 = new ProductEntity(1L,
                "Hamburguer",new BigDecimal("10.00"), Category.LANCHE);
        ProductEntity p2 = new ProductEntity(2L,
                "Coca",new BigDecimal("12.00"), Category.BEBIDA);
        ProductEntity p3 = new ProductEntity(3L,
                "Fritas",new BigDecimal("15.00"), Category.ACOMPANHAMENTO);
        ProductEntity p4 = new ProductEntity(4L,
                "Mousse",new BigDecimal("16.00"), Category.SOBREMESA);

        productRepository.saveAll(List.of(p1, p2, p3, p4));

        System.out.println("data Included.....");
    }

    @Dado("o produto {word} de Id {int} e preco {double} e Categoria {word}")
    public void oProdutoHamburguerDeIdEPrecoECategoriaLANCHE(String produto, int id, double preco, String categoria ) {
        productDto = new ProductDto((long) id, produto, new BigDecimal(preco), Category.valueOf(categoria));
    }

    @Quando("for realizada a chamada no endpoint de registro de produto")
    public void forRealizadaAChamadaNoEndpointDeRegistroDeProduto() {

        response = given()
                    .body(new RequestProductDto(productDto.nomeProduto(), productDto.preco(), productDto.category()))
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                .when()
                    .post(ENDPOINT + "/register");

        response.then().assertThat().statusCode(HttpStatus.CREATED.value());
    }

    @Quando("for realizada a chamada no endpoint de busca de produto por categoria")
    public void forRealizadaAChamadaNoEndpointDeBuscaDeProdutoPorCategoria() {

        var url = ENDPOINT + "/find/" + productDto.toProduct().getCategory();

        response =
                given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                .when()
                    .get(url);

        System.out.println(url);

        response.then().assertThat().statusCode(HttpStatus.OK.value());
    }

    @Entao("o produto deve ser localizado com sucesso na base")
    public void oProdutoDeveSerLocalizadoComSucessoNaBase() {

        List<ProductEntity> productEntityList = productRepository.findByCategory(productDto.category());

        var product = productEntityList.stream().filter(x -> x.getCategory() == productDto.category()).findFirst();

        System.out.println(product.get().getCategory());

        assertEquals(productDto.category(), product.get().getCategory());
    }

    @Quando("for realizada a chamada no endpoint de atualizar produto")
    public void forRealizadaAChamadaNoEndpointDeAtualizarProduto() {

        var url = ENDPOINT + "/update/" + 1;

        System.out.println(url);

        response =
                given()
                        .body(new RequestProductDto(newProductDto.nomeProduto(), newProductDto.preco(), newProductDto.category()))
                        .contentType(ContentType.JSON)
                        .accept(ContentType.JSON)
                        .when()
                        .put(url);

        response.then().assertThat().statusCode(HttpStatus.OK.value());
    }

    @E("o produto será alterado para {word} de Preco {double} e Categoria {word}")
    public void oProdutoSeráAlteradoParaCocaDePrecoECategoriaBEBIDA(String produto, double preco, String categoria) {
        newProductDto = new ProductDto(productDto.id(), produto, new BigDecimal(preco), Category.valueOf(categoria));

    }
}
